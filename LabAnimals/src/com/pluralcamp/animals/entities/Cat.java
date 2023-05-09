package com.pluralcamp.animals.entities;


public class Cat extends Animal {
	private String name;
	
	public void speak() {
		System.out.println("Miauuuuu....");
	}
	
	public void play() {
		System.out.println("The cat is playing");
	}
	

	//Getters i setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
