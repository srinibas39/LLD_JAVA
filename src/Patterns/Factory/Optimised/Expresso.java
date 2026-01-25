package Patterns.Factory.Optimised;


public class Expresso extends Coffee{

    Expresso(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void brew() {
        System.out.println("Brewing Expresso");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Expresso");
    }
    
    @Override
    public void boil() {
        System.out.println("Boiling Expresso");
    }
}
