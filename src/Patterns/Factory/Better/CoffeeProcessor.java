package Patterns.Factory.Better;

public class CoffeeProcessor {
    
    public ICoffee prepareCoffee(String whichCoffee) {
       
        ICoffee coffee = CoffeeFactory.getCoffee(whichCoffee);
        return coffee;
    }
}

// Solution is factory design pattern - we are going to offload object creation to a factory class