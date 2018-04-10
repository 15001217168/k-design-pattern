public class Monitor implements IComputerPart {
    @Override
    public void accept(IComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
