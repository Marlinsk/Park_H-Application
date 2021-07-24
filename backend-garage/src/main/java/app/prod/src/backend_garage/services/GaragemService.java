package app.prod.src.backend_garage.services;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_garage.entidade.Garagem;
import app.prod.src.backend_garage.repository.GaragemRepository;

@Service
public class GaragemService {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final GaragemRepository garagemRepository;

	public GaragemService(GaragemRepository garagemRepository) {
		this.garagemRepository = garagemRepository;
	}

	public List<Garagem> getGaragem() {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando todos os objetos");
		}

		Iterable<Garagem> lista = this.garagemRepository.findAll();

		if (lista == null) {
			return new ArrayList<Garagem>();
		}

		return IteratorUtils.toList(lista.iterator());
	}

	public Garagem getGaragemById(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando garagem com o código {}", id);
		}

		Optional<Garagem> back = this.garagemRepository.findById(id);

		if (!back.isPresent()) {
			throw new RuntimeException("Garagem com o código " + id + " não encontrada");
		}

		return back.get();
	}

	public Garagem getGaragemByTituloAnuncio(String tituloAnuncio) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando garagem com o número {}", tituloAnuncio);
		}

		List<Garagem> list = this.garagemRepository.findByTituloAnuncio(tituloAnuncio);

		if (list == null || list.isEmpty()) {
			throw new RuntimeException("Garagem com o número " + tituloAnuncio + " não encontrada");
		}

		return list.get(0);
	}

	public Garagem saveGaragem(Garagem garagem) {

		if (logger.isInfoEnabled()) {
			logger.info("Salvando garagem com os detalhes {}", garagem.toString());
		}

		return this.garagemRepository.save(garagem);
	}

	public void deleteGaragem(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Excluindo garagem com id {}", id);
		}

		this.garagemRepository.deleteById(id);
	}

	public boolean isGaragemExists(Garagem garagem) {

		Optional<Garagem> back = this.garagemRepository.findById(garagem.getId());

		return back.isPresent() ? true : false;
	}

	public boolean isGaragemExists(String id) {

		Optional<Garagem> back = this.garagemRepository.findById(id);

		return back.isPresent() ? true : false;
	}
}
