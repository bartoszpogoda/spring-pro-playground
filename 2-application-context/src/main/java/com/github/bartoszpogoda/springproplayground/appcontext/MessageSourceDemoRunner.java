package com.github.bartoszpogoda.springproplayground.appcontext;

import static java.lang.String.format;

import java.util.Locale;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceDemoRunner implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext ctx;
	
	private TitlePrinter titlePrinter;

	public MessageSourceDemoRunner(TitlePrinter titlePrinter) {
		this.titlePrinter = titlePrinter;
	}

	@Override
	public void run(String... args) throws Exception {
		titlePrinter.print(this);
		
		Locale localeEn = Locale.ENGLISH;
		Locale localePl = new Locale("pl", "PL");
		
		String enMessage = ctx.getMessage("title", null, localeEn);
		String plMessage = ctx.getMessage("title", null, localePl);
		
		System.out.println(format("En: %s, Pl: %s", enMessage, plMessage));

		String enHiMessage = ctx.getMessage("hiMsg", new String[] { "Adam", "Kowalski" }, localeEn);
		String plHiMessage = ctx.getMessage("hiMsg", new String[] { "Adam", "Kowalski" }, localePl);
		
		System.out.println(format("En: %s, Pl: %s", enHiMessage, plHiMessage));
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

}
