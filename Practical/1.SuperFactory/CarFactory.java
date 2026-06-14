package Practical.SuperFactory;

public interface CarFactory {
    CarInterior createCarInterior();
    CarExterior createCarExterior();

    default void createCar(String carType) {
        CarInterior carInterior = createCarInterior();
        CarExterior carExterior = createCarExterior();
        
        carInterior.produceCarInterior();
        carExterior.produceCarExterior();

        System.out.println("Car created successfully both interior and exterior");
    }
}