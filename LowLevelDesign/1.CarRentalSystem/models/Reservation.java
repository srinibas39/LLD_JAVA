package CarRentalSystem.models;

import java.time.LocalDate;

import CarRentalSystem.enums.ReservationStatus;
import CarRentalSystem.enums.ReservationType;

public class Reservation {

    private int reservationID;
    private int vehicleID;
    private int userID;
    private LocalDate dateBookedFrom;
    private LocalDate dateBookedTo;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;

    public Reservation(int reservationID, int vehicleID, int userID, LocalDate dateBookedFrom,
            LocalDate dateBookedTo, ReservationType reservationType) {
        this.reservationID = reservationID;
        this.vehicleID = vehicleID;
        this.userID = userID;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public int getReservationID() {
        return reservationID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public int getUserID() {
        return userID;
    }

    public LocalDate getDateBookedFrom() {
        return dateBookedFrom;
    }

    public LocalDate getDateBookedTo() {
        return dateBookedTo;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
