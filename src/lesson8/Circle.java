package lesson8;

public class Circle extends Shape{

    public Circle() {
        type="Circle";
    }

    @Override
    public String toString() {
        return getType();
    }
}
