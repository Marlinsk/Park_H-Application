package app.src.cod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import app.src.cod.repository.DynamoDBConfig;

@SpringBootApplication
@Import({DynamoDBConfig.class})
public class Application {
	
	private static final Logger lon = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		lon.info("Inicializando serviço...");
		System.setProperty("server.servlet.context-path", "/park-api");
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
}
