package com.github.bartoszpogoda.springproplayground.appcontext;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoaderDemoRunner implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext ctx;

	private TitlePrinter titlePrinter;

	private String classPathResourcePath;

	public ResourceLoaderDemoRunner(TitlePrinter titlePrinter,
			@Value("${resources.classpath-resource.path}") String classPathResourcePath) {

		this.titlePrinter = titlePrinter;
		this.classPathResourcePath = classPathResourcePath;
	}

	@Override
	public void run(String... args) throws Exception {
		titlePrinter.print(this);

		File temporaryFile = File.createTempFile("temp", "txt");
		temporaryFile.deleteOnExit();

		List<Resource> resources = new ArrayList<>();

		resources.add(ctx.getResource("classpath:" + classPathResourcePath));
		resources.add(ctx.getResource("http://www.google.com"));
		resources.add(ctx.getResource("file:" + temporaryFile.getPath()));

		resources.forEach(this::printResourceInfo);
	}

	private void printResourceInfo(Resource res) {
		try {
			System.out.println("Path: " + res.getURL().toString());
			System.out.println("Class: " + res.getClass());
			System.out.println("Content: " + res.getURL().getContent());
			System.out.println("First line: " + readFirstLineOfResource(res).orElse("-EMPTY-"));
			System.out.println("");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Optional<String> readFirstLineOfResource(Resource resource) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		return Optional.ofNullable(br.readLine());
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

}
