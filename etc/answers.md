# Lab Task 1

Q1: Which of the following is a valid statement? Why?

> ```java
> Point p3 = new ColorPoint(3, 3, ColorPoint.Color.BLUE);
> // ColorPoint cp3 = new Point(3,3);
> ```

A: This is an example of polymorphism in Java, specifically the "is-a" relationship between child objects of a parent class (in this case, a ColorPoint "is a" type of Point), which allows the construction of any descendant of type Point to be assigned to the Point object.

---

Q2: Clearly explain what is required from the type safety standpoint to call this method. 

> ```java 
> ColorPoint p3c = (ColorPoint) p3;
> System.out.println(p3c.getColor());
> ```

A: p3 could be assigned another type such as Point, in which case our call to getColor() would result in an error, since the Point class lacks a getColor() method. We can't guarantee that p3 is any specific subclass of Point at compile time. To avoid this, we want to confirm that we are dealing with type ColorPoint before calling getColor().

---

Q3: Explain why enums are a better choice than strings to represent colors.

A: Enums provide a standardized way for users of the code to interface with it via a list of "options" or available values, rather than having to perform exhaustive format-checking by hand in the class's constructor or elsewhere. They also help to document such behavior, as using a String and restricting the field to an arbitrary list of allowed inputs is much harder to determine.


# Lab Task 2