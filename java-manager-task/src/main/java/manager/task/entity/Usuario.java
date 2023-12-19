package manager.task.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "usuarios")
@Getter
@Setter
public class Usuario {
		
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}	
	
	@Id
	private String id;
    private String nome;
    private String senha;

	
}
