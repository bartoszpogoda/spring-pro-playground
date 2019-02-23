package com.github.bartoszpogoda.springproplayground.ioccontainer.cars;

public class Engine {

	private boolean running;

	private float horsePower;

	public Engine(float horsePower) {
		this.horsePower = horsePower;
	}

	public void start() {
		System.out.println("Starting engine..");

		running = true;
	}

	public void stop() {
		System.out.println("Stopping engine..");

		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public float getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(float horsePower) {
		this.horsePower = horsePower;
	}

}
