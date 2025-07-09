package com.allergen_info_service;

import org.springframework.boot.SpringApplication;

public class TestAccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.from(AllergenInformationSystem::main).with(TestcontainersConfiguration.class).run(args);
	}

}
