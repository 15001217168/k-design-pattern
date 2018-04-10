public class ShapeFactory extends AbstractFactory {
    @Override
   public Color getColor(String color) {
        return null;
    }

    @Override
   public Shape getShape(String shape) {
        if(shape == null){
            return null;
        }
        if(shape.equalsIgnoreCase("c")){
            return new Circle();
        } else if(shape.equalsIgnoreCase("r")){
            return new Rectangle();
        } else if(shape.equalsIgnoreCase("s")){
            return new Square();
        }
        return null;
    }
}
