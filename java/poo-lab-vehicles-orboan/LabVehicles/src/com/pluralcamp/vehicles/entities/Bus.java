package com.pluralcamp.vehicles.entities;

public class Bus extends Vehicle implements Polluter {
	
	private boolean nightly;
	private int capacity;
	private String combustible;

	
	@Override
	public void expulsaCO2() {
		System.out.println(this.getClass().getSimpleName() +
				": Contamino con 55 Toneladas de CO2 al año");
	}
	
	public void loadPassengers() {
		System.out.println("Passengers are riding the bus");
	}


	public boolean isNightly() {
		return nightly;
	}


	public void setNightly(boolean nightly) {
		this.nightly = nightly;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getCombustible() {
		return combustible;
	}


	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	
	
}
