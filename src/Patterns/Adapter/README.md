## Adapter Design Pattern

### What is it?
An adapter allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces, converting one interface into another that the client expects.

**Real-world analogy:** Like a power adapter that converts a 3-pin plug to work with a 2-pin socket.

### Why use it?
- **Integrate third-party libraries**: Use existing classes with incompatible interfaces
- **Legacy code integration**: Make old code work with new systems
- **Interface compatibility**: Connect systems that weren't designed to work together
- **Loose coupling**: Client code doesn't need to know about incompatible interfaces

### Real Example: Payment Gateway Integration

**Problem:** You have multiple payment gateways (Paypal, Razorpay) with different method names:
- PaypalGateway uses `makePayment(amount)`
- RazorpayGateway uses `doPayment(amount)`
- Your system expects a common `pay(amount)` interface

**Without Adapter (❌ Tight Coupling):**
```java
// Client needs to know about different gateway methods
if (gatewayType.equals("Paypal")) {
    paypalGateway.makePayment(100);  // Different method name
} else if (gatewayType.equals("Razorpay")) {
    razorpayGateway.doPayment(100);   // Different method name
}
```

**With Adapter (✅ Loose Coupling):**
```java
// Client uses a unified interface
PaymentGateway paypalGateway = new PaypalGatewayAdapter(new PaypalGateway());
PaymentProcessor processor = new PaymentAdapter(paypalGateway);
processor.pay(100);  // Same interface for all gateways
```

### Types of Adapter Pattern

1. **Object Adapter** (Composition - Used in this example)
   - Adapter contains an instance of the adaptee
   - More flexible, follows composition over inheritance
   ```java
   public class PaypalGatewayAdapter implements PaymentGateway {
       private PaypalGateway paypalGateway;  // Composition
       // ...
   }
   ```

2. **Class Adapter** (Inheritance)
   - Adapter extends the adaptee class
   - Less flexible, requires multiple inheritance (not possible in Java)
   ```java
   // Not possible in Java (no multiple inheritance)
   // Would need: class Adapter extends Adaptee implements Target
   ```

### Interview Points

1. **Problem**: 
   - Incompatible interfaces between client and existing classes
   - Third-party libraries with different method signatures
   - Legacy code that needs to work with new systems

2. **Solution**: 
   - Create an adapter class that implements the target interface
   - Adapter wraps the adaptee and translates calls
   - Client interacts only with the adapter

3. **Key Components**:
   - **Target Interface** (`PaymentProcessor`): Interface the client expects
   - **Adaptee** (`PaypalGateway`, `RazorpayGateway`): Existing incompatible classes
   - **Adapter** (`PaymentAdapter`, `PaypalGatewayAdapter`): Bridges the gap

4. **Benefits**:
   - ✅ Single Responsibility: Adapter handles conversion logic
   - ✅ Open/Closed Principle: Add new adapters without modifying existing code
   - ✅ Dependency Inversion: Client depends on abstraction, not concrete classes
   - ✅ Reusability: Existing classes can be reused with different interfaces

5. **Trade-offs**:
   - ⚠️ Additional layer of complexity
   - ⚠️ Slight performance overhead (one extra method call)
   - ⚠️ Can lead to too many adapters if overused

6. **When to use**:
   - Integrating third-party libraries
   - Working with legacy code
   - When you need to use an existing class but its interface doesn't match
   - Microservices integration with different APIs

7. **When NOT to use**:
   - If you can modify the source code directly
   - For simple interface mismatches (just rename methods)
   - When performance is critical and overhead matters

### Structure

```
Client
  ↓ uses
PaymentProcessor (Target Interface)
  ↓ implemented by
PaymentAdapter (Adapter)
  ↓ uses
PaymentGateway (Common Interface)
  ↓ implemented by
PaypalGatewayAdapter / RazorpayGatewayAdapter (Specific Adapters)
  ↓ wraps
PaypalGateway / RazorpayGateway (Adaptees - Third-party classes)
```

### Diagrammatic View

#### 1. Class Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                           CLIENT                                    │
│                                                                     │
│  + main(String[] args)                                             │
└────────────────────┬──────────────────────────────────────────────┘
                     │ uses
                     ▼
         ┌───────────────────────────┐
         │   PaymentProcessor        │  ◄─── Target Interface
         │   (Interface)             │
         ├───────────────────────────┤
         │ + pay(double amount)      │
         └───────────┬───────────────┘
                     │ implements
                     ▼
         ┌───────────────────────────┐
         │   PaymentAdapter          │  ◄─── Main Adapter
         │   (Adapter)               │
         ├───────────────────────────┤
         │ - paymentGateway          │
         │   : PaymentGateway        │
         ├───────────────────────────┤
         │ + PaymentAdapter(         │
         │     PaymentGateway)       │
         │ + pay(double amount)      │
         └───────────┬───────────────┘
                     │ uses
                     ▼
         ┌───────────────────────────┐
         │   PaymentGateway          │  ◄─── Common Interface
         │   (Interface)             │
         ├───────────────────────────┤
         │ + processPayment(         │
         │     double amount)        │
         └───────┬───────────┬───────┘
                 │           │
                 │           │ implements
                 │           │
    ┌────────────▼───┐  ┌────▼──────────────┐
    │ PaypalGateway  │  │ RazorpayGateway   │
    │    Adapter     │  │     Adapter       │  ◄─── Specific Adapters
    ├────────────────┤  ├───────────────────┤
    │ - paypalGateway│  │ - razorpayGateway │
    │   : Paypal     │  │   : Razorpay      │
    │   Gateway      │  │   Gateway         │
    ├────────────────┤  ├───────────────────┤
    │ + processPay-  │  │ + processPay-     │
    │   ment(double) │  │   ment(double)    │
    └────────┬────────┘  └────────┬─────────┘
             │                    │
             │ wraps              │ wraps
             ▼                    ▼
    ┌─────────────────┐  ┌──────────────────┐
    │ PaypalGateway   │  │ RazorpayGateway  │  ◄─── Third-party
    │ (Third-party)   │  │ (Third-party)    │      Classes
    ├─────────────────┤  ├──────────────────┤
    │ + makePayment(  │  │ + doPayment(     │
    │     double)     │  │     double)      │
    │ + verifyPayment│  │ + verifyPayment  │
    │ + getPayment   │  │   Status(String) │
    │   Status(String)│ │ + getPayment     │
    └─────────────────┘  │   Status(String) │
                         └──────────────────┘
```

#### 2. Sequence Diagram - Payment Flow

```
Client          PaymentAdapter      PaymentGateway      PaypalGatewayAdapter    PaypalGateway
  │                    │                    │                    │                    │
  │──pay(100)─────────>│                    │                    │                    │
  │                    │                    │                    │                    │
  │                    │──processPayment(100)──>│                    │                    │
  │                    │                    │                    │                    │
  │                    │                    │──processPayment(100)──>│                    │
  │                    │                    │                    │                    │
  │                    │                    │                    │──makePayment(100)───>│
  │                    │                    │                    │                    │
  │                    │                    │                    │<───[Payment Done]───│
  │                    │                    │                    │                    │
  │                    │                    │<───[Success]────────│                    │
  │                    │                    │                    │                    │
  │                    │<───[Success]──────│                    │                    │
  │                    │                    │                    │                    │
  │<───[Success]───────│                    │                    │                    │
```

#### 3. Component Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                         APPLICATION LAYER                           │
│  ┌──────────────┐                                                   │
│  │   Client     │                                                   │
│  └──────┬───────┘                                                   │
└─────────┼───────────────────────────────────────────────────────────┘
          │
          │ depends on
          ▼
┌─────────────────────────────────────────────────────────────────────┐
│                      ADAPTER LAYER                                  │
│  ┌──────────────────────────────────────────────────────────────┐  │
│  │  PaymentAdapter                                               │  │
│  │  (Adapts PaymentGateway → PaymentProcessor)                  │  │
│  └──────────────────────────────────────────────────────────────┘  │
│                           │                                          │
│                           │ uses                                     │
│                           ▼                                          │
│  ┌──────────────────────────────────────────────────────────────┐  │
│  │  PaymentGateway (Interface)                                  │  │
│  └───────┬───────────────────────────────┬──────────────────────┘  │
│          │                               │                          │
│          │ implements                    │ implements               │
│          ▼                               ▼                          │
│  ┌──────────────────┐          ┌──────────────────────┐           │
│  │PaypalGateway     │          │RazorpayGateway       │           │
│  │Adapter           │          │Adapter               │           │
│  └──────────────────┘          └──────────────────────┘           │
└───────────┬───────────────────────────────┬───────────────────────┘
            │                               │
            │ wraps                          │ wraps
            ▼                               ▼
┌─────────────────────────────────────────────────────────────────────┐
│                    THIRD-PARTY LAYER                                │
│  ┌──────────────────┐          ┌──────────────────────┐           │
│  │ PaypalGateway    │          │ RazorpayGateway      │           │
│  │ (Third-party API)│          │ (Third-party API)     │           │
│  └──────────────────┘          └──────────────────────┘           │
└─────────────────────────────────────────────────────────────────────┘
```

#### 4. Dependency Flow Diagram

```
                    ┌─────────────┐
                    │   Client    │
                    └──────┬──────┘
                           │
                           │ depends on
                           ▼
              ┌────────────────────────┐
              │  PaymentProcessor      │ ◄─── Target (What client needs)
              │  Interface             │
              └───────────┬────────────┘
                          │
                          │ implemented by
                          ▼
              ┌────────────────────────┐
              │  PaymentAdapter        │ ◄─── Adapter (Bridges the gap)
              └───────────┬────────────┘
                          │
                          │ depends on
                          ▼
              ┌────────────────────────┐
              │  PaymentGateway        │ ◄─── Common Interface
              │  Interface             │
              └───────┬────────┬───────┘
                      │        │
        ┌─────────────┘        └─────────────┐
        │                                    │
        │ implements                         │ implements
        ▼                                    ▼
┌──────────────────┐              ┌──────────────────┐
│ PaypalGateway    │              │ RazorpayGateway  │
│ Adapter          │              │ Adapter          │
└────────┬─────────┘              └────────┬─────────┘
         │                                 │
         │ wraps                           │ wraps
         ▼                                 ▼
┌──────────────────┐              ┌──────────────────┐
│ PaypalGateway    │              │ RazorpayGateway  │ ◄─── Adaptees
│ (Third-party)    │              │ (Third-party)    │      (What exists)
└──────────────────┘              └──────────────────┘
```

#### 5. Method Translation Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    METHOD NAME TRANSLATION                      │
└─────────────────────────────────────────────────────────────────┘

Client expects:                    Third-party provides:
┌──────────────────┐              ┌──────────────────┐
│ pay(amount)      │              │ makePayment()    │  ← Paypal
└────────┬─────────┘              │ doPayment()      │  ← Razorpay
         │                         └──────────────────┘
         │                         
         │  PaymentAdapter translates:
         │  pay() → processPayment()
         │                         
         ▼                         
┌──────────────────┐              ┌──────────────────┐
│ processPayment() │              │ makePayment()    │  ← Paypal
└────────┬─────────┘              │ doPayment()      │  ← Razorpay
         │                         └──────────────────┘
         │                         
         │  Gateway Adapters translate:
         │  processPayment() → makePayment() / doPayment()
         │                         
         ▼                         
         └─────────────────────────┘
```

**Translation Chain:**
```
Client.pay(100)
    ↓
PaymentAdapter.pay(100)
    → calls paymentGateway.processPayment(100)
    ↓
PaypalGatewayAdapter.processPayment(100)
    → calls paypalGateway.makePayment(100)
    ↓
PaypalGateway.makePayment(100) ✅
```

### Code Flow

1. **Client** calls `paymentProcessor.pay(100)`
2. **PaymentAdapter** receives the call and forwards to `paymentGateway.processPayment(100)`
3. **PaypalGatewayAdapter** receives the call and translates to `paypalGateway.makePayment(100)`
4. **PaypalGateway** (third-party) executes the actual payment

### Common Interview Questions

**Q: Adapter vs Decorator?**
- **Adapter**: Changes interface to make incompatible classes work together
- **Decorator**: Adds behavior without changing interface

**Q: Adapter vs Facade?**
- **Adapter**: Works with one incompatible class, changes its interface
- **Facade**: Provides simplified interface to a complex subsystem (multiple classes)

**Q: Adapter vs Bridge?**
- **Adapter**: Makes existing incompatible classes work together (retrofit)
- **Bridge**: Separates abstraction from implementation (design-time decision)

### Real-world Examples

- **Java Collections**: `Arrays.asList()` adapts array to List interface
- **Spring Framework**: Adapters for different HTTP clients (RestTemplate, WebClient)
- **JDBC Drivers**: Database-specific adapters implementing JDBC interface
- **Android**: RecyclerView.Adapter adapts data to ViewHolder pattern
- **Payment Gateways**: Stripe, PayPal, Razorpay adapters in e-commerce
