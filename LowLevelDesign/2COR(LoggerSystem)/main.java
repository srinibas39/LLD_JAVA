package LowLevelDesign.2COR(LoggerSystem);

public class main {
    public static void main(String[] args) {
        LoggerProcessor loggerProcessor = getChainOfLoggers();
        loggerProcessor.writeLog(LoggerProcessor.DEBUG, "This is a debug message");
        loggerProcessor.writeLog(LoggerProcessor.INFO, "This is an info message");
        loggerProcessor.writeLog(LoggerProcessor.ERROR, "This is an error message");


    }

    private static LoggerProcessor getChainOfLoggers() {
        LoggerProcessor debugLogger = new Debug(LoggerProcessor.DEBUG);
        LoggerProcessor infoLogger = new Info(LoggerProcessor.INFO);
        LoggerProcessor errorLogger = new Error(LoggerProcessor.ERROR);

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);

        return debugLogger;
    }
}
