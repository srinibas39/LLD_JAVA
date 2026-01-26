package Patterns.Adapter;

// Common interface for payment gateways
public interface PaymentGateway {
    void processPayment(double amount);
}
