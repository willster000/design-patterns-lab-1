
public class ColorPoint extends Point {
	// Lab task 1, Q3: change the color to enum (pick any colors, at least three). 
	// Define the enum within the  ColorPoint class.
	// Fix the getColor method and the TestPoint class constructor accordingly.
	// Explain (in comments here or in a separate file) why enums are 
	// a better choice than strings to represent colors
	
	public static enum Color {
		RED, 
		ORANGE,
		YELLOW, 
		GREEN,
		BLUE,
		PURPLE
	} // What is the initial value of color? null because Strings are objects

	private Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y); // call to the constructor of the superclass
		this.color = color;
	}
	
	// returns the color of a point
	public Color getColor() {
		return color;
	}
	

}
