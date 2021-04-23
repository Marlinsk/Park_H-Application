package app.prod.src.backend_pay_data.test;

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

import app.prod.src.backend_pay_data.entity.PaymentForm;
import app.prod.src.backend_pay_data.entity.type_of_payment;
import app.prod.src.backend_pay_data.repository.PriceDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, TestPayment.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPayment {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TestPayment.class);
	
	@Configuration
	@EnableDynamoDBRepositories(basePackageClasses = { PriceDataRepository.class })
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
	private PriceDataRepository repository;
	
	@Test
	public void teste1Criacao() throws ParseException {
		
		LOGGER.info("Criando objetos...");
		
		PaymentForm payment1 = new PaymentForm(BigDecimal.valueOf(112.00), type_of_payment.MONTHLY.getTypePay());
		repository.save(payment1);
		
		// PaymentForm payment2 = new PaymentForm(BigDecimal.valueOf(112.00), type_of_payment.MONTHLY.getTypePay());
		// repository.save(payment2);
		
		// PaymentForm payment3 = new PaymentForm(BigDecimal.valueOf(112.00), type_of_payment.MONTHLY.getTypePay());
		// repository.save(payment3);
		
		// PaymentForm payment4 = new PaymentForm(BigDecimal.valueOf(112.00), type_of_payment.MONTHLY.getTypePay());
		// repository.save(payment4);
		
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
	/*
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
	}*/
}
