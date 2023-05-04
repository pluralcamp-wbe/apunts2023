
public class Car {
	String marca;
	Color color = new Color();// White
	
	{
		color.name = "Red";
		color.red = 255;
		color.green = 0;
		color.blue = 0;
	}

	public String toString() {
		return "Car brand is " + this.marca + "\nCar color is " + this.color.toString();
	}

}
