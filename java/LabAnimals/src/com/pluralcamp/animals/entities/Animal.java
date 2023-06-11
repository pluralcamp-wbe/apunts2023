package com.pluralcamp.animals.entities;

public class Animal {
	
	private double weight;
	private String color;
	private String type;
	private int age;
	
	public void move() {
		System.out.println("The " +
							this.getClassName() + 
							" is running and jumping");
	}
	
	public void feed() {
		System.out.println("The " + 
							this.getClassName() +
							" is feeding");
	}
	
	public void rest() {
		System.out.println("The " + 
							this.getClassName() +
							" is resting");
	}
	
	public void reproduce() {
		System.out.println(this.getClassName() + " is reproducing");
	}
	
	
	private String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
