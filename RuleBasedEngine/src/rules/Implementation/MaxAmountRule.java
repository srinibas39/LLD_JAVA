package rules.Implementation;

import model.Expense;
import rules.ExpenseRule;
import rules.Violation;

import java.util.Optional;

public class MaxAmountRule implements ExpenseRule {

    private final Double maxAmount;

    public MaxAmountRule(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> validate(Expense expense) {
        if(expense.getAmount() > maxAmount){
            return Optional.of(Violation.getViolationMessage("Expense amount "+expense.getAmount()+" is more than allowed"));
        }
        return Optional.empty();
    }
}
