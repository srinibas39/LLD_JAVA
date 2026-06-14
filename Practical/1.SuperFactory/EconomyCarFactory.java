package Practical.SuperFactory;

public class EconomyCarFactory implements CarFactory {

    private String brand;

    public EconomyCarFactory(String brand) {
        this.brand = brand;
    }

    @Override
    public CarInterior createCarInterior() {
        return new EconomyCarInterior();
    }

    @Override
    public CarExterior createCarExterior() {
        return new EconomyCarExterior();
    }
}
