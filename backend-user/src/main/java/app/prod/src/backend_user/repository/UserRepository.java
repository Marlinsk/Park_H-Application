package app.prod.src.backend_user.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_user.entity.user;

@EnableScan()
public interface UserRepository extends CrudRepository<user, String> { 

     List<user>findByUsername(String username);
     
     List<user>findByStatename(String statename);
     
     List<user>findByCityname(String cityname);
   
}
