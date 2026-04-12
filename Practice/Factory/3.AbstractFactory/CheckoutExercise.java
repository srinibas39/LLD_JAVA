public class CheckoutExercise {

    // ===== Product interfaces =====
    interface PaymentGateway {
        void processPayment(double amount);
    }

    interface Invoice {
        void generateInvoice();
    }

    // ===== India products =====
    static class RazorpayGateway implements PaymentGateway {
        @Override
        public void processPayment(double amount) {
            System.out.println("INR via Razorpay: " + amount);
        }
    }

    static class PayUGateway implements PaymentGateway {
        @Override
        public void processPayment(double amount) {
            System.out.println("INR via PayU: " + amount);
        }
    }

    static class GSTInvoice implements Invoice {
        @Override
        public void generateInvoice() {
            System.out.println("Generating GST invoice (India)");
        }
    }

    // ===== US products =====
    static class StripeGateway implements PaymentGateway {
        @Override
        public void processPayment(double amount) {
            System.out.println("USD via Stripe: " + amount);
        }
    }

    static class PaypalGateway implements PaymentGateway {
        @Override
        public void processPayment(double amount) {
            System.out.println("USD via Paypal: " + amount);
        }
    }

    static class JapanGateway implements PaymentGateway {
        @Override
        public void processPayment(double amount) {
            System.out.println("JPY via JapanGateway: " + amount);
        }
    }

    static class USInvoice implements Invoice {
        @Override
        public void generateInvoice() {
            System.out.println("Generating US tax invoice");
        }
    }

    static class JapanInvoice implements Invoice {
        @Override
        public void generateInvoice() {
            System.out.println("Generating Japan invoice");
        }
    }

    // ===== Abstract factory =====
    interface RegionFactory {
        PaymentGateway createPaymentGateway(String gatewayType);
        Invoice createInvoice();
    }

    // ===== TODO #1 =====
    // Implement IndiaFactory:
    // - razorpay -> RazorpayGateway
    // - payu -> PayUGateway
    // - invoice -> GSTInvoice
    static class IndiaFactory implements RegionFactory {
        @Override
        public PaymentGateway createPaymentGateway(String gatewayType) {
            if(gatewayType.equals("razorpay")){
                return new RazorpayGateway();
            }else if(gatewayType.equals("payu")){
                return new PayUGateway();
            }else{
                throw new IllegalArgumentException("Unsupported gateway type: " + gatewayType);
            }
        }

        @Override
        public Invoice createInvoice() {
            return new GSTInvoice();
        }
    }

    // ===== TODO #2 =====
    // Implement USFactory:
    // - stripe -> StripeGateway
    // - paypal -> PaypalGateway
    // - invoice -> USInvoice
    static class USFactory implements RegionFactory {
        @Override
        public PaymentGateway createPaymentGateway(String gatewayType) {
            if(gatewayType.equals("stripe")){
                return new StripeGateway();
            }else if(gatewayType.equals("paypal")){
                return new PaypalGateway();
            }else{
                throw new IllegalArgumentException("Unsupported gateway type: " + gatewayType);
            }
        }

        @Override
        public Invoice createInvoice() {
            return new USInvoice();
        }
    }

    static class JapanFactory implements RegionFactory {
        @Override
        public PaymentGateway createPaymentGateway(String gatewayType) {
            return new JapanGateway();
        }

        @Override
        public Invoice createInvoice() {
            return new JapanInvoice();
        }
    }

    // ===== Client =====
    static class CheckoutService {
        private final PaymentGateway paymentGateway;
        private final Invoice invoice;

        CheckoutService(RegionFactory factory, String gatewayType) {
            this.paymentGateway = factory.createPaymentGateway(gatewayType);
            this.invoice = factory.createInvoice();
        }

        void completeOrder(double amount) {
            paymentGateway.processPayment(amount);
            invoice.generateInvoice();
        }
    }

    public static void main(String[] args) {
        // ===== TODO #3 =====
        // 1) Create India checkout with "razorpay" and call completeOrder(999.0)
        // 2) Create US checkout with "stripe" and call completeOrder(29.0)
        // 3) (Optional) Add a new region factory: JapanFactory

        CheckoutService indiaCheckout = new CheckoutService(new IndiaFactory(), "razorpay");
        indiaCheckout.completeOrder(999.0);

        CheckoutService usCheckout = new CheckoutService(new USFactory(), "stripe");
        usCheckout.completeOrder(29.0);

        CheckoutService japanCheckout = new CheckoutService(new JapanFactory(), "JapanGateway");
        japanCheckout.completeOrder(100.0);
    }
}
