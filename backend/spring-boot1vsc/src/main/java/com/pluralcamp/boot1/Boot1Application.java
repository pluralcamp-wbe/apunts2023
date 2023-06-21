package com.pluralcamp.boot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot1Application implements CommandLineRunner {

	@Autowired
	HelloService service;

	public static void main(String[] args) {
		SpringApplication.run(Boot1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(service.message());
	}
}
