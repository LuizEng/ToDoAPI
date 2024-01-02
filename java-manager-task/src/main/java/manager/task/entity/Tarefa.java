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
		
	@Id
	private String id;
    private String nome;
    private String descricao;
    private LocalDate dataVencimento;
    private Boolean ativo;	
	
}
