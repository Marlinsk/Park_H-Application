package app.src.cod.backend.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.src.cod.backend.dtos.AnuncioDTO;
import app.src.cod.backend.models.Anuncio;
import app.src.cod.backend.service.AnuncioService;

@RestController
@RequestMapping("/park-h")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnuncioController {

	private final AnuncioService anuncioService;

	public AnuncioController(AnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}
	
	@PostMapping("/criar-anuncio")
	public ResponseEntity<Object> criarAnuncio(@RequestBody @Valid AnuncioDTO anuncioDTO) {
		var anuncioModel = new Anuncio();
		BeanUtils.copyProperties(anuncioDTO, anuncioModel);
		anuncioModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(anuncioService.save(anuncioModel));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Anuncio>> buscarTodosAnuncios() {
		return ResponseEntity.status(HttpStatus.OK).body(anuncioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUmAnuncio(@PathVariable(value = "id") UUID id) {
		Optional <Anuncio> anuncioModelOptional = anuncioService.findById(id);
		if (!anuncioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anúncio não foi encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(anuncioModelOptional.get());
	}
	
	@GetMapping("/{tituloAnuncio}")
	public ResponseEntity<Object> pesquisarAnuncio(@RequestParam(value = "tituloAnuncio") String tituloAnuncio) {
		Optional <Anuncio> anuncioModelOptional = anuncioService.findByTituloAnuncio(tituloAnuncio);
		if (!anuncioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anúncio não foi encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(anuncioModelOptional.get());
	}
	
	@GetMapping("/busca-filtrada")
	public ResponseEntity<Object> filtrarPesquisa(@RequestParam(value = "tituloAnuncio", required = false) String tituloAnuncio, @RequestParam(value = "estado", required = false) String estado, @RequestParam(value = "cidade", required = false) String cidade, @RequestParam(value = "bairro", required = false) String bairro) {
		return ResponseEntity.status(HttpStatus.OK).body(anuncioService.findByFilter(tituloAnuncio, estado, cidade, bairro));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarAnuncio(@PathVariable(value = "id") UUID id, @RequestBody @Valid AnuncioDTO anuncioDTO) {
		Optional <Anuncio> anuncioModelOptional = anuncioService.findById(id);
		if (!anuncioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anúncio não foi encontrado.");
		}
		var anuncioModel = new Anuncio();
		BeanUtils.copyProperties(anuncioDTO, anuncioModel);
		anuncioModel.setId(anuncioModelOptional.get().getId());
		anuncioModel.setRegistrationDate(anuncioModelOptional.get().getRegistrationDate());
		return ResponseEntity.status(HttpStatus.OK).body(anuncioService.save(anuncioModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarAnuncio(@PathVariable(value = "id") UUID id) {
		Optional <Anuncio> anuncioModelOptional = anuncioService.findById(id);
		if (!anuncioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anúncio não foi encontrado.");
		}
		anuncioService.delete(anuncioModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Anúncio apagado com sucesso.");
	}
}
