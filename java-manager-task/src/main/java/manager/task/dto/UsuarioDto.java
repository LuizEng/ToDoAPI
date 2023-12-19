package manager.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	
	public UsuarioDto(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
    private String nome;
    private String senha;

}
