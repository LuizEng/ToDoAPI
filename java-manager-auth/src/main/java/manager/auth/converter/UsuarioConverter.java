package manager.auth.converter;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import manager.auth.dto.UsuarioDto;
import manager.auth.entity.Usuario;
import manager.auth.repository.UsuarioRepository;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {
	
	private final UsuarioRepository usuarioRepository;
	
	
	public Usuario mapToEntityInsert(UsuarioDto dto) {
		return new Usuario(dto.getNome(), dto.getSenha());
	}
	
	public Usuario mapToEntityUpdate(UsuarioDto dto) {
		Usuario ent = usuarioRepository.findByNome(dto.getNome());
		if (!dto.getSenha().isBlank())
			ent.setSenha(dto.getSenha());
		return ent;
	}
	
	public UsuarioDto mapToDto(Usuario ent) {
		return new UsuarioDto(ent.getNome(), "");
	}
}
