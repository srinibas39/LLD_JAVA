package Patterns.Factory.Optimised;

public class Demo {

    public static void main(String[] args) {
    
        CoffeeProcessor coffeeProcessor = new CoffeeProcessor();
        // Coffee coffee = coffeeProcessor.prepareCoffee("Cappachino", "2% Milk", "10g Sugar", "20g CoffeeBeans");
        // coffee.brew();
        // coffee.freeze();
        // coffee.boil();

        // System.out.println("Cappachino is ready");

        // coffee = coffeeProcessor.prepareCoffee("Expresso", "2% Milk", "10g Sugar", "20g CoffeeBeans");
        // coffee.brew();
        // coffee.freeze();
        // coffee.boil();

        // System.out.println("Expresso is ready");

        // coffee = coffeeProcessor.prepareCoffee("Latte", "2% Milk", "10g Sugar", "20g CoffeeBeans");
        // coffee.brew();
        // coffee.freeze();
        // coffee.boil();

        // System.out.println("Latte is ready");

        Coffee coffee = coffeeProcessor.prepareCoffee("Latte", "2% Milk", "10g Sugar", "20g CoffeeBeans", "10$", "Latte with 2% Milk and 10g Sugar");
        coffee.brew();
        coffee.freeze();
        coffee.boil();

        System.out.println("Price: " + coffee.typeOfCoffee.getPrice());
        System.out.println("Description: " + coffee.typeOfCoffee.getDescription());

        System.out.println("Latte is ready with price and description");
    }
}
