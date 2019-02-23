package com.github.bartoszpogoda.springproplayground.ioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.github.bartoszpogoda.springproplayground.ioccontainer.cars.Car;
import com.github.bartoszpogoda.springproplayground.ioccontainer.cars.CarFactoryBean;
import com.github.bartoszpogoda.springproplayground.ioccontainer.cars.EngineFactory;
import com.github.bartoszpogoda.springproplayground.ioccontainer.cars.Type;
import com.github.bartoszpogoda.springproplayground.ioccontainer.garrage.Mechanic;

@SpringBootApplication
public class Application {

	@Configuration
	static class Config {

		/**
		 * Autowire externally defined bean to provide it for some beans.
		 */
		@Autowired
		private EngineFactory engineFactory;

		@Bean
		public Mechanic bob() {
			return new Mechanic();
		}

		@Bean
		public Mechanic alice() {
			return new Mechanic();
		}

		@Bean
		public CarFactoryBean defaultFactoryBean() {
			return new CarFactoryBean(engineFactory);
		}

		@Bean
		@Lazy
		public CarFactoryBean ferrariCaliforniaFactoryBean() {
			return new CarFactoryBean(engineFactory, Type.FERRARI_CALIFORNIA);
		}

		@Bean
		public Car defaultCar() throws Exception {
			return defaultFactoryBean().getObject();
		}

		@Bean
		@Lazy
		public Car ferrariCalifornia() throws Exception {
			return ferrariCaliforniaFactoryBean().getObject();
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
