package com.github.bartoszpogoda.springproplayground.appcontext;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.github.bartoszpogoda.springproplayground.appcontext.eventing.TimerEvent;

@Component
public class TimerPublisher implements ApplicationListener<ContextRefreshedEvent> {

	private ApplicationContext ctx;
	
	@Async
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			TimeUnit.SECONDS.sleep(5);
			ctx.publishEvent(new TimerEvent(this, 5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public TimerPublisher(ApplicationContext ctx) {
		this.ctx = ctx;
	}

}
