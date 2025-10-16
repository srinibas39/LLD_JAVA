package rules;

import model.Expense;

import java.util.Optional;

public interface ExpenseRule {

    Optional<Violation> validate(Expense expense);
}
