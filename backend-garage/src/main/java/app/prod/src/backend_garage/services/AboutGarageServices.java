package app.prod.src.backend_garage.services;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_garage.entity.AboutGarage;
import app.prod.src.backend_garage.repository.AboutGarageRepository;

@Service
public class AboutGarageServices {
	
	private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final AboutGarageRepository aboutGarageRepository;
	
	public AboutGarageServices(AboutGarageRepository aboutGarageRepository) {
		this.aboutGarageRepository = aboutGarageRepository;
	}
	
	public List<AboutGarage> getAboutGarage(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<AboutGarage> lista = this.aboutGarageRepository.findAll();
        if (lista == null) {
        	return new ArrayList<AboutGarage>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

	public AboutGarage getAboutGarageById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando preço com o codigo {}",id);
        }
        Optional<AboutGarage> retorno = this.aboutGarageRepository.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Preço com o id "+ id +" nao encontrada");
        }
        return retorno.get();
    }
	
	public List<AboutGarage> getAboutGarageByAdheadline(String adheadline){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<AboutGarage> lista = this.aboutGarageRepository.findByAdheadline(adheadline);
        if (lista == null) {
        	return new ArrayList<AboutGarage>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
	
	public AboutGarage saveAboutGarage(AboutGarage aboutGarage){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Cotacao com os detalhes {}",aboutGarage.toString());
        }
        return this.aboutGarageRepository.save(aboutGarage);
    }
	
    public void deleteAboutGarage(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Cotacao com id {}",id);
        }
        this.aboutGarageRepository.deleteById(id);
    }
	
}
