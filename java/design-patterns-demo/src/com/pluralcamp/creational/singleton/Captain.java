package com.pluralcamp.creational.singleton;

public class Captain {
	private String name = "Pata Palo";
	private String ship = "Corsario Ship";
	
	private static Captain instance;
	
	private Captain() {}
	
	private Captain(String name, String ship) {
		this.name = name;
		this.ship = ship;
	}
	
	public static synchronized Captain getInstance() {
		if(instance == null) 
			instance = new Captain();
		return instance;		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getShip() {
		return this.ship;
	}
	
//	@Override
//	public String toString() {
//		return "Captain " + this.name 
//				+ " commands the ship " 
//				+ this.ship;
//	}
}
