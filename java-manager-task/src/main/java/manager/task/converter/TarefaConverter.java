package manager.task.converter;

import org.springframework.stereotype.Component;

import manager.task.dto.TarefaDto;
import manager.task.entity.Tarefa;

@Component
public class TarefaConverter {

	public Tarefa mapToEntity(TarefaDto dto) {
		return new Tarefa(dto.getNome(), dto.getDescricao(), dto.getDataVencimento(), dto.getStatus());
	}
}
