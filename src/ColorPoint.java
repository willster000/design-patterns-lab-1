
public class ColorPoint extends Point {
	// Lab task 1, Q3: change the color to enum (pick any colors, at least three). 
	// Define the enum within the  ColorPoint class.
	// Fix the getColor method and the TestPoint class constructor accordingly.
	// Explain (in comments here or in a separate file) why enums are 
	// a better choice than strings to represent colors

	/*
	 * A: Enums provide a standardized way for users of the code to interface with
	 * it via a list of "options" or available values, rather than having to perform
	 * exhaustive format-checking by hand in the class's constructor or elsewhere.
	 * They also help to document such behavior, as using a String and restricting
	 * the field to an arbitrary list of allowed inputs is much harder to figure out.
	 */
	
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
