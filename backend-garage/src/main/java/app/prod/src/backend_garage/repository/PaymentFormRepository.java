package app.prod.src.backend_garage.repository;

import java.math.BigDecimal;
import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_garage.entity.PaymentForm;

@EnableScan()
public interface PaymentFormRepository extends CrudRepository<PaymentForm, String>{
	List<PaymentForm> findByValueRent(BigDecimal value);
}
