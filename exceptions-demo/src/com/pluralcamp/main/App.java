package com.pluralcamp.main;

import com.pluralcamp.entities.Calculator;
import com.pluralcamp.exceptions.CalcException;

public class App {
	public static void main(String... args) {

		Calculator calc = new Calculator();

		// Calculadora fa divisió decimal
//		double a = 5.0;
//		double b = 0.0;
//		double result = calc.divide(a, b);
//		System.out.printf("%n %.2f / %.2f = %.2f %n", a, b, result);

		// Calculadora fa divisió entera
		int n = 10;
		int m = 0;
		try {
			int intResult = calc.divide(n, m);
			System.out.printf("%n %d / %d = %d %n", n, m, intResult);
		} catch (CalcException e) { // Capturar la exception antes que "pete"
			System.err.println(e.getMessage());
		}

	}//main end
}
