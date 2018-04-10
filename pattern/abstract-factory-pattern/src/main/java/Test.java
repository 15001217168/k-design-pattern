public class Test {
    public static void main(String[] args) {

        AbstractFactory shapeFac = Factory.getFactory("s");
        Shape circle = shapeFac.getShape("c");
        circle.draw();

        AbstractFactory colorFac = Factory.getFactory("c");

        Color red = colorFac.getColor("r");
        red.fill();
    }
}
