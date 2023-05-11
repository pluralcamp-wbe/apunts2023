package com.pluralcamp.pair.entities;

import java.time.LocalDate;

public class Person {
	
	private final String name;
	private final String surname;
	private LocalDate dateOfBirth;
	
	
	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getName() {
		return name;
	}


	public String getSurname() {
		return surname;
	}

	
	public String toString() {
		return this.name + " " + this.surname;
	}
}
