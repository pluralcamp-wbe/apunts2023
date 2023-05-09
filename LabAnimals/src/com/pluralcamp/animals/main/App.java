package com.pluralcamp.animals.main;

import com.pluralcamp.animals.entities.*;

public class App {

	public static void main(String[] args) {
		
		System.out.println("---> Fase 1 <---");
		Cat cat = new Cat();
		cat.speak();
		
		Cow cow = new Cow();
		cow.speak();
		
		Duck duck = new Duck();
		duck.feed();
		
		Bacteria bacteria = new Bacteria();
		bacteria.action();
		
		System.out.println("");
		System.out.println("---> Fase 2 <---");
		Animal[] animals = {cat, cow, duck, bacteria};
		
		for(Animal animal : animals) {
			//System.out.print(animal.getClass().getSimpleName() + ": ");
			animal.feed();
		}
		
		
	}

}
