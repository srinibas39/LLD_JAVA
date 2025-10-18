package services.rules.impl;

import model.Expense;
import services.rules.IExpenseRule;
import services.rules.Violation;

import java.util.Optional;

public class DisallowRule implements IExpenseRule {

    @Override
    public Optional<Violation> validate(Expense expense) {
        return Optional.of(Violation.getViolationMessage(expense.getExpenseType()+" Expense is not allowed"));
    }
}
