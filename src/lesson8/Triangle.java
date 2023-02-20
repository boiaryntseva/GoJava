package lesson8;

public class Triangle extends Shape {
    public Triangle() {
        type = "Triangle";
    }

    @Override
    public String toString() {
        return getType();
    }
}
