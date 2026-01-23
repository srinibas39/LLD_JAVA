package Problems.RuleBasedEngine.services.rules.impl;

import Problems.RuleBasedEngine.model.Expense;
import Problems.RuleBasedEngine.services.rules.IExpenseRule;
import Problems.RuleBasedEngine.services.rules.Violation;

import java.util.Optional;

public class DisallowRule implements IExpenseRule {

    @Override
    public Optional<Violation> validate(Expense expense) {
        return Optional.of(Violation.getViolationMessage(expense.getExpenseType()+" Expense is not allowed"));
    }
}
