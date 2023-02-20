package lesson8;

public class Square extends Shape {

    public Square() {
        type = "Square";
    }
    @Override
    public String toString() {
        return getType();
    }
}
