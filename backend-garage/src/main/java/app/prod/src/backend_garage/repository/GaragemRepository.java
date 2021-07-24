package app.prod.src.backend_garage.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_garage.entidade.Garagem;

@EnableScan()
public interface GaragemRepository extends CrudRepository<Garagem, String> {
	
	List<Garagem> findByTituloAnuncio(String tituloAnuncio);
}
