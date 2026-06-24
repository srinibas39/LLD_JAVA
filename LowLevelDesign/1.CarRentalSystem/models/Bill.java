package CarRentalSystem.models;

public class Bill {
    private int billID;
    private int reservationID;
    private double totalBillAmount;
    private boolean billPaid;

    public Bill(int billID, int reservationID, double totalBillAmount) {
        this.billID = billID;
        this.reservationID = reservationID;
        this.totalBillAmount = totalBillAmount;
        this.billPaid = false;
    }

    public int getBillID() {
        return billID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public boolean isBillPaid() {
        return billPaid;
    }

    public void setBillPaid(boolean billPaid) {
        this.billPaid = billPaid;
    }

    @Override
    public String toString() {
        return "Bill [billID=" + billID + ", reservationID=" + reservationID + ", totalBillAmount=" + totalBillAmount
                + ", billPaid=" + billPaid + "]";
    }
}
