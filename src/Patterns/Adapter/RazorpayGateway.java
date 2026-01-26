package Patterns.Adapter;

// Third party APIs
public class RazorpayGateway {

    

    public void doPayment(double amount) {
        System.out.println("Payment of " + amount + " made via Razorpay");
    }

    public void verifyPaymentStatus(String paymentId) {
        System.out.println("Payment of " + paymentId + " verified via Razorpay");
    }

    public void getPaymentStatus(String paymentId) {
        System.out.println("Payment status of " + paymentId + " is verified via Razorpay");
    }
}
