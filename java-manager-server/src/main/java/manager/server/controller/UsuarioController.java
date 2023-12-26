package manager.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import manager.server.converter.UsuarioConverter;
import manager.server.dto.UsuarioDto;
import manager.server.service.UsuarioService;

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
