package Patterns.Factory.Optimised;

public class LatteIngriedients implements Ingredients {

    String milk;
    String sugar;
    String coffeebeans;

    public LatteIngriedients(String milk , String sugar , String coffeebeansString) {
        this.milk = milk;   
        this.sugar = sugar;
        this.coffeebeans = coffeebeansString;
    }

    @Override
    public String getMilk() {
        return this.milk;
    }

    @Override
    public String getSugar() {
        return this.sugar;
    }
    
    
    @Override
    public String getCoffeebeans() {
        return this.coffeebeans;
    }
}
