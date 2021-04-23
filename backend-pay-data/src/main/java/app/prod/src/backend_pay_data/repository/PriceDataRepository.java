package app.prod.src.backend_pay_data.repository;

import java.math.BigDecimal;
import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_pay_data.entity.PaymentForm;

@EnableScan()
public interface PriceDataRepository extends CrudRepository<PaymentForm, String> {

	List<PaymentForm> findByValueRent(BigDecimal value);
    
}
