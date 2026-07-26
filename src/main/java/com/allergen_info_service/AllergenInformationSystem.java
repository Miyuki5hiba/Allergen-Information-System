package com.allergen_info_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

// Indicates that this is the main of a spring application
@SpringBootApplication
public class AllergenInformationSystem {
//	private static final Logger log = LoggerFactory.getLogger(AllergenInformationSystem.class);

	public static void main(String[] args) {
		SpringApplication.run(AllergenInformationSystem.class, args);
	}

//	@Bean
//	@Profile("!test")
//	public ApplicationRunner run(RestClient.Builder builder) {
//		RestClient restClient = builder.baseUrl("http://localhost:8085").build();
//		return args -> {
//			String response = restClient.get().uri("/night").retrieve().body(String.class);
//			log.info("Response from /night endpoint: {}", response);
//		};
//	}
}
