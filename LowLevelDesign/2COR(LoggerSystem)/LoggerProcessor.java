package LowLevelDesign.2COR(LoggerSystem);

public abstract class LoggerProcessor {

    private static int final DEBUG = 0;
    private static int final ERROR = 1;
    private static int final INFO = 2;

    private int level;
    
    LoggerProcessor nextLogger;

    public void setLogLevel(int level){
        this.level = level;
    }

    public void setNextLogger(LoggerProcessor nextLogger){
        this.nextLogger = nextLogger;
    }

    public void writeLog(int level , String message){
        if(level <= this.level){
            write(message);
        }

        if(nextLogger != null){
            nextLogger.writeLog(level, message);
        }
    }

    abstract protected void write(String message);
}
