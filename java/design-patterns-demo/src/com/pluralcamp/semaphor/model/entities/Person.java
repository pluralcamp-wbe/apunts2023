package com.pluralcamp.semaphor.model.entities;

import com.pluralcamp.semaphor.model.contracts.IObserver;
import com.pluralcamp.semaphor.model.contracts.IRgb;

//Observer
//Observa el Semaphor
public class Person implements IObserver {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public void update(IRgb color) {
		if(color.equals(Semaphor.SemaphorColor.RED.getColor())) {
			this.waiting();
		} else {
			this.crossing();
		}
	}
	
	private void crossing() {
		System.out.println(this.name + ": I amb crossing the street...");
	}

	private void waiting() {
		System.out.println(this.name + ": I am waiting for the semaphor...");		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
