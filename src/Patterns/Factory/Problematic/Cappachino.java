package Patterns.Factory.Problematic;

public class Cappachino implements ICoffee {

    @Override
    public void brew() {
        System.out.println("Brewing Cappachino");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Cappachino");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Cappachino");
    }
}
