package rules.Implementation;

import model.Expense;
import rules.ExpenseRule;
import rules.Violation;

import java.util.Optional;

public class DisallowRule implements ExpenseRule {

    @Override
    public Optional<Violation> validate(Expense expense) {
        return Optional.of(Violation.getViolationMessage("Expense type "+expense.getExpenseType()+" is not allowed"));
    }
}
