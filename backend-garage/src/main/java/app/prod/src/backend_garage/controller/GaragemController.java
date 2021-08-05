package app.prod.src.backend_garage.controller;

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

import app.prod.src.backend_garage.entidade.Garagem;
import app.prod.src.backend_garage.services.GaragemService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "cadastro-garagem")
public class GaragemController {
	
	private final GaragemService garagemService;

	public GaragemController(GaragemService garagemService) {
		this.garagemService = garagemService;
	}

	@GetMapping(value = "")
	public List<Garagem> getGaragem() {
		return garagemService.getGaragem();
	}

	@GetMapping(value = "{id}")
	public Garagem getGaragemById(@PathVariable String id) throws Exception {

		if (!ObjectUtils.isEmpty(id)) {
			return garagemService.getGaragemById(id);
		}

		throw new Exception("Garagem com codigo " + id + " nao encontrada");
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Garagem createAddressGarage(@RequestBody @NotNull Garagem garagem) throws Exception {
        if (garagem.getId() != null) {
        	throw new Exception("Não é possível criar um objeto com Id existente");
        }
		return garagemService.saveGaragem(garagem);
	}

	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Garagem updateAddressGarage(@PathVariable String id, @RequestBody @NotNull Garagem garagem)
			throws Exception {

		if (!id.equals(garagem.getId())) {
			throw new Exception("Codigo " + id + " não está correto");
		}

		if (!garagemService.isGaragemExists(garagem)) {
			throw new Exception("Garagem com codigo " + id + " não existe");
		}

		return garagemService.saveGaragem(garagem);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean updateAddressGarage(@PathVariable String id) throws Exception {

		if (!garagemService.isGaragemExists(id)) {
			throw new Exception("Garagem com codigo " + id + " não existe");
		}

		garagemService.deleteGaragem(id);

		return true;
	}
}