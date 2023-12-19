package manager.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import manager.task.converter.UsuarioConverter;
import manager.task.dto.UsuarioDto;
import manager.task.service.UsuarioService;

@RestController
@RequestMapping("/api/singup")
@RequiredArgsConstructor
public class UsuarioController {
    
	@Autowired
	private final UsuarioService usuarioService;

	private final UsuarioConverter usuarioConverter;
	

    @PostMapping
    public void criarUsuario(@RequestBody UsuarioDto usuarioDto) {
    	usuarioService.salvarUsuario(usuarioConverter.mapToEntityInsert(usuarioDto));
    }

}
