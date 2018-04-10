public class ShapeMaker {
    private IShape circle;
    private IShape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
