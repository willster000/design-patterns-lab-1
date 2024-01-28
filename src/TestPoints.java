import java.util.ArrayList;

public class TestPoints {

	public static void main(String[] args) {
		// Create a couple of points:
		Point p1 = new Point(2, 4);
		Point p2 = new Point(-2, 4);
		
		System.out.println("Distance from zero for p1 = " + 
				p1.distanceFromZero());
		System.out.println("Distance from zero for p2 = " + 
				p2.distanceFromZero());
		
		
		// How can we get p1's x and y?
		p1.getX(); // need to call a getX because x is private
		
		// Can we change x or y in points?
		// No - they are private and there is no set.
		
		System.out.println("count = " + Point.count);
		
		// Test a method for a distance between two points:
		System.out.println("Distance = " + p1.distance(p2));
		System.out.println("Distance = " + p1.distance(p1));
		
		// Create color points
		ColorPoint cp1 = new ColorPoint(2, 4, ColorPoint.Color.BLUE);
		ColorPoint cp2 = new ColorPoint(-2, 4, ColorPoint.Color.GREEN);

		
		// Can I find their distance from zero? 
		System.out.println("Distance from zero for cp1 = " 
				+ cp1.distanceFromZero());
		
		// Can I find distance between two color points? A point and a color point?
		System.out.println("Distance = " + cp1.distance(cp2));
		System.out.println("Distance = " + cp1.distance(p1));
		
		/****Lab Task 1: answer the following questions ********/
		// Q1: Which of the following is a valid statement? Why?
		Point p3 = new ColorPoint(3, 3, ColorPoint.Color.BLUE);
		/*
		 * A: This is an example of polymorphism in Java, specifically the "is-a" 
		 * relationship between child objects of a parent class (in this case,
		 * a ColorPoint "is a" type of Point), which allows the construction of
		 * any descendant of type Point to be assigned to the Point object.
		 * 
		 */

		// ColorPoint cp3 = new Point(3,3);
		
		// Q2: Uncomment a valid statement above. How can you call 
		// getColor() on the resulting variable? 
		// Print out the result of getColor()
		ColorPoint p3c = (ColorPoint) p3;
		System.out.println(p3c.getColor());
		// Clearly explain what is required from the type safety standpoint
		// to call this method. 
		// Hint: use typecasting. 
		/*
		 * A: p3 could be assigned another type such as Point, in which case 
		 * our call to getColor() would result in an error, since the Point
		 * class lacks a getColor() method. We can't guarantee that p3 is
		 * any specific subclass of Point at compile time. To avoid this,
		 * we want to confirm that we are dealing with type ColorPoint before
		 * calling getColor().
		 */

		
		// Q3: see ColorPoint class. 
		
		// Q4: create an array list of points. Then add 10 points to it,
		// randomly choosing between regular points and color points. 
		// Generate the objects as follows:
		// Each object has a 50% chance to be a Point or a ColorPoint
		// Both x and y coordinates are random ints between -10 and 10 inclusive
		// The color for a ColorPoint is randomly chosen among at least two colors. 
		// Extra credit: Generate random colors that have an equal chance to 
		// take any value in the enum, regardless of how many there are 
		// in the enum.
		ArrayList<Point> points = new ArrayList<Point>(10);

		int tempType;
		int tempX;
		int tempY;
		int tempColor;
		ColorPoint.Color color;
		Point tempPoint;

		for(int i = 0; i < 10; i++) {
			tempType = (int) (Math.random()*2 + 1); // pick one or two
			tempX = (int) (Math.random()*20 - 10); // between -10 and 10
			tempY = (int) (Math.random()*20 - 10); // between -10 and 10
			tempColor = (int) (Math.random()*6 + 1); // between 1 and 6

			switch(tempColor) {
				case 1: 
					color = ColorPoint.Color.RED;
					break;
				case 2:
					color = ColorPoint.Color.ORANGE;
					break;
				case 3: 
					color = ColorPoint.Color.YELLOW;
					break;
				case 4:
					color = ColorPoint.Color.GREEN;
					break;
				case 5: 
					color = ColorPoint.Color.BLUE;
					break;
				case 6:
					color = ColorPoint.Color.PURPLE;
					break;
				default:
					// not a good idea but whatever
					color = ColorPoint.Color.RED;
					break;
			}
			System.out.println("DEBUG:\tValue of tempType: " + tempType);
			if(tempType == 1) { // it will be a Point
				tempPoint = new Point(tempX, tempY);
			} else {
				tempPoint = new ColorPoint(tempX, tempY, color);
			}
			points.add(tempPoint);
		}
		
		// Q5: write a loop to go through the array list that you generate 
		// in Q4 to do the following: 
		// 1. print out x and y coordinates of all points. 
		// 2. Additionally, print out the colors of the color points.
		// 3. count how many regular points and how many color points are there. 
		// Print out the counts after the loop.
		// Hint: use instanceof 

		int pointCount = 0;
		int colorPointCount = 0;
		for(Point p : points) {
			System.out.println("\n\nX coordinate: " + p.getX());
			System.out.println("Y coordinate: " + p.getY());
			System.out.println("Distance from 0: " + p.distanceFromZero());
			if(p instanceof ColorPoint) {
				ColorPoint cp = (ColorPoint) p;
				System.out.println("Color: " + cp.getColor());
				colorPointCount++;
			} 
			else {
				pointCount++;
			}
		}
		System.out.println("\nNumber of regular points: " + pointCount);
		System.out.println("Number of color points: " + colorPointCount + "\n");
		
	}

}
