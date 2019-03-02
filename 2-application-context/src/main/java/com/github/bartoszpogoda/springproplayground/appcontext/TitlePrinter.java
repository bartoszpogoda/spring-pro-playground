package com.github.bartoszpogoda.springproplayground.appcontext;

import org.springframework.stereotype.Service;

@Service
public class TitlePrinter {
	
	public void print(Object object) {
		print(object.getClass().getSimpleName());
	}
	
	public void print(String title) {
		System.out.println("");
		System.out.println("-- " + title + " --");
		System.out.println("");
	}
	
}
