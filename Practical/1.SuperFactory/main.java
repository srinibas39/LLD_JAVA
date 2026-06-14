package Practical.SuperFactory;

public class main {
    public static void main(String[] args) {
        CarFactoryProvider carFactoryProvider = new CarFactoryProvider();
        createCar(carFactoryProvider, "Luxury", "Toyota");
        createCar(carFactoryProvider, "Economy", "Toyota");
        createCar(carFactoryProvider, "Luxury", "Honda");
        createCar(carFactoryProvider, "Economy", "Honda");
        createCar(carFactoryProvider, "Luxury", "Ford");
        createCar(carFactoryProvider, "Economy", "Ford");
        createCar(carFactoryProvider, "Luxury", "Chevrolet");
        createCar(carFactoryProvider, "Economy", "Chevrolet");
        createCar(carFactoryProvider, "Luxury", "Nissan");
        createCar(carFactoryProvider, "Economy", "Nissan");
    }

    private static void createCar(CarFactoryProvider carFactoryProvider, String carType, String brand) {
        CarFactory carFactory = carFactoryProvider.getCarFactory(carType, brand);
        carFactory.createCar(carType);
    }
}