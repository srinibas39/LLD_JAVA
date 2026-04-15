# Practice: Email template system (Prototype pattern)

## Problem

You are building an **email template** module. Each template type (for example “welcome”) is expensive to configure: subject line, default body, formatting flags, and so on. You do **not** want every caller to run that setup or to call `new WelcomeEmail()` everywhere.

Use the **Prototype** pattern:

1. Define a prototype type `EmailTemplate` with:
   - `EmailTemplate clone()` — returns a **new instance** with the same configured state as the prototype.
   - `void setContent(String content)` — updates the body for this instance only.
   - `void send(String to)` — prints a line that includes recipient, subject, and content (see the skeleton for the expected format).

2. Implement `WelcomeEmail`:
   - Default subject: `Welcome to TUF+`
   - Default content: `Hi there! Thanks for joining us.`
   - `clone()` must produce another `WelcomeEmail` that does **not** share mutable state incorrectly with the original (for this exercise, fields are `String`s; a shallow copy via `super.clone()` is enough).

3. Implement `EmailTemplateRegistry`:
   - Holds a `Map<String, EmailTemplate>` of **prototype** instances (registered once at startup).
   - `getTemplate(String type)` must return a **clone** of the registered prototype for that key, so callers never mutate the shared prototype stored in the map.

4. In `main`, demonstrate:
   - Two separate calls to `getTemplate("welcome")`, each with different `setContent` and `send` targets, proving you get **independent** objects.

## Constraints

- Do not return the same instance from `getTemplate`; always return a **clone**.
- Client code should depend on `EmailTemplate`, not on `new WelcomeEmail()` except inside registration/bootstrap.

## Files

- `EmailTemplateExercise.java` — open this file and complete the `TODO` sections.

When you are done, compile and run:

```bash
javac EmailTemplateExercise.java && java EmailTemplateExercise
```
