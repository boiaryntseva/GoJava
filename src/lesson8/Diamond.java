package lesson8;

public class Diamond extends Shape{

    public Diamond(){
        type="Diamond";
    }
    @Override
    public String toString() {
        return getType();
    }
}
