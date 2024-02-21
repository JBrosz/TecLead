package com.teclead.solution;

import com.teclead.solution.model.UserEntity;
import com.teclead.solution.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository) {
		return args -> {
			repository.save((new UserEntity(null, "Johannes", "Ruthe", "johannesruthe@gmail.com")));
		};
	}*/
}
