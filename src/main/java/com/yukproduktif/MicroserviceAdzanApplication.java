package com.yukproduktif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MicroserviceAdzanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdzanApplication.class, args);
	}
}
