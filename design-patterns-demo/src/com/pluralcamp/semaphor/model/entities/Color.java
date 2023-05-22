package com.pluralcamp.semaphor.model.entities;

import com.pluralcamp.semaphor.model.contracts.IRgb;

//Debe tener su Factory
public class Color extends IRgb {	
	
	private String name;	
	
	public Color(String name, int red, int green, int blue) {
		super(red,green,blue);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
