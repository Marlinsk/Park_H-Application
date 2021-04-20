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

import app.prod.src.backend_garage.entity.AboutGarage;
import app.prod.src.backend_garage.services.AboutGarageServices;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "about-garage")
public class AboutGarageController {

	private final AboutGarageServices aboutGarageServices;

	public AboutGarageController(AboutGarageServices aboutGarageServices) {
		this.aboutGarageServices = aboutGarageServices;
	}

	@GetMapping(value = "")
	public List<AboutGarage> getAboutGarage() {
		return aboutGarageServices.getAboutGarage();
	}
    
	@GetMapping(value = "{id}")
	public AboutGarage getAboutGarageById(@PathVariable String id) throws Exception {
		
		if (!ObjectUtils.isEmpty(id)) {
			return aboutGarageServices.getAboutGarageById(id);
		}
		
		throw new Exception("Preço com codigo " + id + " nao encontrado");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public AboutGarage createAboutGarage(@RequestBody @NotNull AboutGarage aboutGarage) throws Exception {
		return aboutGarageServices.saveAboutGarage(aboutGarage);
	}
	
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public AboutGarage updateAboutGarage(@PathVariable String id, @RequestBody @NotNull AboutGarage aboutGarage) throws Exception {
		return aboutGarageServices.saveAboutGarage(aboutGarage);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean updateAboutGarage(@PathVariable String id) throws Exception {
		
		aboutGarageServices.deleteAboutGarage(id);
		
		return true;
	}
}
