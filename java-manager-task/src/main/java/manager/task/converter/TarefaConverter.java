package manager.task.converter;

import org.springframework.stereotype.Component;

import manager.task.dto.TarefaDto;
import manager.task.entity.Tarefa;

@Component
public class TarefaConverter {

	public Tarefa mapToEntity(TarefaDto dto) {
		Tarefa ent = new Tarefa();
		ent.setNome(dto.getNome());		
		ent.setDescricao(dto.getDescricao());
		ent.setDataVencimento(dto.getDataVencimento());
		ent.setAtivo(dto.getAtivo());
		
		return ent;
	}
}
