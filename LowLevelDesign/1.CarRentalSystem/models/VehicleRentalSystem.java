package CarRentalSystem.models;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    private List<Store> stores;
    private List<User> users;
    private List<Reservation> reservations;
    private List<Bill> bills;
    private List<Payment> payments;

    public VehicleRentalSystem() {
        this.stores = new ArrayList<>();
        this.users = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.bills = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public List<Store> getStores() {
        return stores;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
        Bill bill = bills.stream()
                .filter(b -> b.getBillID() == payment.getBillID())
                .findFirst()
                .orElse(null);
        if (bill != null) {
            bill.setBillPaid(true);
        }
    }

    public void removeStore(Store store) {
        stores.remove(store);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
