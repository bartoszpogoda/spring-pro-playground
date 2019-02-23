package com.github.bartoszpogoda.springproplayground.ioccontainer.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Wrench implements Tool {

	@Override
	public ToolType getType() {
		return ToolType.WRENCH;
	}

}
