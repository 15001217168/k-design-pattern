public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNext(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String msg) {
        if (this.level <= level) {
            write(msg);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, msg);
        }
    }

    protected abstract void write(String message);
}
