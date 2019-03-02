package com.github.bartoszpogoda.springproplayground.appcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class Application {
	
	@Configuration
	@EnableAsync
	static class Config {

		@Bean
		MessageSource messageSource() {
			ResourceBundleMessageSource rbMessageSource = new ResourceBundleMessageSource();
			rbMessageSource.addBasenames("mes");
			return rbMessageSource;
		}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
