package lesson8;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Diamond diamond = new Diamond();
        diamond.setId("2");
        shapeMap.put(diamond.getId(), diamond);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId("4");
        shapeMap.put(square.getId(), square);

        Triangle triangle = new Triangle();
        triangle.setId("5");
        shapeMap.put(triangle.getId(), triangle);
    }
}
