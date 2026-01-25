package Patterns.Factory.Better;


public class Expresso implements ICoffee{

    @Override
    public void brew() {
        System.out.println("Brewing Expresso");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Expresso");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Expresso");
    }
}
