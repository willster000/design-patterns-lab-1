public abstract class TwoSidedShape implements Shape {
    abstract int getSideOne();
    abstract int getSideTwo();

    public int area() {
        return this.getSideOne() * this.getSideTwo();
    }

    public int perimeter() {
        return 2 * this.getSideOne() + 2 * this.getSideTwo();
    }
}
