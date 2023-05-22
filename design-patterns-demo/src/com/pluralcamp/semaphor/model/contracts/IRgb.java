package com.pluralcamp.semaphor.model.contracts;

public abstract class IRgb {
	
	public final static int MIN_VALUE = 0;
	public final static int MAX_VALUE = 255;
	
	protected int red;
	protected int green;
	protected int blue;
	
	public IRgb(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void setRed(int red) {
		if(MIN_VALUE <= red && red <= MAX_VALUE)
			this.red = red;
		else
			throw new IllegalArgumentException();
	}

	public void setGreen(int green) {
		if(MIN_VALUE <= green && green <= MAX_VALUE)
			this.green = green;
		else
			throw new IllegalArgumentException();
	}

	public void setBlue(int blue) {
		if(MIN_VALUE <= blue && blue <= MAX_VALUE)
			this.blue = blue;
		else
			throw new IllegalArgumentException();
	}
}
