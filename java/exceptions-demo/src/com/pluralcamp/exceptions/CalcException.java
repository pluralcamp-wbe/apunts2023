package com.pluralcamp.exceptions;

public class CalcException extends Exception {
	
	public CalcException(String message) {
		super(message);
		System.err.println("Error: CalcException");
	}
}
