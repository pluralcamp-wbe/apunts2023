package com.pluralcamp.solid.srp.dont;

import java.util.Random;

public class Employee {
	
	public String firstName, lastName, empId;
	public double experienceInYears;
	
	public Employee(String firstName, String lastName, 
			double experience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.experienceInYears = experience;
	}
	
	public void displayDetails() {
		System.out.printf("Employee name: %s, %s%n", 
				this.lastName, this.firstName);
		System.out.printf("This employee has %.2f years "
				+ "of experience.%n", this.experienceInYears);
	}
	
	public String checkSeniority() {
		return this.experienceInYears > 10 ? "senior" : "junior";
	}
	
	public String generateEmpId() {
		Random rdn = new Random();
		int random = rdn.nextInt(1000);
		this.empId = this.firstName.substring(0, 1) 
				+ this.lastName.substring(0,1) + random;
		return this.empId;
	}
}
