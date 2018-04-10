
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> _cache = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape shape=_cache.get(shapeId);
        return (Shape)shape.clone();
    }

    public  static  void  loadCache()
    {
        Square square=new Square();
        square.setId("1");
        _cache.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        _cache.put(rectangle.getId(),rectangle);
    }
}
