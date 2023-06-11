package com.pluralcamp.main;

import com.pluralcamp.entities.Circle;
import com.pluralcamp.entities.Color;
import com.pluralcamp.entities.Rectangle;
import com.pluralcamp.entities.Shape;
import com.pluralcamp.entities.Square;


public class App {

	public static void main(String[] args) {
				
		Square square = new Square();

		square.setSide(2.0);
		
		Color backgroundColor = new Color("Green",0,255,0);
//		backgroundColor.setName("Green");
//		backgroundColor.setRed(0);
//		backgroundColor.setGreen(255);
//		backgroundColor.setBlue(0);
		
		square.setBackgroundColor(backgroundColor);
			
		square.setLineColor(new Color());
		Color colorDeLinea = square.getLineColor();
		colorDeLinea.setName("Blue");
		square.getLineColor().setRed(0);
		square.getLineColor().setGreen(0);
		square.getLineColor().setBlue(255);

		System.out.println(square.toString());
		System.out.println("Costat del quadrat és: " + square.getSide());
		
		System.out.println("--- Overloading example: ---");
		System.out.println("Area en metres quadrats, usant area(): " 
				+ square.area() + "m2");//parameterless method
		
		System.out.println("Area en milimetres quadrats, "
				+ "usant area(boolean inMm): " 
				+ square.area(true) + "mm2"	);//method with 1 parameter
		
//		square.side = -2.0;
		
		//Circle
		Color black = new Color("Black", 0, 0, 0);
		Circle circle = new Circle(6.0, new Color(), black);
		System.out.println(circle.toString());
		
		//Puc instanciar un objecte de la classe Shape?
		//Shape figura = new Shape(new Color(), black);
		
		System.out.println("");
		System.out.println("..................");		
		Shape[] figuras = {circle, square, 
				new Rectangle(2.0, 3.0, new Color(), black)
		};
	
		for(Shape figura : figuras) {
			System.out.println(figura.getClass().getSimpleName());
		}

	}

}
