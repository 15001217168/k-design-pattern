public class ColorFactory extends AbstractFactory {
    @Override
   public Color getColor(String color) {
        if(color==null)
        {
            return  null;
        }
        if(color.equalsIgnoreCase("r"))
        {
            return  new Red();
        }
        if(color.equalsIgnoreCase("g"))
        {
            return  new  Green();
        }
        return  null;
    }

    @Override
   public Shape getShape(String shape) {
        return null;
    }
}
