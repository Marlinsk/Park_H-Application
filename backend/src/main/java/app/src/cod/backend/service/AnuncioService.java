package app.src.cod.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.src.cod.backend.models.Anuncio;
import app.src.cod.backend.repositories.AnuncioRepository;

@Service
public class AnuncioService {
	
	private final AnuncioRepository anuncioRepository;
	
	public AnuncioService(AnuncioRepository anuncioRepository) {
		this.anuncioRepository = anuncioRepository;
	}

	@Transactional
	public Anuncio save(Anuncio anuncio) {
		return this.anuncioRepository.save(anuncio);
	}

	public List<Anuncio> findAll() {
		return anuncioRepository.findAll();
	}

	public Optional<Anuncio> findById(UUID id) {
		return anuncioRepository.findById(id);
	}

	@Transactional
	public void delete(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}

	public Optional<Anuncio> findByTituloAnuncio(String tituloAnuncio) {
		return anuncioRepository.findByTituloAnuncio(tituloAnuncio);
	}
}
