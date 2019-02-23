package com.github.bartoszpogoda.springproplayground.ioccontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.bartoszpogoda.springproplayground.ioccontainer.garrage.Mechanic;

@SpringBootApplication
public class Application {

	@Configuration
	static class Config {

		@Bean
		public Mechanic bob() {
			return new Mechanic();
		}

		@Bean
		public Mechanic alice() {
			return new Mechanic();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
