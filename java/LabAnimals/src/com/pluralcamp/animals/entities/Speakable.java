package com.pluralcamp.animals.entities;

public interface Speakable {
	
	void makeSound();
	default void organ() {
		System.out.print("I am a " +
	            this.getClass().getSimpleName() +           
				" and I speak using my mouth: ");
	}
	
}
