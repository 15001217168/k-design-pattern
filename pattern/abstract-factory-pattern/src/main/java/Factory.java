public class Factory {
    public static AbstractFactory getFactory(String fac) {
        if (fac.equalsIgnoreCase("s")) {
            return new ShapeFactory();
        }
        if (fac.equalsIgnoreCase("c")) {
            return new ColorFactory();
        }
        return null;
    }
}
