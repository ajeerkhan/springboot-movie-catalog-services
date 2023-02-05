package io.spring.ajeer.moviecatalogdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieCatalogDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogDiscoveryServiceApplication.class, args);
	}

}
