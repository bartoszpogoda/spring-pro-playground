package com.github.bartoszpogoda.springproplayground.ioccontainer.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Screwdriver implements Tool{

	@Override
	public ToolType getType() {
		return ToolType.SCREWDRIVER;
	}

}
