package app.prod.src.backend_pay_data.repository;

import java.math.BigDecimal;
import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import app.prod.src.backend_pay_data.entity.FormasdePagamento;

@EnableScan()
public interface FormasdePagamentoRepository extends CrudRepository<FormasdePagamento, String> {

	List<FormasdePagamento> findByPreco(BigDecimal preco);
    
}
