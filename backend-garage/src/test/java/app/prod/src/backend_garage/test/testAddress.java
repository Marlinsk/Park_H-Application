package app.prod.src.backend_garage.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import app.prod.src.backend_garage.entity.DataAddressGarage;
import app.prod.src.backend_garage.entity.StateName;
import app.prod.src.backend_garage.repository.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PropertyPlaceholderAutoConfiguration.class, testAddress.DynamoDBConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testAddress {
	private static Logger LOGGER = LoggerFactory.getLogger(testAddress.class);
	private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

	@Configuration
	@EnableDynamoDBRepositories(basePackageClasses = AddressRepository.class)
	public static class DynamoDBConfig {

		@Value("${amazon.aws.accesskey}")
		private String amazonAWSAccessKey;

		@Value("${amazon.aws.secretkey}")
		private String amazonAWSSecretKey;

		public AWSCredentialsProvider amazonAWSCredentialsProvider() {
			return new AWSStaticCredentialsProvider(amazonAWSCredentials());
		}

		@Bean
		public AWSCredentials amazonAWSCredentials() {
			return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
		}

		@Bean
		public AmazonDynamoDB amazonDynamoDB() {
			return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider()).withRegion(Regions.US_EAST_1).build();
		}
	}

	@Autowired
	private AddressRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {

		LOGGER.info("Criando objetos...");
		DataAddressGarage gar1 = new DataAddressGarage(StateName.MG.getfullnameState(), "Belo Horizonte", "Rua dos Guajajaras", "Centro de BH", "329 TESTE",df.parse("31/05/2017"));
		repository.save(gar1);

		DataAddressGarage gar2 = new DataAddressGarage(StateName.MG.getfullnameState(), "Belo Horizonte", "Rua Alagoas", "Bairro Alagoas", "329 TESTE", df.parse("25/07/2018"));
		repository.save(gar2);

		DataAddressGarage gar3 = new DataAddressGarage(StateName.MG.getfullnameState(), "Belo Horizonte", "Rua Sergipe", "Centro de BH", "329 TESTE", df.parse("25/07/2019"));
		repository.save(gar3);
	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		LOGGER.info("Pesquisado todos");
		Iterable<DataAddressGarage> lista = repository.findAll();
		assertNotNull(lista.iterator());

		for (DataAddressGarage addressGarage : lista) {
			LOGGER.info(addressGarage.toString());
		}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		LOGGER.info("Pesquisado um objeto");
		List<DataAddressGarage> result = repository.findByAddressnumber("329 TESTE");
		assertEquals(result.size(), 3);

		LOGGER.info("Encontrado: {}", result.get(0));

	}

	@Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo objetos...");
		List<DataAddressGarage> result = repository.findByAddressnumber("329 TESTE");
		for (DataAddressGarage addressGarage : result) {
			LOGGER.info("Excluindo Cotacao id = "+ addressGarage.getId());
			repository.delete(addressGarage);
		}
		result = repository.findByAddressnumber("329 TESTE");
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
}
