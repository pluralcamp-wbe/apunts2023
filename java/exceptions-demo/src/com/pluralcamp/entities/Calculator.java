package com.pluralcamp.entities;

import com.pluralcamp.exceptions.CalcException;

public class Calculator {

	public double divide(double num, double den) {
		double result = num / den;
		return result;
	}

	public int divide(int num, int den) throws CalcException {
		int result = 0;
		try {
			result = num / den;
		} catch (ArithmeticException e) {
			throw new CalcException(e.getMessage());
		}
		return result;
	}
}
