package Patterns.Factory.Problematic;

public class Latte implements ICoffee {

    @Override
    public void brew() {
        System.out.println("Brewing Latte");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Latte");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Latte");
    }
}
