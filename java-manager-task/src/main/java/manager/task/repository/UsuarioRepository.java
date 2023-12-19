package manager.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import manager.task.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findByNome(String nome);
}
