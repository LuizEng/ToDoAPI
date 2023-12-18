package manager.task.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaDto {
	
	public TarefaDto(String nome, String descricao, LocalDate dataVencimento, Boolean status) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataVencimento = dataVencimento;
		this.status = status;
	}
	
    private String nome;
    private String descricao;
    private LocalDate dataVencimento;
    private Boolean status;	
}
