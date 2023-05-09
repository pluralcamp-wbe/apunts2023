package com.pluralcamp.animals.entities;

public class Cow extends Animal {

	private boolean milk;
	
	public void speak() {
		System.out.println("Muuuuuu.....");
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}
	
	
}
