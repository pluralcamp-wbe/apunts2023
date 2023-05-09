package com.pluralcamp.entities;

public class Rectangle extends Shape {
	
	private double base;
	private double height;
	
	public Rectangle() {}
	
	public Rectangle(double base, double height, Color backgroundColor, Color lineColor) {
		super();
		this.base = base;
		this.height = height;
		this.backgroundColor = backgroundColor;
		this.lineColor = lineColor;
	}
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//Comportamiento
	@Override
	public double area() {
		return this.base * this.height;
	}
	
	public double perimeter() {
		return this.base * 2 + this.height * 2;
	}
		
	public String toString() {
		return  "Rectangle's base is " + this.getBase() +
				"\nRectangle's height is " + this.getHeight() +
				"\nRectangle's area is " + this.area() + 
				"\nRectangle's perimeter is " + this.perimeter();
	}
	
	
}
