package app.prod.src.backend_user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import app.prod.src.backend_user.repository.DynamoDBConfig;

@SpringBootApplication
@Import({DynamoDBConfig.class})
public class Application {
	
	private static final Logger lon = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		lon.info("Inicializando...");
	    System.setProperty("server.servlet.context-path", "/user-api");
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
}