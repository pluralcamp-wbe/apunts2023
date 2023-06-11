package com.pluralcamp.vehicles.entities;

public class Train extends Vehicle {

	private int wagonsNumber;
	
	
	public void loadPassengers() {
		System.out.println("Passengers are riding the bus");
	}


	public int getWagonsNumber() {
		return wagonsNumber;
	}


	public void setWagonsNumber(int wagonsNumber) {
		this.wagonsNumber = wagonsNumber;
	}
	
	
}
