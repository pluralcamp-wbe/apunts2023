package com.pluralcamp.solid.ocp.dont;

public class Student {
	String name;
	String regNumber;
	String department;
	double score;

	public Student(String name, String regNumber, 
			double score, String department) {
		super();
		this.name = name;
		this.regNumber = regNumber;
		this.score = score;
		this.department = department;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(this.name);
		sb.append("\nReg. Number: ");
		sb.append(this.regNumber);
		sb.append("\nDept.: ");
		sb.append(this.department);
		sb.append("\nMarks: ");
		sb.append(this.score);
		sb.append("\n----------");
		return sb.toString();
	}
}
