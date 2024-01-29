
public class Rectangle /*extends Square*/ extends TwoSidedShape {
	protected int side;
	protected int side2;
	
	public Rectangle(int side1, int side2) {
		// super(side);
		this.side = side1;
		this.side2 = side2;
	}
	
	// public void setSide(int side) {
	// 	this.side = side;
	// }

	public int getSideOne() {
		return side;
	}

	public int getSideTwo() {
		return side2;
	}

	public void setSide1(int side1) {
		this.side = side1;
		// this.side2 = side1;
	}
	
	public void setSide2(int side2) {
		this.side2 = side2;
		// this.side1 = side2;
	}
	
	// // @Override
	// public int area() {
	// 	return side * side2;
	// }
	
	// // @Override
	// public int perimeter() {
	// 	return 2 * side + 2 * side2;
	// }
	
	// @Override
	public boolean sidesEqual() {
		return side == side2;
	}
	
}
