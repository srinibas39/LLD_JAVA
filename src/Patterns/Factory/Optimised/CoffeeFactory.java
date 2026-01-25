package Patterns.Factory.Optimised;

// THis class is going to habdle to create the coffee objects
public class CoffeeFactory {

    
    public static Coffee getCoffee(String whichCoffeee , String milk , String sugar , String coffeebeans){
        Coffee coffee = null;
        if(whichCoffeee.equals("Cappachino")){
            coffee = new Cappachino(new CappachinoIngriedients(milk , sugar , coffeebeans));
        } else if(whichCoffeee.equals("Expresso")){
            coffee = new Expresso(new ExpressoIngredients(milk , sugar , coffeebeans));
        } else if(whichCoffeee.equals("Latte")){

          coffee = new Latte(new LatteIngriedients(milk, sugar, coffeebeans));
        }
        return coffee;
    }
    
}

//problem with this approach is class explostion 
// for exmaple for latte, if we someone wants to different milk , differnt sugar
// So we go abstract factory pattern
