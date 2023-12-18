package manager.task.converter;

import manager.task.dto.TarefaDto;
import manager.task.entity.Tarefa;

public class TarefaConverter {

	public Tarefa mapToEntity(TarefaDto dto) {
		return new Tarefa(dto.getNome(), dto.getDescricao(), dto.getDataVencimento(), dto.getStatus());
	}
}
