package com.pluralcamp.entities;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle() {}
	
	public Circle(double radius, Color backgroundColor, Color lineColor) {
		super();
		this.radius = radius;
		this.backgroundColor = backgroundColor;
		this.lineColor = lineColor;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	//Behavior
	@Override
	public double area() {
		//Behavior b = new Behavior();
		//return b.area();
		return 2 * Math.PI * this.radius * this.radius;
	}

	
	public double perimeter() {
		return 2 * this.radius * Math.PI;
	}
	
	public String toString() {
		return "Circle with radius = " + this.radius;
	}

}
