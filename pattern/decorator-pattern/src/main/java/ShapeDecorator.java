public abstract class ShapeDecorator implements IShape {
    protected IShape shape;

    public ShapeDecorator(IShape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        this.shape.draw();
    }
}
