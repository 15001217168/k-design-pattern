public class Test {
    public static void main(String[] args) {

        AbstractFactory shapeFac = Factory.getFactory("s");
        IShape circle = shapeFac.getShape("c");
        circle.draw();

        AbstractFactory colorFac = Factory.getFactory("c");

        IColor red = colorFac.getColor("r");
        red.fill();
    }
}
