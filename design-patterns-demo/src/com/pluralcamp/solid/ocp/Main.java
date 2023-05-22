package com.pluralcamp.solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Demo that follows the OCP ***\n");

		List<Student> scienceStudents = enrollScienceStudents();
		List<Student> artsStudents = enrollArtsStudents();

		// Display results
		System.out.println("\n=== Results: ===\n");
		for (Student student : scienceStudents) {
			System.out.println(student);
		}
		for (Student student : artsStudents) {
			System.out.println(student);
		}

		System.out.println("\n=== Distinctions: ===\n");
		DistinctionDecider scienceDistinctionDecider = new ScienceDistinctionDecider();
		DistinctionDecider artsDistinctionDecider = new ArtsDistinctionDecider();

		// Evaluate distinctions
		for (Student student : scienceStudents) {
			scienceDistinctionDecider.evaluateDistinction(student);
		}
		for (Student student : artsStudents) {
			artsDistinctionDecider.evaluateDistinction(student);
		}

	}
	private static List<Student> enrollScienceStudents() {
		Student anna = new ScienceStudent("Anna", "R1", 81.5, "Computer Science");
		Student david = new ScienceStudent("David", "R2", 72.0, "Physics");

		List<Student> scienceStudents = new ArrayList<>();
		scienceStudents.add(anna);
		scienceStudents.add(david);

		return scienceStudents;
	}

	private static List<Student> enrollArtsStudents() {

		Student joseph = new ArtsStudent("Joseph", "R3", 71.0, "History");
		Student laura = new ArtsStudent("Laura", "R4", 66.5, "English");

		List<Student> artsStudents = new ArrayList<>();

		artsStudents.add(joseph);
		artsStudents.add(laura);

		return artsStudents;
	}
}
