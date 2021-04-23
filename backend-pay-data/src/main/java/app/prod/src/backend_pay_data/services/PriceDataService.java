package app.prod.src.backend_pay_data.services;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_pay_data.entity.PaymentForm;
import app.prod.src.backend_pay_data.repository.PriceDataRepository;

@Service
public class PriceDataService {

	private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final PriceDataRepository pricedataRepository;
	
	public PriceDataService(PriceDataRepository pricedataRepository) {
		this.pricedataRepository = pricedataRepository;
	}
	
	 public List<PaymentForm> getPriceData(){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<PaymentForm> lista = this.pricedataRepository.findAll();
	        if (lista == null) {
	        	return new ArrayList<PaymentForm>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }    

	    public PaymentForm getPriceDataById(String id){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando preço com o codigo {}",id);
	        }
	        Optional<PaymentForm> retorno = this.pricedataRepository.findById(id);
	        if(!retorno.isPresent()){
	            throw new RuntimeException("Preço com o id "+id+" nao encontrada");
	        }
	        return retorno.get();
	    }
	    
	    public List<PaymentForm> getPriceDataByValueRent(BigDecimal value){
	    	if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<PaymentForm> lista = this.pricedataRepository.findByValueRent(value);
	        if (lista == null) {
	        	return new ArrayList<PaymentForm>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }
	    
	    public PaymentForm savePriceData(PaymentForm price){
	        if(logger.isInfoEnabled()){
	            logger.info("Salvando Cotacao com os detalhes {}",price.toString());
	        }
	        return this.pricedataRepository.save(price);
	    }
	    
	    public void deletePriceData(String id){
	        if(logger.isInfoEnabled()){
	            logger.info("Excluindo Cotacao com id {}",id);
	        }
	        this.pricedataRepository.deleteById(id);
	    }

	    public boolean isPriceDataExists(PaymentForm price){
	    	Optional<PaymentForm> retorno = this.pricedataRepository.findById(price.getId());
	        return retorno.isPresent() ? true:  false;
	    }
	    
	
	
}
