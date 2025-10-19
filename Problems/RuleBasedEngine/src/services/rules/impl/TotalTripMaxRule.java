package services.rules.impl;

import model.Expense;
import services.rules.ITripRule;
import services.rules.Violation;
import utils.ExpenseUtils;

import java.util.List;
import java.util.Optional;

public class TotalTripMaxRule implements ITripRule {

    private final double maxAmount;

    public TotalTripMaxRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> validate(List<Expense> expenses) {
        if(!ExpenseUtils.checkExpenseOfSameTrip(expenses)){
            return Optional.of(Violation.getViolationMessage("Expenses are not of same trip"));
        }
        double sum = 0;
        for(Expense expense : expenses){
            sum += expense.getAmount();
        }
        if(sum > maxAmount){
            return Optional.of(Violation.getViolationMessage("Total amount of "+sum+" is allowed per trip."));
        }else{
            return Optional.empty();
        }
    }
}
