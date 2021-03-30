package app.prod.src.backend_register.persistence;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_register.entity.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
	List<User> findByNome(String nome);
}
