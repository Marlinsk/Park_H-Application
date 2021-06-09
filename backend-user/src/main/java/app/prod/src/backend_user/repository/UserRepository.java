package app.prod.src.backend_user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_user.entity.user;

public interface UserRepository extends CrudRepository<user, Long> { 
	
	List<user>findById(String id);
	 
     List<user>findByUsername(String username);
     
     List<user>findByStatename(String statename);
     
     List<user>findByCityname(String cityname);
     
}
