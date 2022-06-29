package app.src.cod.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.src.cod.entidade.AluguelGaragem;
import app.src.cod.services.ParkService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "cadastrar-aluguel")
public class ParkController {

	private final ParkService parkservice;
	
	public ParkController(ParkService parkservice) {
		this.parkservice = parkservice;
	}
	
	@GetMapping(value = "")
	public List<AluguelGaragem> getAnuncio(){
		return parkservice.getAnuncio();
	}
	
	@GetMapping(value = "{id}")
	public AluguelGaragem getAnuncioById(@PathVariable String id) throws Exception {
		if (!ObjectUtils.isEmpty(id)) {
			return parkservice.getAnuncioById(id); 
		}
		throw new Exception("Anúncio com código " + id + " nao encontrada");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public AluguelGaragem createAnuncio(@RequestBody @NotNull AluguelGaragem anuncio) throws Exception {
		if(anuncio.getId() != null) {
			throw new Exception("Não é possível criar um objeto com Id existente");
		}
		return parkservice.saveAluguelGaragem(anuncio);
	}
	
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public AluguelGaragem updateAnuncio(@PathVariable String id, @RequestBody @NotNull AluguelGaragem anuncio) throws Exception {
		if(!id.equals(anuncio.getId())) {
			throw new Exception("Codigo " + id + " não está correto");
		}
		if(!parkservice.isAnuncioExists(anuncio)) {
			throw new Exception("Garagem com codigo " + id + " não existe");
		}
		return parkservice.saveAluguelGaragem(anuncio);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean deleteAnuncio(@PathVariable String id) throws Exception {
		if(!parkservice.isAnuncioExists(id)) {
			throw new Exception("Garagem com codigo " + id + " não existe");
		}
		parkservice.deleteAluguelGaragem(id);
		
		return true;
	}
}
