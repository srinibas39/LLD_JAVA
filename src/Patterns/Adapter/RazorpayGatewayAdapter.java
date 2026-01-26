package Patterns.Adapter;

// Adapter for RazorpayGateway to implement PaymentGateway interface
public class RazorpayGatewayAdapter implements PaymentGateway {
    
    private RazorpayGateway razorpayGateway;
    
    public RazorpayGatewayAdapter(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }
    
    @Override
    public void processPayment(double amount) {
        razorpayGateway.doPayment(amount);
    }
}
