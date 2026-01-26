package Patterns.Adapter;

// Adapter for PaypalGateway to implement PaymentGateway interface
public class PaypalGatewayAdapter implements PaymentGateway {
    
    private PaypalGateway paypalGateway;
    
    public PaypalGatewayAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }
    
    @Override
    public void processPayment(double amount) {
        paypalGateway.makePayment(amount);
    }
}
