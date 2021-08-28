package app.src.cod.services;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.src.cod.entidade.AluguelGaragem;
import app.src.cod.repository.ParkRepository;

@Service
public class ParkService {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final ParkRepository Parkrepository;

	public ParkService(ParkRepository Parkrepository) {
		this.Parkrepository = Parkrepository;
	}

	public List<AluguelGaragem> getAnuncio() {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando todos os objetos:");
		}
		Iterable<AluguelGaragem> lista = this.Parkrepository.findAll();
		if (lista == null) {
			return new ArrayList<AluguelGaragem>();
		}
		return IteratorUtils.toList(lista.iterator());
	}

	public AluguelGaragem getAnuncioById(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando anúncio com o código {}", id);
		}
		Optional<AluguelGaragem> back = this.Parkrepository.findById(id);
		if (!back.isPresent()) {
			throw new RuntimeException("Anúncio com o código " + id + " não encontrada");
		}
		return back.get();

	}

	public List<AluguelGaragem> getAnuncioByEstado(String estado) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando todos os objetos:");
		}
		Iterable<AluguelGaragem> lista = this.Parkrepository.findByEstado(estado);
		if (lista == null) {
			return new ArrayList<AluguelGaragem>();
		}
		return IteratorUtils.toList(lista.iterator());

	}

	public AluguelGaragem saveAluguelGaragem(AluguelGaragem anuncio) {
		if(logger.isInfoEnabled()) {
			logger.info("Salvando anúncio com os detalhes {}", anuncio.toString());
		}
		return this.Parkrepository.save(anuncio);
	}
	
	public void deleteAluguelGaragem(String id) {
		 if(logger.isInfoEnabled()){
	            logger.info("Excluindo anúncio com id {}",id);
	        }
		 this.Parkrepository.deleteById(id);
	}
	
	public boolean isAnuncioExists(AluguelGaragem anuncio) {
		Optional<AluguelGaragem> back = this.Parkrepository.findById(anuncio.getId());
		return back.isPresent() ? true : false;
	}
	
	public boolean isAnuncioExists(String id) {
		Optional<AluguelGaragem> back = this.Parkrepository.findById(id);
		return back.isPresent() ? true : false;
	}
	
}
