package Patterns.Factory.Problematic;

public class CoffeeProcessor {
    
    public ICoffee prepareCoffee(String  whichCoffeeToPrepare) {
       
        ICoffee coffee = null;
        if(whichCoffeeToPrepare.equals("Cappachino")) {
            coffee = new Cappachino();
        } else if(whichCoffeeToPrepare.equals("Expresso")) {
            coffee = new Expresso();
        } else if(whichCoffeeToPrepare.equals("Latte")) {
            coffee = new Latte();
        }
        return coffee;
    }
}

//Problems with this approach
//1. We are using the new keyword too much
//2. We are not following the open/closed principle - We are not able to add new coffee types without modifying the code
//3. We are not following the single responsibility principle - CoffeeProcessor is responsible for preparing coffee but it is also responsible for creating the coffee objects
//4. We are not following the dependency inversion principle - CoffeeProcessor is dependent on the concrete coffee classes
//5. We are not following the liskov substitution principle - CoffeeProcessor is not able to substitute the concrete coffee classes with their subclasses
//6. We are not following the interface segregation principle - CoffeeProcessor is not able to segregate the coffee classes into different interfaces
//7. We are not following the dependency inversion principle - CoffeeProcessor is not able to invert the dependency of the concrete coffee classes
//8. We are not following the liskov substitution principle - CoffeeProcessor is not able to substitute the concrete coffee classes with their subclasses
//9. We are not following the interface segregation principle - CoffeeProcessor is not able to segregate the coffee classes into different interfaces
    