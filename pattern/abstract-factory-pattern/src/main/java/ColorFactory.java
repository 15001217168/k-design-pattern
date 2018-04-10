public class ColorFactory extends AbstractFactory {
    @Override
   public IColor getColor(String color) {
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
   public IShape getShape(String shape) {
        return null;
    }
}
