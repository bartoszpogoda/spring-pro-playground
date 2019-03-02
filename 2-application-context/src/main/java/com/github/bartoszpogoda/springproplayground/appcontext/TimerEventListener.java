package com.github.bartoszpogoda.springproplayground.appcontext;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github.bartoszpogoda.springproplayground.appcontext.eventing.TimerEvent;

@Component
public class TimerEventListener implements ApplicationListener<TimerEvent>{

	@Override
	public void onApplicationEvent(TimerEvent event) {
		System.out.println("Event happened: " + event.getTimeout());
	}

}
