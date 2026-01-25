package Patterns.Factory.Optimised;


public class Latte extends Coffee {

    Latte(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void brew() {
        System.out.println("Brewing Latte");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Latte");
    }
    
    @Override
    public void boil() {
        System.out.println("Boiling Latte");
    }
}
