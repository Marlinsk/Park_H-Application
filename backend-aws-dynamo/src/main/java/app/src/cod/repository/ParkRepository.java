package app.src.cod.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.src.cod.entidade.AluguelGaragem;

@EnableScan()
public interface ParkRepository extends CrudRepository<AluguelGaragem, String> {
	
	List<AluguelGaragem>findByEstado(String estado);
	
}
