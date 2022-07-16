package app.src.cod.backend.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import app.src.cod.backend.models.Anuncio;

@Repository
public class AnuncioCustomRepository {
	
	private final EntityManager em;

	public AnuncioCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Anuncio> find(String tituloAnuncio, String estado, String cidade, String bairro) {
		
		String query = "SELECT A FROM Anuncio AS A";
		String conditional = " where";
		
		if (tituloAnuncio != null) {
			query += conditional + " A.tituloAnuncio = :tituloAnuncio";
			conditional = " and";
		}
		
		if (estado != null) {
			query += conditional + " A.estado = :estado";
			conditional = " and";
		}
		
		if (cidade != null) {
			query += conditional + " A.cidade = :cidade";
			conditional = " and";
		}
		
		if (bairro != null) {
			query += conditional + " A.bairro = :bairro";
		}
		
		var q = em.createQuery(query, Anuncio.class);
		
		if (tituloAnuncio != null) {
			q.setParameter("tituloAnuncio", tituloAnuncio);
		}
		
		if (estado != null) {
			q.setParameter("estado", estado);
		}
		
		if (cidade != null) {
			q.setParameter("cidade", cidade);
		}
		
		if (bairro != null) {
			q.setParameter("bairro", bairro);
		}
		
		return q.getResultList();
	}
}
