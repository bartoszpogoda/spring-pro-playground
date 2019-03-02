package com.github.bartoszpogoda.springproplayground.appcontext.eventing;

import org.springframework.context.ApplicationEvent;

public class TimerEvent extends ApplicationEvent {

	private static final long serialVersionUID = -1652482740132781165L;

	private long timeout;

	/**
	 * @param source
	 *            source
	 * @param timeout
	 *            number of seconds that elapsed since application startup (context
	 *            load)
	 */
	public TimerEvent(Object source, long timeout) {
		super(source);
		this.timeout = timeout;
	}

	public long getTimeout() {
		return timeout;
	}
}
