package services.rules.impl;

import model.Expense;
import services.rules.IExpenseRule;
import services.rules.Violation;

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
