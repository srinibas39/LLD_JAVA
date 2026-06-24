package CarRentalSystem.models;

import CarRentalSystem.enums.VehicleStatus;
import CarRentalSystem.enums.VehicleType;

public class Vehicle {

    private int vehicleID;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private double dailyRentalCost;
    private VehicleStatus vehicleStatus;

    public Vehicle(int vehicleID, String vehicleNumber, VehicleType vehicleType) {
        this.vehicleID = vehicleID;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setDailyRentalCost(double dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
