package com.pluralcamp.vehicles.entities;

public class MotorByke extends Vehicle implements Polluter {

	private double price;
	private String combustible;
	
	
	@Override
	public void expulsaCO2() {
		System.out.println(this.getClass().getSimpleName() +
				": Contamino con 4 Toneladas de CO2 al año");
	}
	
	public void wheely() {
		System.out.println("The motorbyke is wheelying");
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCombustible() {
		return combustible;
	}


	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	
}
