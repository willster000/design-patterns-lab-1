# Lab Task 1

Q1: Which of the following is a valid statement? Why?

```java
Point p3 = new ColorPoint(3, 3, ColorPoint.Color.BLUE);
// ColorPoint cp3 = new Point(3,3);
```

A: This is an example of polymorphism in Java, specifically the "is-a" relationship between child objects of a parent class (in this case, a ColorPoint "is a" type of Point), which allows the construction of any descendant of type Point to be assigned to the Point object.

---

Q2: Clearly explain what is required from the type safety standpoint to call this method. 

```java 
ColorPoint p3c = (ColorPoint) p3;
System.out.println(p3c.getColor());
```

A: p3 could be assigned another type such as Point, in which case our call to getColor() would result in an error, since the Point class lacks a getColor() method. We can't guarantee that p3 is any specific subclass of Point at compile time. To avoid this, we want to confirm that we are dealing with type ColorPoint before calling getColor().

---

Q3: Explain why enums are a better choice than strings to represent colors.

A: Enums provide a standardized way for users of the code to interface with it via a list of "options" or available values, rather than having to perform exhaustive format-checking by hand in the class's constructor or elsewhere. They also help to document such behavior, as using a String and restricting the field to an arbitrary list of allowed inputs is much harder to determine.


# Lab Task 2

Q1: Examine the code for Square and Rectangle classes in the project. They are similar, but they have different methods for changing sides. 
Consider a scenario in which Square inherits from Rectangle and a scenario in which Rectangle inherits from Square. Clearly explain (in comments or in a separate text file):

a. Why both of these scenarios break the Liskov Substitution Principle. Specifically state which method(s) will produce incorrect or unexpected results. 
b. Why our current implementation of Point and ColorPoint don't break the Liskov Substitution Principle. 

**Part A**: In both scenarios for Squares and Rectangles, the Liskov Substitution Principle is violated because of the difference between the `setSide()` methods for Squares and Rectangles.

In the case where Square extends Rectangle, Square inherits both `setSide1()` and `setSide2()` from the Rectangle class. Yet, the specification for a Square class requires that both of its side lengths are equal to each other. This would mean that both methods must be overridden as follows:

```java
@Override
public void setSide1(int side1) {
	this.side1 = side1;
	this.side2 = side1;
}

@Override
public void setSide2(int side2) {
	this.side2 = side2;
	this.side1 = side2;
}
```

This produces confusing and unexpected behavior when attempting to substitute Rectangle instances for Square instances, since we don't expect a Rectangle's `setSide1()` or `setSide2()` methods to change both of its side fields at the same time. Square should therefore not extend Rectangle.

In the case where Rectangle extends Square, the issue is not in the `setSide()` method, as we can simply treat this as setting only one of the Rectangle's sides. The issue is in the implementation of the `area()`, `perimeter()` and `sidesEqual()` methods, as each of them produce unique output depending on whether the object is a Rectangle or a Square, meaning these methods make it so that we can't easily substitute Rectangle instances for Squares.

** Part B**: Point and ColorPoint don't break the LSP because ColorPoint is not changing any methods in Point but simply adding the `getColor()` method. The method shared between them, `distanceFromZero()`, is used by both classes with no changes in behavior.

---

Q2: Square and Rectangle classes do have a lot in common, so it makes sense for them to be included into the same class hierarchy.

- [X] Design an interface Shape that includes methods that the two classes have in common and make both of these classes implement this interface.
- [X] Then write a class Circle that also implements the Shape interface. 
- [X] In main create an array or array list of shapes that includes some squares, some rectangles, and some circles, and then call the methods area and perimeter on all of them in a loop, printing the results. 

---

Q3: Square and Rectangle have more in common with each other than with a Circle: they both are two-sided shapes. Their area and perimeter are computed in the same way, as long as we know their sides. 

Design and implement an abstract class TwoSidedShape that has methods for computing area and perimeter by using abstract methods getSide1 and getSide2. Then rewrite the Square and Rectangle classes so that they extend TwoSidedShape and have only the methods for setting the sides and the new methods getSide1 and getSide2, but not area and perimeter. The abstract class must implement the Shape interface (Square and Rectangle will no longer directly implement it, only by extending TwoSidedShape). Your testing code with a collection of shapes must still work without changes. 
