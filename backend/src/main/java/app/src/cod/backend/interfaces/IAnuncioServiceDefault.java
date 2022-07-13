package app.src.cod.backend.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import app.src.cod.backend.models.Anuncio;

public interface IAnuncioServiceDefault {
	
	public Anuncio save(Anuncio anuncio);
	public List<Anuncio> findAll();
	public Optional<Anuncio> findById(UUID id);
	public void delete(Anuncio anuncio);
	
}
