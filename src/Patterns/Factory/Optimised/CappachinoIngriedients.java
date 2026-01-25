package Patterns.Factory.Optimised;

public class CappachinoIngriedients implements Ingredients {

    String milk;
    String sugar;
    String coffeebeans;

    public CappachinoIngriedients(String milk , String sugar , String coffeebeans) {
        this.milk = milk;
        this.sugar = sugar;
        this.coffeebeans = coffeebeans;
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
