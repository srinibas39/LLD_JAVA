package LowLevelDesign.2COR(LoggerSystem);

public class Error extends LoggerProcessor {
    public Error(int level) {
        super(level);
    }

    @Override
    public void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
