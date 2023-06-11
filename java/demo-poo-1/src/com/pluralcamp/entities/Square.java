package com.pluralcamp.entities;

public class Square extends Shape {

	private double side;

	public Square(){}
	
	public Square(double side, Color backgroundColor, Color lineColor) {
		super(backgroundColor, lineColor);
		this.side = side;
	}

	public double getSide() {
		return this.side;
	}
	
	public void setSide(double side) {
		if (side > 0) {
			this.side = side;
		} else {
			System.err.println("Error: invalid value");
		}
	}
	

	//Behavior
	
	public double area(){//es en metros cuadrados
		return this.side * this.side;
	}	
	
	
	public double area(boolean inMm) {
		if(inMm) {
			return this.area() * 1000 * 1000;
		} else {
			return this.area();
		}
	}	

	
	public String toString() {
		if (this.side > 0) {
			return "Quadrat d'àrea " + this.area() + " i perímetre " + 
					this.perimeter() +
					"\nEl color de fons és: " + 
					this.getBackgroundColor().toString();
		} else {
			return "Quadrat no vàlid";
		}
	}

	@Override
	public double perimeter() {
		return 4 * this.side;
	}

}
