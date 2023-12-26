package manager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import manager.server.entity.Usuario;
import manager.server.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	@Autowired
	private final UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario) {
    	usuarioRepository.save(usuario);
    }

    public void excluirUsuario(String id) {
    	usuarioRepository.deleteById(id);
    }	
}