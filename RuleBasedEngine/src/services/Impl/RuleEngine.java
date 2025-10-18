package services.Impl;

import model.Expense;
import model.ExpenseType;
import services.IRuleEngine;
import services.rules.IExpenseRule;
import services.rules.ITripRule;
import services.rules.Violation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RuleEngine implements IRuleEngine {

    @Override
    public List<Violation> findViolations(
            List<Expense> expenses,
            Map<ExpenseType, List<IExpenseRule>> expensesRulesRegistry,
            List<IExpenseRule> expenseRules,
            List<ITripRule> tripRules) {

        List<Violation> violations = new ArrayList<>();

        for (Expense expense : expenses) {
            // Get all rules applicable for this expense type
            List<IExpenseRule> allExpenseRules =
                    expensesRulesRegistry.getOrDefault(expense.getExpenseType(), List.of());

            // Apply global expense rules
            checkViolationAgainstExpenseRule(expenseRules, violations, expense);

            // Apply type-specific expense rules
            checkViolationAgainstExpenseRule(allExpenseRules, violations, expense);
        }

        // Apply trip-level rules (across all expenses)
        checkViolationAgainstTripRule(expenses, violations, tripRules);

        return violations;
    }

    private void checkViolationAgainstExpenseRule(
            List<IExpenseRule> expenseRules,
            List<Violation> violations,
            Expense expense) {

        for (IExpenseRule expenseRule : expenseRules) {
            expenseRule.validate(expense).ifPresent(violations::add);
        }
    }

    private void checkViolationAgainstTripRule(
            List<Expense> expenses,
            List<Violation> violations,
            List<ITripRule> tripRules) {

        for (ITripRule tripRule : tripRules) {
            tripRule.validate(expenses).ifPresent(violations::add);
        }
    }
}
