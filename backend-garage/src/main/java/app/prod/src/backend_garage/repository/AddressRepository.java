package app.prod.src.backend_garage.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_garage.entity.DataAddressGarage;

@EnableScan()
public interface AddressRepository extends CrudRepository<DataAddressGarage, String> {
	List<DataAddressGarage> findByAddressnumber(String addressnumber);
}
