package app.src.cod.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.src.cod.backend.interfaces.IAnuncioServiceDefault;
import app.src.cod.backend.models.Anuncio;
import app.src.cod.backend.repositories.AnuncioRepository;

@Service
public class AnuncioService implements IAnuncioServiceDefault {
	
	private final AnuncioRepository anuncioRepository;
	
	public AnuncioService(AnuncioRepository anuncioRepository) {
		this.anuncioRepository = anuncioRepository;
	}

	@Transactional
	@Override
	public Anuncio save(Anuncio anuncio) {
		return this.anuncioRepository.save(anuncio);
	}

	@Override
	public List<Anuncio> findAll() {
		return anuncioRepository.findAll();
	}

	@Override
	public Optional<Anuncio> findById(UUID id) {
		return anuncioRepository.findById(id);
	}

	@Transactional
	@Override
	public void delete(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}
}
