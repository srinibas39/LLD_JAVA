package services.rules;

import model.Expense;

import java.util.Optional;

public interface IExpenseRule {

    Optional<Violation> validate(Expense expense);
}
