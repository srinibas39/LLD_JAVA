package CarRentalSystem.models;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private List<Reservation> reservations;

    public ReservationManager() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation getReservation(int reservationID) {
        return reservations.stream()
                .filter(reservation -> reservation.getReservationID() == reservationID)
                .findFirst()
                .orElse(null);
    }
}
