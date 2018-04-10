public class Computer implements IComputerPart {
    IComputerPart[] parts;

    public Computer() {
        parts = new IComputerPart[]{new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(IComputerPartVisitor visitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(visitor);
        }
        visitor.visit(this);
    }
}
