package app.prod.src.backend_garage.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
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

import app.prod.src.backend_garage.entity.PaymentForm;
import app.prod.src.backend_garage.entity.PaymentType;
import app.prod.src.backend_garage.repository.PaymentFormRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, testPayment.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testPayment {
	private static Logger LOGGER = LoggerFactory.getLogger(testPayment.class);
	
	@Configuration
	@EnableDynamoDBRepositories(basePackageClasses = { PaymentFormRepository.class })
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
	private PaymentFormRepository repository;
	
	@Test
	public void teste1Criacao() throws ParseException {
	
		LOGGER.info("Criando objetos...");
	
		PaymentForm payment1 = new PaymentForm(BigDecimal.valueOf(112.00), PaymentType.MONTHLY.gettypePayment());
		repository.save(payment1);
		
		PaymentForm payment2 = new PaymentForm(BigDecimal.valueOf(112.00), PaymentType.MONTHLY.gettypePayment());
		repository.save(payment2);
		
		PaymentForm payment3 = new PaymentForm(BigDecimal.valueOf(112.00), PaymentType.MONTHLY.gettypePayment());
		repository.save(payment3);
		
		PaymentForm payment4 = new PaymentForm(BigDecimal.valueOf(112.00), PaymentType.MONTHLY.gettypePayment());
		repository.save(payment4);
		
		Iterable<PaymentForm> lista = repository.findAll();
		assertNotNull(lista.iterator());
		
		for (PaymentForm price : lista) {
			LOGGER.info(price.toString());
		}
		LOGGER.info("Pesquisado um objeto");
		
		List<PaymentForm> result = repository.findByValueRent(BigDecimal.valueOf(112.00));
		assertEquals(result.size(), 4);
		LOGGER.info("Encontrado: {}", result.size());
		
	}
	
	@Test
	public void teste2Exclusao() throws ParseException {
		
		LOGGER.info("Excluindo objetos...");
		List<PaymentForm> result = repository.findByValueRent(BigDecimal.valueOf(112.00));
		
		for (PaymentForm price : result) {
			LOGGER.info("Excluindo Cotacao id = "+price.getId());
			repository.delete(price);
		}
		
		result = repository.findByValueRent(BigDecimal.valueOf(112.00));
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
}