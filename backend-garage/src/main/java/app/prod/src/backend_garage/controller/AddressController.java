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

import app.prod.src.backend_garage.entity.DataAddressGarage;
import app.prod.src.backend_garage.services.AddressServices;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "addressgarage")
public class AddressController {
	
	private final AddressServices addressService;

	public AddressController(AddressServices addressService) {
		this.addressService = addressService;
	}

	@GetMapping(value = "")
	public List<DataAddressGarage> getAddressGarage() {
		return addressService.getAddressGarage();
	}

	@GetMapping(value = "{id}")
	public DataAddressGarage getAddressGarageById(@PathVariable String id) throws Exception {

		if (!ObjectUtils.isEmpty(id)) {
			return addressService.getAddressGarageById(id);
		}

		throw new Exception("Garagem com codigo " + id + " nao encontrada");
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public DataAddressGarage createAddressGarage(@RequestBody @NotNull DataAddressGarage addressgarage) throws Exception {
        if (addressgarage.getId() != null) {
        	throw new Exception("Não é possível criar um objeto com Id existente");
        }
		return addressService.saveAddressGarage(addressgarage);
	}

	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public DataAddressGarage updateAddressGarage(@PathVariable String id, @RequestBody @NotNull DataAddressGarage addressgarage)
			throws Exception {

		if (!id.equals(addressgarage.getId())) {
			throw new Exception("Codigo " + id + " não está correto");
		}

		if (!addressService.isAddressGarageExists(addressgarage)) {
			throw new Exception("Garagem com codigo " + id + " não existe");
		}

		return addressService.saveAddressGarage(addressgarage);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean updateAddressGarage(@PathVariable String id) throws Exception {

		if (!addressService.isAddressGarageExists(id)) {
			throw new Exception("Garagem com codigo " + id + " não existe");
		}

		addressService.deleteAddressGarage(id);

		return true;
	}
}
