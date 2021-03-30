package app.prod.src.backend_register.business;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_register.entity.User;
import app.prod.src.backend_register.persistence.UserRepository;

@Service
public class RegisterService{
	
	private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final UserRepository usRepository;

    public RegisterService(UserRepository URepository){
        this.usRepository = URepository;
    }
    
    public List<User> getUser(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<User> lista = this.usRepository.findAll();
        if (lista == null) {
        	return new ArrayList<User>();
        }
        return IteratorUtils.toList(lista.iterator());
    }

    public User getUserById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando usuário com o codigo {}", id);
        }
        Optional<User> retorno = this.usRepository.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Usuário com o codigo "+ id +" nao encontrada");
        }
        return retorno.get();
    }
    
    public User getUserByNome(String nome){
        if(logger.isInfoEnabled()){
            logger.info("Buscando usuário com o nome {}", nome);
        }
        List<User> lista = this.usRepository.findByNome(nome);
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Usuário com o nome "+ nome +" nao encontrada");
        }
        return lista.get(0);
    }

    public User saveUser(User user){
        if(logger.isInfoEnabled()){
            logger.info("Salvando usuário com os detalhes {}",user.toString());
        }
        return this.usRepository.save(user);
    }
    
    public void deleteUser(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo usuário com id {}",id);
        }
        this.usRepository.deleteById(id);
    }

    public boolean isUserExists(User user){
    	Optional<User> retorno = this.usRepository.findById(user.getId());
        return retorno.isPresent() ? true:  false;
    }
}
