package manager.task.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import manager.task.entity.Tarefa;

public interface TarefaRepository extends MongoRepository<Tarefa, String>{

	List<Tarefa> findByNome(String nome);
}
