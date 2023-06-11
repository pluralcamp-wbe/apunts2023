
public class Color {
	
	int red = 255;
	int green = 255;
	int blue = 255;
	String name = "White";
	
	public String toString() {
		return this.name + " rgb(" +
				this.red + "," +
				this.green + "," +
				this.blue + ")";
	}
	
}
