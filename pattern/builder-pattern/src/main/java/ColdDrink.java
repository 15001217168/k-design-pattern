public abstract class ColdDrink implements IItem {
    @Override
    public abstract String name();
    @Override
    public IPacking packing() {
        return new Bottle();
    }
    @Override
    public abstract float price();
}
