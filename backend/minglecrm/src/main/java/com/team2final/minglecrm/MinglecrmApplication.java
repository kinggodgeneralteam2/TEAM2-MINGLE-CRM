package com.team2final.minglecrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MinglecrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(MinglecrmApplication.class, args);
	}
}
