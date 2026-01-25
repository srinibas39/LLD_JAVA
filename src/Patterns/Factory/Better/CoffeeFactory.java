package Patterns.Factory.Better;

// THis class is going to habdle to create the coffee objects
public class CoffeeFactory {

    
    public static ICoffee getCoffee(String whichCoffeee){
        ICoffee coffee = null;
        if(whichCoffeee.equals("Cappachino")){
            coffee = new Cappachino();
        } else if(whichCoffeee.equals("Expresso")){
            coffee = new Expresso();
        } else if(whichCoffeee.equals("Latte")){
          coffee = new Latte();
        }
        return coffee;
    }
    
}

//problem with this approach is class explostion 
// for exmaple for latte, if we someone wants to different milk , differnt sugar
// So we go abstract factory pattern
