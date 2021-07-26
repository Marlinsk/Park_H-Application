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

import app.prod.src.backend_pay_data.entity.FormasdePagamento;
import app.prod.src.backend_pay_data.repository.FormasdePagamentoRepository;

@Service
public class FormasdePagamentoService {

	private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final FormasdePagamentoRepository formasdepagamentoRepository;
	
	public FormasdePagamentoService(FormasdePagamentoRepository formasdepagamentorepository) {
		this.formasdepagamentoRepository = formasdepagamentorepository;
	}
	
	 public List<FormasdePagamento> getFormasdePagamento(){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<FormasdePagamento> lista = this.formasdepagamentoRepository.findAll();
	        if (lista == null) {
	        	return new ArrayList<FormasdePagamento>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }    

	    public FormasdePagamento getFormasdePagamentoById(String id){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando preço com o código {}",id);
	        }
	        Optional<FormasdePagamento> retorno = this.formasdepagamentoRepository.findById(id);
	        if(!retorno.isPresent()){
	            throw new RuntimeException("Cotação com o id "+id+" não encontrado");
	        }
	        return retorno.get();
	    }
	    
	    public List<FormasdePagamento> getFormasdePagamentoByPreco(BigDecimal preco){
	    	if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<FormasdePagamento> lista = this.formasdepagamentoRepository.findByPreco(preco);
	        if (lista == null) {
	        	return new ArrayList<FormasdePagamento>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }
	    
	    public FormasdePagamento saveFormasdePagamento(FormasdePagamento preco){
	        if(logger.isInfoEnabled()){
	            logger.info("Salvando Cotacão com os detalhes {}",preco.toString());
	        }
	        return this.formasdepagamentoRepository.save(preco);
	    }
	    
	    public void deleteFormasdePagamento(String id){
	        if(logger.isInfoEnabled()){
	            logger.info("Excluindo Cotacão com id {}",id);
	        }
	        this.formasdepagamentoRepository.deleteById(id);
	    }

	    public boolean isFormasdePagamentoExists(FormasdePagamento preco){
	    	Optional<FormasdePagamento> retorno = this.formasdepagamentoRepository.findById(preco.getId());
	        return retorno.isPresent() ? true:  false;
	    }
}
