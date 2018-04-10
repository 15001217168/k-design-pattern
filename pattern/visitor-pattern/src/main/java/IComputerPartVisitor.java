public interface IComputerPartVisitor {
    void visit(Computer computer);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
