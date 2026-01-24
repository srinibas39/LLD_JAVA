# Repository and Iterator Pattern

## Question

You have a consumer, which is consuming the data from a data stream (assume it as a list). We have to read the data one by one. How to do it??

## Repository Pattern

Abstraction layer between business logic and data access. Separates data access logic from business code.

**Key Benefits:**
- Separates data access from business logic
- Easy to test and mock

**Where Used:**
- ORM frameworks (Hibernate, JPA)
- API clients
- Microservices

## Iterator Pattern

Provides a way to access elements of a collection sequentially without exposing its structure.

**Key Benefits:**
- Hides iteration complexity
- Supports pagination

**Where Used:**
- Pagination (like this example)
- Database cursors
- File processing
- Stream processing

**Types of Iterator**
- Sequential Iterator - Forward Iterator , backward Iterator
- Randomised Iterator
- Jumper Iterator  

