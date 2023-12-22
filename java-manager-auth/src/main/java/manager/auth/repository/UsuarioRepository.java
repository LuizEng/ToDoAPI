package manager.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import manager.auth.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findByNome(String nome);
}
