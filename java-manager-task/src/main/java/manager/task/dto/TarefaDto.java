package manager.task.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaDto {
	
    private String nome;
    private String descricao;
    private LocalDate dataVencimento;
    private Boolean ativo;	
}
