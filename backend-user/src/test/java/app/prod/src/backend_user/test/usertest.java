package app.prod.src.backend_user.test;

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

import app.prod.src.backend_user.entity.statename;
import app.prod.src.backend_user.entity.user;
import app.prod.src.backend_user.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, usertest.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class usertest {

	private static Logger LOGGER = LoggerFactory.getLogger(usertest.class);
	private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	
	@Configuration
	@EnableDynamoDBRepositories(basePackageClasses = { UserRepository.class })
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
	private UserRepository repository;
	
	@Test
	public void teste1Criacao() throws ParseException {
	
		LOGGER.info("Cadastrando usuários...");
		
		user usuario1 = new user("André Van Markem", df.parse("28/12/1969"), statename.MG.getfullnameState(), "Belo Horizonte", "MarkemAndre@gmail.com", "045tkgvop5t");
		repository.save(usuario1);
		
		user usuario2 = new user("Markoh Dikstrage Hjanovich", df.parse("14/03/1996"), statename.RS.getfullnameState(), "Porto Alegre", "MarkohPolo@gmail.com", "045t098j8ae5t");
		repository.save(usuario2);
		
		user usuario3 = new user("Dmitri Kaspell Rodrix", df.parse("04/04/1994"), statename.SP.getfullnameState(), "São Paulo", "RodrixKaspell@outlook.com", "2045HDJKLMp5t");
		repository.save(usuario3);
		
		LOGGER.info("Listando todos os usuários");
		Iterable<user> lista = repository.findAll();
		assertNotNull(lista.iterator());
		
		for(user usuarios : lista) {
			LOGGER.info(usuarios.toString());
		}
		
		LOGGER.info("Procurando um usuário pelo nickname");
		List<user> result = repository.findByFullname("Markoh Dikstrage Hjanovich");
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getFullname(), "Markoh Dikstrage Hjanovich");
		LOGGER.info("Encontrado: {}", result.get(0));
		
	}
	
	
	@Test
	public void teste2Exclusao() throws ParseException {
		
		LOGGER.info("Excluindo objetos...");
		
		List<user> result = repository.findByFullname("Markoh Dikstrage Hjanovich");
		for (user usuario : result) {
			LOGGER.info("Excluindo conta do usuário "+ usuario.getFullname());
			repository.delete(usuario);
		}
		result = repository.findByFullname("Markoh Dikstrage Hjanovich");
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão de conta feita com sucesso");
	}
}
