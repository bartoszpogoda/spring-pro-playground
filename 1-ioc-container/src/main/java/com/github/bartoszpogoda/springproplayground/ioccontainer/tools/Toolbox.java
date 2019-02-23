package com.github.bartoszpogoda.springproplayground.ioccontainer.tools;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Each mechanic needs his own toolbox - so we use prototype scope. Spring will
 * create new instance to satisfy each dependency.
 */
@Component
@Scope("prototype")
public class Toolbox {

	private Map<ToolType, Tool> tools;

	public Tool getForType(ToolType type) {
		return this.tools.get(type);
	}

	public <T extends Tool> T getForType(ToolType type, Class<T> clazz) {
		Tool tool = this.tools.get(type);

		if (clazz.isInstance(tool)) {
			return (T) tool;
		} else {
			throw new IllegalArgumentException("Incorrect type");
		}
	}

	// Constructor injection. Spring will automatically inject all available tools.
	public Toolbox(List<Tool> tools) {
		this.tools = tools.stream().collect(Collectors.toMap(t -> t.getType(), t -> t));
	}

}
