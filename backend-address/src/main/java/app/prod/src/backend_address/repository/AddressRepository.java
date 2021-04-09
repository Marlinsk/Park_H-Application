package app.prod.src.backend_address.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_address.entity.AddressGarage;

@EnableScan()
public interface AddressRepository extends CrudRepository<AddressGarage, String> {
	List<AddressGarage> findByAddressnumber(String addressnumber);
}
