public class Test {
    public  static  void  main(String[] args)
    {
        IShape circle=new Circle();

        IShape redCircle=new RedShapeDecorator(new Circle());

        IShape redSquare = new RedShapeDecorator(new Square());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nredSquare of red border");
        redSquare.draw();
    }
}
