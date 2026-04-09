# Singleton Pattern

## 1. What is it? Why do we need it?

The **Singleton** pattern ensures a class has **only one instance** for the **application lifecycle** and provides a **global access point** to that instance.

**Why use it?**

- Something should exist **once** because of **global state**, **resource limits**, or **domain logic** (one analytics engine, one connection pool coordinator).
- Many parts of the system need the **same** instance without passing references everywhere.

**Common examples:** database connection management, logging, analytics, configuration caches.

---

## 2. The problem: multiple instances

If callers can use `new` freely, every call gets a **new object**. Counters, caches, or shared state split across instances.

```java
public class Main {
    public static void main(String[] args) {
        JudgeAnalytics a = new JudgeAnalytics();
        a.countRun();
        a.countSubmit();
        System.out.println(a);

        JudgeAnalytics b = new JudgeAnalytics();
        b.countRun();
        System.out.println(b);
        // a and b are different objects — not a singleton.
    }
}
```

<details>
<summary>Try this</summary>

Add `JudgeAnalytics` with a couple of methods and run: the two `println` outputs show **different** object identities.

</details>

---

## 3. Multithreading primer: where Singleton breaks

In a multithreaded app, two threads can run `getInstance()` at almost the same time.

If your code is naive lazy initialization:

1. Thread-A checks `instance == null` -> true.
2. Scheduler switches to Thread-B before A assigns.
3. Thread-B checks `instance == null` -> true.
4. Both create objects, so two instances exist briefly (or permanently if one leaks through references).

That is a **race condition**: result depends on timing, not logic.

`synchronized`, `volatile`, and class-loading guarantees are ways to make this deterministic.

---

## 4. Eager initialization (thread-safe)

The instance is created when the class loads. No locking needed for reads; safe for multithreaded use.

```java
class JudgeAnalytics {
    private static final JudgeAnalytics INSTANCE = new JudgeAnalytics();

    private JudgeAnalytics() { }

    public static JudgeAnalytics getInstance() {
        return INSTANCE;
    }
}

public class Main {
    public static void main(String[] args) {
        JudgeAnalytics x = JudgeAnalytics.getInstance();
        JudgeAnalytics y = JudgeAnalytics.getInstance();
        System.out.println(x);
        System.out.println(y); // same reference as x
    }
}
```

**Why thread-safe?**

- JVM class initialization is synchronized internally.
- `INSTANCE` is created exactly once before any thread gets it.

**When to use:** the singleton is lightweight, always needed, and startup cost is acceptable.

**Trade-off:** instance exists even if nobody calls `getInstance()` (eager class-load time).

---

## 5. Lazy initialization (single-threaded OK)

Create the instance on first `getInstance()`. **Not safe** if multiple threads can call `getInstance()` concurrently without extra synchronization.

```java
class JudgeAnalytics {
    private static JudgeAnalytics instance;

    private JudgeAnalytics() { }

    public static JudgeAnalytics getInstance() {
        if (instance == null) {
            instance = new JudgeAnalytics();
        }
        return instance;
    }
}
```

**When to use:** toy examples, coding interviews (before adding thread-safety), or guaranteed single-threaded programs.

**Risk in real servers/apps:** web requests or background workers can call this concurrently and break singleton guarantees.

---

## 6. Lazy + `synchronized` method (thread-safe, simple)

The entire `getInstance()` is synchronized: correct but can be a bottleneck under contention.

```java
class JudgeAnalytics {
    private static JudgeAnalytics instance;

    private JudgeAnalytics() { }

    public static synchronized JudgeAnalytics getInstance() {
        if (instance == null) {
            instance = new JudgeAnalytics();
        }
        return instance;
    }
}
```

**What `synchronized` does here**

- Locks on `JudgeAnalytics.class` before entering the method.
- Only one thread can execute `getInstance()` at a time.
- Other threads block until the lock is released.

**Pros**

- Easiest correct lazy singleton.
- Great for clarity and low-traffic systems.

**Cons**

- Every call pays lock overhead, even after instance is already created.
- Can reduce throughput if called very frequently by many threads.

---

## 7. Double-checked locking (lazy + optimized locking)

Only synchronize when the instance might still be `null`. Requires **`volatile`** on the field (Java memory model) so other threads see a fully constructed instance.

```java
class JudgeAnalytics {
    private static volatile JudgeAnalytics instance;

    private JudgeAnalytics() { }

    public static JudgeAnalytics getInstance() {
        if (instance == null) {
            synchronized (JudgeAnalytics.class) {
                if (instance == null) {
                    instance = new JudgeAnalytics();
                }
            }
        }
        return instance;
    }
}
```

<details>
<summary>Why <code>volatile</code>?</summary>

Without `volatile`, another thread might see a non-`null` reference before the object is fully initialized. With `volatile`, writes are visible in the right order.

</details>

**Why two checks?**

- First check avoids locking on the common path (instance already exists).
- Second check prevents duplicate creation once inside synchronized block.

**When to use:** high-traffic paths where singleton access is extremely frequent and lock overhead matters.

---

## 8. Bill Pugh / initialization-on-demand holder (Java 5+)

Uses the JVM class loader: the holder class is loaded only when first referenced, creating the instance **lazily** without explicit locking in your code.

```java
class JudgeAnalytics {
    private JudgeAnalytics() { }

    private static class Holder {
        private static final JudgeAnalytics INSTANCE = new JudgeAnalytics();
    }

    public static JudgeAnalytics getInstance() {
        return Holder.INSTANCE;
    }
}
```

Often preferred when you want **lazy** creation and **thread safety** without `synchronized` in `getInstance()` or DCL complexity.

---

## 9. Pros and cons

| Pros | Cons |
|------|------|
| One clear place for “the” instance | Easy to overuse; hides dependencies |
| Enforces a single instance | **Harder to unit test** (global state, hidden construction) |
| Global access without plumbing parameters everywhere | Callers become **tightly coupled** to the concrete singleton |
| Lazy variants can defer work until needed | **Parameterized** “singletons” blur into **Factory**; easy to misuse |
| Eager / Bill Pugh avoid some race issues by design | Lazy + threading needs care (**race conditions**, `volatile`, DCL) |
| | Often argued to **violate SRP** (manages its own lifecycle + domain logic) |

---

## Quick reference

| Approach | Creation time | Thread-safe? | Performance profile | Recommended |
|----------|---------------|--------------|---------------------|-------------|
| Eager static field | Class load | Yes | Fast reads, higher startup/memory cost | Yes, if instance always needed |
| Lazy (naive) | First `getInstance()` | No (multi-thread) | Fast but incorrect under races | No for production multithreaded apps |
| `synchronized` method | First `getInstance()` | Yes | Simple but lock cost on every call | Yes, for simplicity-first code |
| Double-checked locking | First `getInstance()` | Yes (with `volatile`) | Near lock-free after init | Yes, when optimization is justified |
| Bill Pugh holder | First holder use | Yes | Fast + lazy + simple | Usually best default in Java |

---

## Checklist (self-quiz)

- [ ] Explain why two `new JudgeAnalytics()` break “single global analytics” semantics.
- [ ] Compare eager, lazy, and Bill Pugh in one sentence each.
- [ ] Why is naive lazy initialization unsafe under multithreading?
- [ ] Why does DCL need `volatile`?
- [ ] In `synchronized getInstance()`, what object is used as the lock?
- [ ] How does Bill Pugh get lazy + thread-safe without synchronizing every `getInstance()` call?
