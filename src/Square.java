
public class Square /*extends Rectangle*/ {
	protected int side;
	// side1, side2
	
	public Square(int side) {
		// super(side, side);
		this.side = side;
	}
	
	public void setSide(int side) {
		this.side = side;
	}

	// @Override
	// public void setSide1(int side1) {
	// 	this.side1 = side1;
	// 	// this.side2 = side1;
	// }
	// 
	// @Override
	// public void setSide2(int side2) {
	// 	this.side2 = side2;
	// 	// this.side1 = side2;
	// }
	
	public int area() {
		return side * side;
	}
	
	public int perimeter() {
		return 4 * side;
	}

	// Two sides of a square are always equal:
	public boolean sidesEqual() {
		return true;
	}
}
