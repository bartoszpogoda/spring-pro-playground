package com.github.bartoszpogoda.springproplayground.ioccontainer.garrage;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.bartoszpogoda.springproplayground.ioccontainer.tools.Screwdriver;
import com.github.bartoszpogoda.springproplayground.ioccontainer.tools.ToolType;
import com.github.bartoszpogoda.springproplayground.ioccontainer.tools.Toolbox;

public class Mechanic implements BeanNameAware {

	private String name;

	private Toolbox toolbox;

	public String getIntroductionMessage() {
		return String.format("Hi, I am mechanic and my name is %s", name);
	}

	public boolean hasToolbox() {
		return toolbox != null;
	}
	
	public Screwdriver getScrewdriver() {
		return this.toolbox.getForType(ToolType.SCREWDRIVER, Screwdriver.class);
	}

	/**
	 * From interface {@link BeanNameAware}, allows to get actual bean name.
	 */
	@Override
	public void setBeanName(String beanName) {
		this.name = beanName;
	}

	/**
	 * The toolbox bean will be injected by Spring IoC container automagically using
	 * setter injection.
	 */
	@Autowired
	public void setToolbox(Toolbox toolbox) {
		this.toolbox = toolbox;
	}

}
