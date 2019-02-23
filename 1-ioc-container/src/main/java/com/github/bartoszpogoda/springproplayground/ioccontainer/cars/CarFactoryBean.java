package com.github.bartoszpogoda.springproplayground.ioccontainer.cars;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

public class CarFactoryBean implements FactoryBean<Car> {

	private EngineFactory engineFactory;

	@Value("${carfactory.default-type}")
	private Type defaultType;

	private Type type = null;

	@Override
	public Car getObject() throws Exception {
		Type carType = type != null ? type : defaultType;

		SimpleCar car = new SimpleCar(carType);

		// assembly engine based on car type
		car.setEngine(engineFactory.getEngine(carType));

		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	public CarFactoryBean(EngineFactory engineFactory) {

		this.engineFactory = engineFactory;
	}

	public CarFactoryBean(EngineFactory engineFactory, Type type) {
		this(engineFactory);

		this.type = type;
	}

}
