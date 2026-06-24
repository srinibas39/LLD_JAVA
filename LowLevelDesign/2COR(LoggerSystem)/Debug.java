package LowLevelDesign.2COR(LoggerSystem);

public class Debug extends LoggerProcessor {


    Debug(int level){
        super(level);
    }
    
    @Override
    protected void write(String message){
        System.out.println("DEBUG: "+ message)
    }
}
