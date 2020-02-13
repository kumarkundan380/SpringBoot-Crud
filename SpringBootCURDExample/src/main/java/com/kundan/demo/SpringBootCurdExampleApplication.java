package com.kundan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootCurdExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdExampleApplication.class, args);
	}

}
