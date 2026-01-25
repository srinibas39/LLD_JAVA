package Patterns.Adapter;

public class PaypalGateway {

    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made via Paypal");
    }

    public void verifyPayment(String paymentId) {
        System.out.println("Payment of " + paymentId + " verified via Paypal");
    } 

    public void getPaymentStatus(String paymentId) {
        System.out.println("Payment status of " + paymentId + " is verified via Paypal");
    }
    
}
