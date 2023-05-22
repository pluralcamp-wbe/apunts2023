package com.pluralcamp.solid.srp;

import java.util.Random;

public class EmployeeIdGenerator {

	private String empId;

	public String generateEmpId(String firstName) {
		int random = new Random().nextInt(1000);
		this.empId = firstName.substring(0, 1) + random;
		return this.empId;
	}
}
