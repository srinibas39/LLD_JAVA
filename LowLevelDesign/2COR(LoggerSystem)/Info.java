package LowLevelDesign.2COR(LoggerSystem);

public class Info extends LoggerProcessor {
    public Info(int level) {
        super(level);
    }

    @Override
    public void write(String message) {
        System.out.println("INFO: " + message);
    }
}
