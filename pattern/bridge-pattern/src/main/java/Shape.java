public abstract class Shape {

    protected IDrawAPI drawAPI;

    public Shape(IDrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
