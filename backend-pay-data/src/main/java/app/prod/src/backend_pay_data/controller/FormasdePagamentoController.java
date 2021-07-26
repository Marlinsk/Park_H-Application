package app.prod.src.backend_pay_data.controller;

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

import app.prod.src.backend_pay_data.entity.FormasdePagamento;
import app.prod.src.backend_pay_data.services.FormasdePagamentoService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "payment-control")
public class FormasdePagamentoController {

	private final FormasdePagamentoService pagamentoService;

	public FormasdePagamentoController(FormasdePagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	@GetMapping(value = "")
	public List<FormasdePagamento> getFormasdePagamento() {
		return pagamentoService.getFormasdePagamento();
	}

	@GetMapping(value = "{id}")
	public FormasdePagamento getFormasdePagamentoById(@PathVariable String id) throws Exception {
		if (!ObjectUtils.isEmpty(id)) {
			return pagamentoService.getFormasdePagamentoById(id);
		}
		throw new Exception("Preço com codigo " + id + " nao encontrado");
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public FormasdePagamento createFormasdePagamento(@RequestBody @NotNull FormasdePagamento preco) throws Exception {
		return pagamentoService.saveFormasdePagamento(preco);
	}

	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public FormasdePagamento updateFormasdePagamento(@PathVariable String id, @RequestBody @NotNull FormasdePagamento preco) throws Exception {
		return pagamentoService.saveFormasdePagamento(preco);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean updateFormasdePagamento(@PathVariable String id) throws Exception {
		pagamentoService.deleteFormasdePagamento(id);
		return true;
	}
}
