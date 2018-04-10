public class Test {
    public  static  void  main(String[]args)
    {
        IImage image = new ProxyImage("test_10mb.jpg");

        image.display();
        System.out.println("");
    }
}
