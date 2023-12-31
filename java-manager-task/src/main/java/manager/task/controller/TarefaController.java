package manager.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import manager.task.client.AuthServiceClient;
import manager.task.converter.TarefaConverter;
import manager.task.dto.TarefaDto;
import manager.task.entity.Tarefa;
import manager.task.service.TarefaService;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    
	@Autowired
	private final TarefaService tarefaService;

	private final TarefaConverter tarefaConverter;
	
	@Autowired
    private AuthServiceClient authServiceClient;
	
    @GetMapping
    public List<Tarefa> listarTodasTarefas(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        Boolean teste = false;
        
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        	teste = authServiceClient.validateToken(authorizationHeader.substring(7)); 
        }
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefaPorId(@PathVariable String id) {
        return tarefaService.buscarPorId(id);
    }

    @PostMapping
    public void criarTarefa(@RequestBody TarefaDto tarefa) {
        tarefaService.salvarTarefa(tarefaConverter.mapToEntity(tarefa));
    }

    @DeleteMapping("/{id}")
    public void excluirTarefa(@PathVariable String id) {
        tarefaService.excluirTarefa(id);
    }
}
