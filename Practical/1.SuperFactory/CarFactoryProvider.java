package Practical.SuperFactory;

public class CarFactoryProvider {
    public CarFactory getCarFactory(String carType , String brand) {
        if (carType.equals("Luxury")) {
            return new LuxuryCarFactory(brand);
        } else if (carType.equals("Economy")) {
            return new EconomyCarFactory(brand);
        }
        return null;
    }
}
