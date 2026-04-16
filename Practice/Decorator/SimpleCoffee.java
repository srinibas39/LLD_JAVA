package Practice.Decorator;

interface Coffee{
    String getDescription();
    double getCost();
}

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}

class CoffeeDecorator implements Coffee{
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

class Sugar extends CoffeeDecorator{
    public Sugar(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}
class Milk extends CoffeeDecorator{
    public Milk(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
class Cream extends CoffeeDecorator{
    public Cream(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0;
    }
}
class Main{
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee sugarCoffee = new Sugar(simpleCoffee);
        Coffee milkCoffee = new Milk(sugarCoffee);
        Coffee creamCoffee = new Cream(milkCoffee);
        System.out.println(creamCoffee.getDescription());
        System.out.println(creamCoffee.getCost());  
    }
}


