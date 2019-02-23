package com.github.bartoszpogoda.springproplayground.ioccontainer.cars;

import org.springframework.stereotype.Component;

@Component("engineFactory")
public class EngineFactory {

	public Engine getEngine(Type carType) {
		switch (carType) {
		case FORD_MUSTANG:
			return new Engine(325.0f);
		case FERRARI_CALIFORNIA:
			return new Engine(460.0f);
		default:
			throw new IllegalArgumentException("Unknown car type");
		}
	}

}
