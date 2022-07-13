package app.src.cod.backend.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import app.src.cod.backend.models.Anuncio;

public interface IAnuncioServiceDefault {
	
	public Anuncio save(Anuncio anuncio);
	public Page<Anuncio> findAll(Pageable pageable);
	public Optional<Anuncio> findById(UUID id);
	public void delete(Anuncio anuncio);
	
}
