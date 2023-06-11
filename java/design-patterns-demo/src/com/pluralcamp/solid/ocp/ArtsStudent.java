package com.pluralcamp.solid.ocp;

public class ArtsStudent extends Student{
	public ArtsStudent(String name, String regNumber, 
			double score, String department) {
		super(name, regNumber, score);
		this.department = department;
	}
}
