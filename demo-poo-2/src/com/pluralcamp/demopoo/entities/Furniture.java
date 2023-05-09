package com.pluralcamp.demopoo.entities;

public class Furniture {
	
	protected String material;//null
	protected double height, width, deep;//0.0
	protected Color color;//null	
	
	public Furniture() {};
	public Furniture(String material, double height, 
			double width, 
			double deep, 
			Color color) {		
		this.material = material;
		this.height = height;
		this.width = width;
		this.deep = deep;
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getDeep() {
		return deep;
	}

	public void setDeep(double deep) {
		this.deep = deep;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	//Behavior
	public double volume() {
		return this.height * this.deep * this.width;
	}
	
	public String toString() {
		return "Aquest moble és de " + this.material
				+ " i té un volum de " + this.volume();
	}
}
