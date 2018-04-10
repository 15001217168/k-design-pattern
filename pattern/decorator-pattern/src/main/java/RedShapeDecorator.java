public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(IShape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void  setRedBorder(IShape shape)
    {
        System.out.println("Border Color: Red");
    }
}
