package com.pluralcamp.demopoo.entities;

public class Table extends Furniture {
	

	private boolean isExtensible;//false			
	
	
	public Table(String material, 
			double height, 
			double width, 
			double deep, 
			Color color, 
			boolean isExtensible) {
		super(material, height, width, deep,color);
		this.isExtensible = isExtensible;		
	}



	public boolean isExtensible() {
		return isExtensible;
	}

	public void setExtensible(boolean isExtensible) {
		this.isExtensible = isExtensible;
	}


	//Behavior
	public void extend() {
		System.out.println("La mesa se extiende");
	}
	
	
	public String toString() {
		return "This table is extensible? " + this.isExtensible;
	}
	
}
