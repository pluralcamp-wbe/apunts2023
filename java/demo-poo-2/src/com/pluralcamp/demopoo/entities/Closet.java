package com.pluralcamp.demopoo.entities;

public class Closet extends Furniture {
	
	private int doorsAmount;//quantitat de portes que té l'armari
	
	public Closet(String material, double height, 
			double width, double deep, 
			Color color, int doorsAmount) {
		
		super(material, height, width, deep,color);
		this.doorsAmount = doorsAmount;
	}
	
	
	public Closet(int doorsAmount) {
		super();
		this.doorsAmount = doorsAmount;
	}


	public int getDoorsAmount() {
		return doorsAmount;
	}


	public void setDoorsAmount(int doorsAmount) {
		this.doorsAmount = doorsAmount;
	}
	
	//Behavior
	public void open() {
		System.out.println("The closet is open");
	}
	
	public String toString() {
		String armarioStr = "This closet has "
				+ this.getDoorsAmount() + " doors.";
		return armarioStr;
	}

}
