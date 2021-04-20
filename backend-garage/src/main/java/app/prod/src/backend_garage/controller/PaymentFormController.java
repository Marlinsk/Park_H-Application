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

import app.prod.src.backend_garage.entity.PaymentForm;
import app.prod.src.backend_garage.services.PaymentFormServices;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "payment-form")
public class PaymentFormController {
      
	private final PaymentFormServices paymentFormServices;
	
	public PaymentFormController(PaymentFormServices paymentFormServices) {
		this.paymentFormServices = paymentFormServices;
	}
	
	@GetMapping(value = "")
	public List<PaymentForm> getPaymentForm() {
		return paymentFormServices.getPaymentForm();
	}
	
	@GetMapping(value = "{id}")
	public PaymentForm getPaymentFormById(@PathVariable String id) throws Exception {
		
		if (!ObjectUtils.isEmpty(id)) {
			return paymentFormServices.getPaymentFormById(id);
		}
		
		throw new Exception("Preço com codigo " + id + " nao encontrado");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PaymentForm createPaymentForm(@RequestBody @NotNull PaymentForm price) throws Exception {
		return paymentFormServices.savePaymentForm(price);
	}
	
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public PaymentForm updatePaymentForm(@PathVariable String id, @RequestBody @NotNull PaymentForm price) throws Exception {
		return paymentFormServices.savePaymentForm(price);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean updatePaymentForm(@PathVariable String id) throws Exception {
		
		paymentFormServices.deletePaymentForm(id);
		
		return true;
	}
}
