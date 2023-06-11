package com.pluralcamp.animals.entities;

public class Cow extends Animal implements Speakable {

	private boolean milk;
	
	@Override
	public void makeSound() {
		System.out.println("Muuuuuu.....");
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}
	
	
}
