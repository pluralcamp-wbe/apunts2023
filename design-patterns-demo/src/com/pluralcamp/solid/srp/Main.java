package com.pluralcamp.solid.srp;

import com.pluralcamp.solid.srp.dont.Employee;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Demo that follows the SRP ***\n");

		Employee anna = new Employee("Anna", "Smith", 6.5);
		showEmpDetails(anna);

		System.out.println("\n********\n");

		Employee david = new Employee("David", "Jones", 2.8);
		showEmpDetails(david);

	}
	private static void showEmpDetails(Employee employee) {
		employee.displayDetails();

		// Generate id
		EmployeeIdGenerator idGenerator = new EmployeeIdGenerator();
		String empId = idGenerator.generateEmpId(employee.firstName);
		System.out.println("Employee id: " + empId);

		// Check seniority level
		SeniorityChecker seniorityChecker = new SeniorityChecker();
		String seniorityLevel = seniorityChecker.checkSeniority(employee.experienceInYears);
		System.out.printf("This is a %s employee.%n", seniorityLevel);
	}

}
