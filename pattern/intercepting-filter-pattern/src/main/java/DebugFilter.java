public class DebugFilter implements IFilter {
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}
