public class ShapeFactory extends AbstractFactory {
    @Override
   public IColor getColor(String color) {
        return null;
    }

    @Override
   public IShape getShape(String shape) {
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
