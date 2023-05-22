package com.pluralcamp.solid.ocp;

public abstract class Student {
	String name;
	String regNumber;
	double score;
	String department;

	public Student(String name, String regNumber, double score) {
		super();
		this.name = name;
		this.regNumber = regNumber;
		this.score = score;
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
