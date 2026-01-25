package Patterns.Factory.Optimised;

public class LatteType implements TypeOfCoffee {


    String price;
    String description;

    public LatteType(String price , String description) {
        this.price = price;
        this.description = description;
    }

    
    @Override
    public String getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
