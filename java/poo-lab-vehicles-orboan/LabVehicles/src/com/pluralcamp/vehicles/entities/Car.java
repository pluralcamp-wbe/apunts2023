package com.pluralcamp.vehicles.entities;

public class Car extends Vehicle implements Polluter {

	private double price;
	private boolean aircon;
	private String combustible;
	
	@Override
	public void expulsaCO2() {
		System.out.println(this.getClass().getSimpleName() +
				": Contamino con 10 Toneladas de CO2 al año");
	}
	
	public void unfoldAirbag() {
		System.out.println("Airbag desplegándose");
	}
		
	

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAircon() {
		return aircon;
	}
	public void setAircon(boolean aircon) {
		this.aircon = aircon;
	}
	
	
}
