package app.prod.src.backend_garage.services;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_garage.entity.PaymentForm;
import app.prod.src.backend_garage.repository.PaymentFormRepository;

@Service
public class PaymentFormServices {
	
	private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final PaymentFormRepository paymentFormRepository;
	
	public PaymentFormServices(PaymentFormRepository paymentFormRepository) {
		this.paymentFormRepository = paymentFormRepository;
	}
	
	public List<PaymentForm> getPaymentForm(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<PaymentForm> lista = this.paymentFormRepository.findAll();
        if (lista == null) {
        	return new ArrayList<PaymentForm>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

	public PaymentForm getPaymentFormById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando preço com o codigo {}",id);
        }
        Optional<PaymentForm> retorno = this.paymentFormRepository.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Preço com o id "+ id +" nao encontrada");
        }
        return retorno.get();
    }
	
	public List<PaymentForm> getPaymentFormByValueRent(BigDecimal value){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<PaymentForm> lista = this.paymentFormRepository.findByValueRent(value);
        if (lista == null) {
        	return new ArrayList<PaymentForm>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
	
	public PaymentForm savePaymentForm(PaymentForm paymentform){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Cotacao com os detalhes {}", paymentform.toString());
        }
        return this.paymentFormRepository.save(paymentform);
    }
	
    public void deletePaymentForm(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Cotacao com id {}",id);
        }
        this.paymentFormRepository.deleteById(id);
    }
}
