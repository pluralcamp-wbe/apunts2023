package com.pluralcamp.solid.srp.dont;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Demo without SRP ***\n");

		Employee anna = new Employee("Anna", "Smith", 6.5);
		showEmpDetails(anna);

		System.out.println("\n********\n");

		Employee david = new Employee("David", "Jones", 2.8);
		showEmpDetails(david);

	}
	private static void showEmpDetails(Employee employee) {
		employee.displayDetails();
		System.out.println("Employee id: " + 
							employee.generateEmpId());
		System.out.printf("This is a %s employee.%n", 
							employee.checkSeniority());
	}
}
