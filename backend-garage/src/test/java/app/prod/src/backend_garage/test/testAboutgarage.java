package app.prod.src.backend_garage.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import app.prod.src.backend_garage.entity.AboutGarage;
import app.prod.src.backend_garage.repository.AboutGarageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, testAboutgarage.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testAboutgarage {
      
	private static Logger LOGGER = LoggerFactory.getLogger(testPayment.class);
	
	@Configuration
	@EnableDynamoDBRepositories(basePackageClasses = { AboutGarageRepository.class })
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
			return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
					.withRegion(Regions.US_EAST_1).build();
		}
	}
    
	@Autowired
	private AboutGarageRepository repository;
	
	@Test
	public void teste1Criacao() {
	
		LOGGER.info("Criando objetos...");
	
		AboutGarage d1 = new AboutGarage("Garagem de Bela nova", "Garagem com vaga para estacionar dois carros");
		repository.save(d1);
		
		AboutGarage d2 = new AboutGarage("Garagem de Bela nova", "Garagem com vaga para estacionar dois carros");
		repository.save(d2);
		
		AboutGarage d3 = new AboutGarage("Garagem de Bela nova", "Garagem com vaga para estacionar dois carros");
		repository.save(d3);
		
		AboutGarage d4 = new AboutGarage("Garagem de Bela nova", "Garagem com vaga para estacionar dois carros");
		repository.save(d4);
		
		Iterable<AboutGarage> lista = repository.findAll();
		assertNotNull(lista.iterator());
		
		for (AboutGarage aboutGarage : lista) {
			LOGGER.info(aboutGarage.toString());
		}
		LOGGER.info("Pesquisado um objeto");
		
		List<AboutGarage> result = repository.findByAdheadline("Garagem de Bela nova");
		assertEquals(result.size(), 4);
		LOGGER.info("Encontrado: {}", result.size());
		
	}
	
	@Test
	public void teste2Exclusao() {
		
		LOGGER.info("Excluindo objetos...");
		List<AboutGarage> result = repository.findByAdheadline("Garagem de Bela nova");
		
		for (AboutGarage aboutGarage : result) {
			LOGGER.info("Excluindo Cotacao id = "+ aboutGarage.getId());
			repository.delete(aboutGarage);
		}
		
		result = repository.findByAdheadline("Garagem de Bela nova");
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
}
