public class AuthenticationFilter implements IFilter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
