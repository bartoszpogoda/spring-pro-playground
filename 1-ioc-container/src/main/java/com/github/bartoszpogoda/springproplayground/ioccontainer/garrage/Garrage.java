package com.github.bartoszpogoda.springproplayground.ioccontainer.garrage;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Garrage implements InitializingBean, DisposableBean {

	private Mechanic mechanic;

	public Garrage(@Qualifier("bob") Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(
				"Everything is ready. Garrage is now opened and " + mechanic.getCapitalizedName() + " is now on duty.");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Everything is finished. Garrage is now closed");

	}

}
