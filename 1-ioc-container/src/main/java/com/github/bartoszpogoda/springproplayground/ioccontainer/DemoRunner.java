package com.github.bartoszpogoda.springproplayground.ioccontainer;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.github.bartoszpogoda.springproplayground.ioccontainer.cars.Car;
import com.github.bartoszpogoda.springproplayground.ioccontainer.garrage.Mechanic;
import com.github.bartoszpogoda.springproplayground.ioccontainer.tools.Screwdriver;

@Component
public class DemoRunner implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		// Dependency pull
		Mechanic mechanicBob = ctx.getBean("bob", Mechanic.class);
		Mechanic mechanicAlice = ctx.getBean("alice", Mechanic.class);

		System.out.println(mechanicBob.getIntroductionMessage());
		System.out.println(
				mechanicBob.hasToolbox() ? "- I have my toolbox, ready to work!" : "- I can't work without toolbox..");

		Screwdriver bobsScrewdriver = mechanicBob.getScrewdriver();
		Screwdriver alicesScrewdriver = mechanicAlice.getScrewdriver();

		// Screwdriver references are different due to used "prototype" scope
		System.out.println(bobsScrewdriver == alicesScrewdriver ? "Bob and Alice share a screwdriver"
				: "Bobs and Alices screwdrivers are different");

		// Get default car bean (type set in application.properties)
		Car defaultCar = ctx.getBean("defaultCar", Car.class);
		System.out.println("Type of default car is: " + defaultCar.getType());

		// Ferrari california bean is lazily loaded, so the instance of the bean will be
		// created only when its actually needed.
		System.out.println("Just before pulling ferrariCalifornia bean");
		Car ferrariCalifornia = ctx.getBean("ferrariCalifornia", Car.class);
		ferrariCalifornia.start();
	}

	/**
	 * From interface {@link ApplicationContextAware}, allows to get reference to
	 * application context that the bean will run in.
	 */
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

}
