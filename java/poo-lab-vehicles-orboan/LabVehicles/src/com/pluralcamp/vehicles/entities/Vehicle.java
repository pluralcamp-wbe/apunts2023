package com.pluralcamp.vehicles.entities;

public class Vehicle {
	private String marca;
	private String color;
	private int horsePower;
	
	public void accelerate() {
		System.out.println("The " +
				this.getClass().getSimpleName() + " is accelerating");
	}
	
	public void frenar() {
		System.out.println("El cotxe està frenant");
	}
	
	public void turnLightsOn() {
		System.out.println("Encendiendo las luces");
	}
	
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
}
