package com.pluralcamp.entities;

public abstract class Shape {//NO puedo hacer new Shape()
	
	protected Color backgroundColor;
	protected Color lineColor;
	
	protected Shape() {}; 
	protected Shape(Color backgrounColor,
			Color lineColor) {
		this.backgroundColor = backgrounColor;
		this.lineColor = lineColor;
	}
	
	public Color getBackgroundColor() {
		return this.backgroundColor;
	}
	
	public Color getLineColor() {
		return this.lineColor;
	}
	
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public void setLineColor(Color color) {
		this.lineColor = color;
	}
		
	public abstract double area();
	
	public abstract double perimeter();
}
