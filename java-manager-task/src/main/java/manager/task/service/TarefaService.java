package manager.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import manager.task.entity.Tarefa;
import manager.task.repository.TarefaRepository;

@Service
@RequiredArgsConstructor
public class TarefaService {
	
	@Autowired
	private final TarefaRepository tarefaRepository;
	
	public List<Tarefa> listarTodas(){
		return tarefaRepository.findAll();
	}
	
    public Tarefa buscarPorId(String id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public void salvarTarefa(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    public void excluirTarefa(String id) {
        tarefaRepository.deleteById(id);
    }	
}
