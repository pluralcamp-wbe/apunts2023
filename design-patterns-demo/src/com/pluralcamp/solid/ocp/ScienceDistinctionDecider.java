package com.pluralcamp.solid.ocp;

import java.util.Arrays;
import java.util.List;

public class ScienceDistinctionDecider implements DistinctionDecider {
	
	List<String> science = Arrays.asList("Computer Science", "Physics");

	@Override
	public void evaluateDistinction(Student student) {
		if (science.contains(student.department)) {
			if (student.score > 80) {
				System.out.println(student.regNumber + 
						" has received a distinction in science.");
			}
		} else {
			System.err.println("Error: this is not a science student");
		}
	}
}
