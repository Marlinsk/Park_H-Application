package app.prod.src.backend_user.services;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_user.entity.user;
import app.prod.src.backend_user.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final UserRepository userepository;
	
	public UserService(UserRepository userepository) {
		this.userepository = userepository;
	}

	public List<user> getAllUsers() {
		
		if (logger.isInfoEnabled()) {
			logger.info("Buscando todos os usuários");
		}
		Iterable<user> lista = this.userepository.findAll();
		if (lista == null) {
			return new ArrayList<user>();
		}
		return IteratorUtils.toList(lista.iterator());
	}
    
	//Busca usuário pelo ID
	public user getUserById(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando usuário com o código {}", id);
		}
		Optional<user> back = this.userepository.findById(id);
		if (!back.isPresent()) {
			throw new RuntimeException("Não existe usuário com o código " + id);
		}
		return back.get();
	}
		
	// Busca o usuário pelo nick
	public user getUserByUsername(String username) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando usuário {}", username);
		}
		List<user> lista = this.userepository.findByUsername(username);
		if (lista == null || lista.isEmpty()) {
			throw new RuntimeException("Usuário " + username + " não encontrada");
		}
		return lista.get(0);
	}
	
	// Busca o usuário pelo nome da cidade 
	public user getUserByCityname(String cityname) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando usuários na cidade {}", cityname);
		}
		List<user> lista = this.userepository.findByCityname(cityname);
		if (lista == null || lista.isEmpty()) {
			throw new RuntimeException("A cidade com o nome " + cityname + " não possui usuários");
		}
		return lista.get(0);
	}
	
	// Busca o usuário pelo nome do Estado
	public user getUserByStatename(String statename) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando usuários na cidade {}", statename);
		}
		List<user> lista = this.userepository.findByStatename(statename);
		if (lista == null || lista.isEmpty()) {
			throw new RuntimeException("Estado de " + statename + " não possuí usuários");
		}
		return lista.get(0);
	}
 	
	// Salva os dados do usuário
	public user saveUser(user user) {

		if (logger.isInfoEnabled()) {
			logger.info("Cadastrando usuário com os dados {}", user.toString());
		}
		return this.userepository.save(user);
	}
    
	// Deleta os dados do usuário como um todo
	public void deleteUser(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Excluindo garagem com id {}", id);
		}
		this.userepository.deleteById(id);
	}
	
	public boolean isUserExists(user user) {

		Optional<user> back = this.userepository.findById(user.getId());
		return back.isPresent() ? true : false;
	}

	public boolean isUserExists(String id) {

		Optional<user> back = this.userepository.findById(id);
		return back.isPresent() ? true : false;
	}
}