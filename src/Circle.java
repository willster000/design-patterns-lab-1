public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    // area of a circle = pi r^2
    public int area() {
        return (int) (Math.PI * radius * radius);
    }

    // "circumference" = 2pi r
    public int perimeter() {
        return (int) (2 * Math.PI * radius);
    }
}
