## Factory Design Pattern

### What is it?
A factory creates objects for you instead of using `new` directly.

**Types:**
- **Simple Factory** (this example): One factory creates all coffee types
- **Abstract Factory**: Multiple factories for different families (e.g., Italian coffee factory, American coffee factory) , [muliple factories inside an industry]

### Why use it?
- **Avoid tight coupling**: Don't hardcode `new CoffeeType()` everywhere
- **Centralize creation**: All object creation logic in one place
- **Easy to extend**: Add new coffee types without changing existing code

### Real Example: Coffee Machine
Instead of:
```java
Coffee coffee = new Cappachino(...);  // ❌ Tight coupling
```

Use:
```java
Coffee coffee = CoffeeFactory.getCoffee("Cappachino", ...);  // ✅ Loose coupling
```

### Interview Points
1. **Problem**: Direct `new` keyword creates tight coupling
2. **Solution**: Factory class handles object creation
3. **Benefit**: Client code doesn't depend on concrete classes
4. **Trade-off**: One extra layer, but more flexible

### Structure
- `Coffee` (abstract) → Base class
- `Cappachino`, `Latte`, `Expresso` → Concrete implementations
- `CoffeeFactory` → Creates the right coffee object
- `CoffeeProcessor` → Uses factory to prepare coffee