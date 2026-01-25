package Patterns.Factory.Optimised;

public class CoffeeProcessor {
    
    public Coffee prepareCoffee(String whichCoffee , String whichMilk , String whichSugar , String whichCoffeeBeans) {
       
        Coffee coffee = CoffeeFactory.getCoffee(whichCoffee , whichMilk , whichSugar , whichCoffeeBeans);
        return coffee;
    }

    public Coffee prepareCoffee(String whichCoffee , String whichMilk , String whichSugar , String whichCoffeeBeans , String whichPrice , String whichDescription) {
        Coffee coffee = CoffeeFactory.getCoffee(whichCoffee , whichMilk , whichSugar , whichCoffeeBeans , whichPrice , whichDescription);
        return coffee;
    }
}

// Solution is factory design pattern - we are going to offload object creation to a factory class