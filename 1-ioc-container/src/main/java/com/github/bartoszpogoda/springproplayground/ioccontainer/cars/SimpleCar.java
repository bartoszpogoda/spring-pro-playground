package com.github.bartoszpogoda.springproplayground.ioccontainer.cars;

class SimpleCar implements Car {

	private Type type;

	private Engine engine;

	public SimpleCar(Type type) {
		System.out.println(String.format("Invoked constructor for %s car", type.getFriendlyName()));
		
		this.type = type;
	}

	@Override
	public void start() {
		engine.start();

		System.out.println(String.format("* %s is now running... *", type.getFriendlyName()));
	}

	@Override
	public Type getType() {
		return type;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
