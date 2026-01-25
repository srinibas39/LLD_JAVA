package Patterns.Factory.Optimised;


public class Cappachino extends Coffee {

    Ingredients ingredients;

    Cappachino(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    
    @Override
    public void brew() {
        System.out.println("Brewing Cappachino");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Cappachino");
    }
    
    @Override
    public void boil() {
        System.out.println("Boiling Cappachino");
    }
}
