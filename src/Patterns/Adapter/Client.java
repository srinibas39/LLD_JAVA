package Patterns.Adapter;

public class Client {

    public static void main(String[] args) {
        // Using PaypalGateway - now more independent
        PaymentGateway paypalGateway = new PaypalGatewayAdapter(new PaypalGateway());
        PaymentProcessor paymentProcessor = new PaymentAdapter(paypalGateway);
        paymentProcessor.pay(100);
        
        // Can easily switch to RazorpayGateway
        PaymentGateway razorpayGateway = new RazorpayGatewayAdapter(new RazorpayGateway());
        PaymentProcessor razorpayProcessor = new PaymentAdapter(razorpayGateway);
        razorpayProcessor.pay(200);

    
    }
    
}
