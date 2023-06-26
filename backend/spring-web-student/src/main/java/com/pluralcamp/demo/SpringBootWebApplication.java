package com.pluralcamp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootWebApplication {
	
	public final static String API_URL = "http://localhost:8080";

	public static void main(String[] args) {
//		SpringApplication app = 
//				new SpringApplication(SpringBootWebApplication.class);
//		app.setDefaultProperties(
//				Collections.singletonMap("server.port", "8081"));
//		app.run(args);	
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	 
		var factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return new RestTemplate(factory);
	}

}
