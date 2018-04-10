public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int radius, int x, int y, IDrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(this.radius, this.x, this.y);
    }
}
