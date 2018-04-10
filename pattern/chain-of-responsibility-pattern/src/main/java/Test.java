public class Test {
    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        System.out.println("---------------");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        System.out.println("---------------");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger error = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger file = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger console = new ConsoleLogger(AbstractLogger.INFO);

        error.setNext(file);
        file.setNext(console);
        return error;
    }
}
