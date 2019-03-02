package com.github.bartoszpogoda.springproplayground.appcontext;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LoadedBeansDemoRunner implements ApplicationContextAware, CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(LoadedBeansDemoRunner.class);

	private ApplicationContext ctx;

	private TitlePrinter titlePrinter;
	
	public LoadedBeansDemoRunner(TitlePrinter titlePrinter) {
		this.titlePrinter = titlePrinter;
	}

	@Override
	public void run(String... args) throws Exception {
		titlePrinter.print(this);
		
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(logger::info);		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}

}
