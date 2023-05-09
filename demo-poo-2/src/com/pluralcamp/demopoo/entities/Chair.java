package com.pluralcamp.demopoo.entities;

public class Chair extends Furniture {
	
	private boolean wheels;		
	
	public Chair(String material, double height, 
			double width, double deep, 
			Color color, boolean wheels) {
		super(material, height, width, deep,color);
		this.wheels = wheels;
	}
	

	public boolean isWheels() {
		return wheels;
	}
	public void setWheels(boolean wheels) {
		this.wheels = wheels;
	}
	
	
	public void move() {
		System.out.println("La silla se mueve");
	}
	
	public void changeHeight(double newHeight) {
		System.out.println("La silla cambia de altura:");
		System.out.println("Altura anterior al cambio: " +
				this.getHeight());
		this.setHeight(newHeight);//assigno nueva altura
		System.out.println("La nueva altura es: " + this.getHeight());
	}
	
	public String toString() {
		return "Silla de " + this.material 
				+ " que mide " + this.height 
				+ " cm de altura.";
	}
	
}


//Abstraccion
//---> Atributos
//---> Metodos de comportamiento

//Encapsulamiento:
//--> Getters i setters

//toString
//Constructores

//Generalizar --> Encontrar una superclasse con lo común

