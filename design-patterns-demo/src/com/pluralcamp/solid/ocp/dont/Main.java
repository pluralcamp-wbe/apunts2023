package com.pluralcamp.solid.ocp.dont;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Demo without OCP ***\n");

		List<Student> enrolledStudents = enrollStudents();

		// Display results
		System.out.println("\n=== Results: ===\n");
		for (Student student : enrolledStudents) {
			System.out.println(student);
		}

		System.out.println("\n=== Distinctions: ===\n");
		DistinctionDecider distinctionDecider = new DistinctionDecider();
		// Evaluate distinctions
		for (Student student : enrolledStudents) {
			distinctionDecider.evaluateDistinction(student);
		}

	}
	
	private static List<Student> enrollStudents() {
		Student anna = new Student("Anna", "R1", 81.5, "Computer Science");
		Student david = new Student("David", "R2", 72.0, "Physics");
		Student joseph = new Student("Joseph", "R3", 71.0, "History");
		Student laura = new Student("Laura", "R4", 66.5, "English");

		List<Student> students = new ArrayList<>();
		students.add(anna);
		students.add(david);
		students.add(joseph);
		students.add(laura);

		return students;
	}

}
