package app.src.cod.backend.service;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Anuncio> findAll(Pageable pageable) {
		return anuncioRepository.findAll(pageable);
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
