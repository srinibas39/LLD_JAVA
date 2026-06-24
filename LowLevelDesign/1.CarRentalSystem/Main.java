package CarRentalSystem;

import java.time.LocalDate;

import CarRentalSystem.enums.PaymentMode;
import CarRentalSystem.enums.ReservationType;
import CarRentalSystem.models.Bill;
import CarRentalSystem.models.Payment;
import CarRentalSystem.models.Reservation;
import CarRentalSystem.models.Store;
import CarRentalSystem.models.User;
import CarRentalSystem.models.VehicleRentalSystem;

public class Main {
    public static void main(String[] args) {
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();
        vehicleRentalSystem.addStore(
                new Store(1, "Store 1", "123 Main St", "Anytown", "CA", "USA", "12345"));
        vehicleRentalSystem.addUser(new User(1, "John Doe", "1234567890"));
        vehicleRentalSystem.addReservation(new Reservation(1, 1, 1, LocalDate.now(),
                LocalDate.now().plusDays(1), ReservationType.DAILY));
        vehicleRentalSystem.addBill(new Bill(1, 1, 100.00));
        vehicleRentalSystem.addPayment(new Payment(1, 1, 100.00, PaymentMode.CREDIT_CARD, LocalDate.now()));
    }
}
