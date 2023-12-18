package manager.task.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "tarefas")
@Getter
@Setter
public class Tarefa {
		
	public Tarefa(String nome, String descricao, LocalDate dataVencimento, Boolean status) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.status = status;
	}	
	
	@Id
	private String id;
    private String nome;
    private String descricao;
    private LocalDate dataVencimento;
    private Boolean status;	
	
}
