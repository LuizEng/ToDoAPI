package manager.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import manager.server.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findByNome(String nome);
}
