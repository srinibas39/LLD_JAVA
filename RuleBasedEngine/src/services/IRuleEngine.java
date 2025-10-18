package services;

import model.Expense;
import model.ExpenseType;
import services.rules.IExpenseRule;
import services.rules.ITripRule;
import services.rules.Violation;

import java.util.List;
import java.util.Map;

public interface IRuleEngine {

    List<Violation> findViolations(
            List<Expense> expenses,
            Map<ExpenseType,List<IExpenseRule>> expensesRulesRegistry,
            List<IExpenseRule> expenseRules,
            List<ITripRule> tripRules
    );
}
