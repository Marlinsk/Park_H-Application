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

import app.prod.src.backend_pay_data.entity.PaymentForm;
import app.prod.src.backend_pay_data.services.PriceDataService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "payment-control")
public class PriceDataController {

	private final PriceDataService priceDataService;

	public PriceDataController(PriceDataService priceDataService) {
		this.priceDataService = priceDataService;
	}

	@GetMapping(value = "")
	public List<PaymentForm> getPriceData() {
		return priceDataService.getPriceData();
	}

	@GetMapping(value = "{id}")
	public PaymentForm getPaymentFormById(@PathVariable String id) throws Exception {
		if (!ObjectUtils.isEmpty(id)) {
			return priceDataService.getPriceDataById(id);
		}
		throw new Exception("Preço com codigo " + id + " nao encontrado");
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PaymentForm createPaymentForm(@RequestBody @NotNull PaymentForm price) throws Exception {
		return priceDataService.savePriceData(price);
	}

	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PaymentForm updatePriceData(@PathVariable String id, @RequestBody @NotNull PaymentForm price) throws Exception {
		return priceDataService.savePriceData(price);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean updatePriceData(@PathVariable String id) throws Exception {
		priceDataService.deletePriceData(id);
		return true;
	}
}
