package Problems.RuleBasedEngine.services.rules.impl;

import Problems.RuleBasedEngine.model.Expense;
import Problems.RuleBasedEngine.services.rules.IExpenseRule;
import Problems.RuleBasedEngine.services.rules.Violation;

import java.util.Optional;

public class MaxAmountRule implements IExpenseRule {

    private final Double maxAmount;

    public MaxAmountRule(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> validate(Expense expense) {
        if(expense.getAmount() > maxAmount){
            return Optional.of(Violation.getViolationMessage(expense.getExpenseType()+" Expense amount "+expense.getAmount()+" > " + maxAmount + " is not allowed"));
        }
        return Optional.empty();
    }
}
