package com.pluralcamp.animals.entities;

public class Duck extends Animal implements Speakable {

	private boolean migratory;
	private double wingsSize;
	
	

	public boolean isMigratory() {
		return migratory;
	}

	public void setMigratory(boolean migratory) {
		this.migratory = migratory;
	}

	public double getWingsSize() {
		return wingsSize;
	}

	public void setWingsSize(double wingsSize) {
		this.wingsSize = wingsSize;
	}

	public void fly() {
		System.out.println("The duck is flying");
	}

	
	@Override
	public void makeSound() {
		System.out.println("Quack quack ...");
	}

	public void layEggs() {
		System.out.println("The duck is laying eggs");
	}


}
