public class ShapeFactory {

    public Shape getShape(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("c")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("r")) {
            return new Rectangle();
        }
        if (type.equalsIgnoreCase("s")) {
            return new Square();
        }
        return null;
    }
}
