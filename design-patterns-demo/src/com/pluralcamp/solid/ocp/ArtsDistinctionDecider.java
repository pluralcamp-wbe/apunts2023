package com.pluralcamp.solid.ocp;

import java.util.Arrays;
import java.util.List;

public class ArtsDistinctionDecider implements DistinctionDecider {

	List<String> arts = Arrays.asList("History", "English");

	@Override
	public void evaluateDistinction(Student student) {
		if (arts.contains(student.department)) {
			if (student.score > 70) {
				System.out.println(student.regNumber + 
						" has received a distinction in arts.");
			}
		} else {
			System.err.println("Error: this is not an arts student");
		}
	}
}
