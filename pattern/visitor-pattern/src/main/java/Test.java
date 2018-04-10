public class Test {
    public  static  void  main(String[] args)
    {
        IComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
