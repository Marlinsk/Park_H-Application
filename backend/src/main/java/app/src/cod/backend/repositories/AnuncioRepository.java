package app.src.cod.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.src.cod.backend.models.Anuncio;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, UUID> {
	
	Optional<Anuncio> findByTituloAnuncio(String tituloAnuncio);
	
}
