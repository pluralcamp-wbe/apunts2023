package com.pluralcamp.gaming.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Einstein";
	}

	@Bean
	public int age() {
		return 23;
	}

	@Bean
	public Person person(String name, int age, Address addressa) {
		var person = new Person(name, age, addressa); //reuse existing bean by method call
		return person;
	}
	
	@Bean (name = "adressa")
	@Primary
	public Address address() {
		return new Address("Via Romana", "Rome");
	}
	
	@Bean(name = "student")
	public Person person2() {
		var person = new Person("Newton", 33, new Address("Carrer Intelecte", "Eureka"));
		return person;
	}
	
	@Bean(name = "british")
	public Person person3(String name, int age, @Qualifier("uk")Address addressa) {
		var person = new Person(name, age, addressa);
		return person;
	}
	
	@Bean
	@Qualifier("uk")
	public Address address2() {
		return new Address("Baker Street", "London");
	}
	
	
}

/*
 * Records: Eliminate verbosity en creating Java Beans Public accessor methods
 * (getters), constructor, equals, hashCode and toString methods are
 * automatically created.
 * 
 * No setters, as records by nature are immutable. All fields are declared
 * private and final.
 * 
 * Available from JDK 16
 */

//record Person(String name, int age) {};


record Person(String name, int age, Address address) {};

//add record Address - firstLine and city and make a bean
