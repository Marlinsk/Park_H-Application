package app.src.cod.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.src.cod.backend.models.Anuncio;
import app.src.cod.backend.repositories.AnuncioCustomRepository;
import app.src.cod.backend.repositories.AnuncioRepository;

@Service
public class AnuncioService {
	
	private final AnuncioRepository anuncioRepository;
	private final AnuncioCustomRepository anuncioCustomRepository;
	
	public AnuncioService(AnuncioRepository anuncioRepository, AnuncioCustomRepository anuncioCustomRepository) {
		this.anuncioRepository = anuncioRepository;
		this.anuncioCustomRepository = anuncioCustomRepository;
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
	
	public Optional<Anuncio> findByTituloAnuncio(String tituloAnuncio) {
		return anuncioRepository.findByTituloAnuncio(tituloAnuncio);
	}
	
	public List<Anuncio> findByFilter(String tituloAnuncio, String estado, String cidade, String bairro) {
		return anuncioCustomRepository.find(tituloAnuncio, estado, cidade, bairro).stream().collect(Collectors.toList());
	} 

	@Transactional
	public void delete(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}

}
