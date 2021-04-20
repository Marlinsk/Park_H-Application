package app.prod.src.backend_garage.services;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.prod.src.backend_garage.entity.DataAddressGarage;
import app.prod.src.backend_garage.repository.AddressRepository;


@Service
public class AddressServices {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final AddressRepository addressRepo;

	public AddressServices(AddressRepository addressRepository) {
		this.addressRepo = addressRepository;
	}

	public List<DataAddressGarage> getAddressGarage() {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando todos os objetos");
		}

		Iterable<DataAddressGarage> lista = this.addressRepo.findAll();

		if (lista == null) {
			return new ArrayList<DataAddressGarage>();
		}

		return IteratorUtils.toList(lista.iterator());
	}

	public DataAddressGarage getAddressGarageById(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando garagem com o codigo {}", id);
		}

		Optional<DataAddressGarage> back = this.addressRepo.findById(id);

		if (!back.isPresent()) {
			throw new RuntimeException("Garagem com o codigo " + id + " não encontrada");
		}

		return back.get();
	}

	public DataAddressGarage getAddressGarageByNumber(String num) {

		if (logger.isInfoEnabled()) {
			logger.info("Buscando garagem com o número {}", num);
		}

		List<DataAddressGarage> list = this.addressRepo.findByAddressnumber(num);

		if (list == null || list.isEmpty()) {
			throw new RuntimeException("Garagem com o número " + num + " não encontrada");
		}

		return list.get(0);
	}

	public DataAddressGarage saveAddressGarage(DataAddressGarage addressgarage) {

		if (logger.isInfoEnabled()) {
			logger.info("Salvando garagem com os detalhes {}", addressgarage.toString());
		}

		return this.addressRepo.save(addressgarage);
	}

	public void deleteAddressGarage(String id) {

		if (logger.isInfoEnabled()) {
			logger.info("Excluindo garagem com id {}", id);
		}

		this.addressRepo.deleteById(id);
	}

	public boolean isAddressGarageExists(DataAddressGarage addressgarage) {

		Optional<DataAddressGarage> back = this.addressRepo.findById(addressgarage.getId());

		return back.isPresent() ? true : false;
	}

	public boolean isAddressGarageExists(String id) {

		Optional<DataAddressGarage> back = this.addressRepo.findById(id);

		return back.isPresent() ? true : false;
	}
}
