package com.pluralcamp.animals.main;

import com.pluralcamp.animals.entities.*;

public class App {

	public static void main(String[] args) {
		
		System.out.println("---> Fase 1 <---");
		Cat cat = new Cat();
		cat.makeSound();
		
		Cow cow = new Cow();
		cow.makeSound();
		
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
		
		System.out.println("");
		System.out.println("---> Fase 3 <---");
		
		Speakable[] parlantes = {cat, cow, duck};
		
		for(Speakable parlante : parlantes) {
			parlante.organ();
			parlante.makeSound();			
		}
		
		
	}

}
