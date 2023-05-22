package com.pluralcamp.solid.ocp.dont;

import java.util.Arrays;
import java.util.List;

public class DistinctionDecider {
	List<String> science = Arrays.asList("Computer Science", "Physics");
	List<String> arts = Arrays.asList("History", "English");

	public void evaluateDistinction(Student student) {
		if (science.contains(student.department)) {
			if (student.score > 80) {
				System.out.println(student.regNumber + 
						" has received a distinction in science.");
			}
		} else if (arts.contains(student.department)) {
			if (student.score > 70) {
				System.out.println(student.regNumber + 
						" has received a distinction in arts.");
			}
		}
	}
}
