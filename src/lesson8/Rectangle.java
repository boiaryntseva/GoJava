package lesson8;

public class Rectangle extends Shape{

    public Rectangle(){
        type="Rectangle";
    }
    @Override
    public String toString() {
        return getType();
    }
}
