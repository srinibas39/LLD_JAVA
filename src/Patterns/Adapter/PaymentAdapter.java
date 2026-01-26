package Patterns.Adapter;

// Adapter that works with any PaymentGateway implementation
public class PaymentAdapter implements PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentAdapter(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void pay(double amount) {
        paymentGateway.processPayment(amount);
    }
    
}

