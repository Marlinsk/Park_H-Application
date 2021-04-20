package app.prod.src.backend_garage.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_garage.entity.AboutGarage;

@EnableScan()
public interface AboutGarageRepository extends CrudRepository<AboutGarage, String> {
	List<AboutGarage> findByAdheadline(String adheadline);
}
