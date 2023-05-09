package com.pluralcamp.demopoo.entities;

public class Color {

	private int red = 255;
	private int green = 255;
	private int blue = 255;
	private String name = "White";

	public Color(){}
	
	public Color(String name, int red, int green, int blue){
		this.name = name;
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
	}
	
	
	public int getRed() {
		return this.red;
	}

	public void setRed(int red) {
		if (red <= 255 && red >= 0)
			this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		if (green <= 255 && green >= 0)
			this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		if (blue <= 255 && blue >= 0)
			this.blue = blue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name + " rgb(" + this.red + "," + this.green + "," + this.blue + ")";
	}
}
