package com.pluralcamp.animals.entities;

public class Bacteria extends Animal {
	
	private double size;
	private boolean patogen;
	private String shape;	
	
	
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public boolean isPatogen() {
		return patogen;
	}

	public void setPatogen(boolean patogen) {
		this.patogen = patogen;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	
	
	public void action() {
		if(patogen) {
			this.infects();
		} else {
			this.probiotic();
		}
	}
	
	private void infects() {
		System.out.println("Bacteria is infecting you!!");			
	}
	
	private void probiotic() {
		System.out.println("This bacteria is good for your health");
	}
	
	
	
	
}
