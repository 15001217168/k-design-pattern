public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        IShape shape1 = shapeFactory.getShape("c");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        IShape shape2 = shapeFactory.getShape("r");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        IShape shape3 = shapeFactory.getShape("s");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
