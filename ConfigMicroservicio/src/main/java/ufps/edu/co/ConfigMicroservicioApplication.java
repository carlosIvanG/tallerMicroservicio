package ufps.edu.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMicroservicioApplication.class, args);
	}

}
