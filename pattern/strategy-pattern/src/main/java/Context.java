public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int x, int y) {
        return strategy.doOperation(x, y);
    }
}
