package com.example.carrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarrotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrotApplication.class, args);
	}
}
