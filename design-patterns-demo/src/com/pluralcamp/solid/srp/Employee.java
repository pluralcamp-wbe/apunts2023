package com.pluralcamp.solid.srp;

public class Employee {
	
	public String firstName, lastName;
	public double experienceInYears;

	public Employee(String firstName, String lastName, double experience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.experienceInYears = experience;
	}

	public void displayDetails() {
		System.out.printf("Employee name: %s, %s%n", this.lastName, this.firstName);
		System.out.printf("This employee has %.2f years of experience.%n", this.experienceInYears);
	}
}
