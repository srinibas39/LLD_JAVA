package CarRentalSystem.models;

import java.time.LocalDate;

import CarRentalSystem.enums.PaymentMode;

public class Payment {
    private int paymentID;
    private int billID;
    private double amount;
    private PaymentMode paymentMode;
    private LocalDate paymentDate;

    public Payment(int paymentID, int billID, double amount, PaymentMode paymentMode, LocalDate paymentDate) {
        this.paymentID = paymentID;
        this.billID = billID;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentDate = paymentDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getBillID() {
        return billID;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}
