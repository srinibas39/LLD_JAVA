package Problems.RuleBasedEngine.services;

import Problems.RuleBasedEngine.model.Expense;
import Problems.RuleBasedEngine.model.ExpenseType;
import Problems.RuleBasedEngine.services.rules.IExpenseRule;
import Problems.RuleBasedEngine.services.rules.ITripRule;
import Problems.RuleBasedEngine.services.rules.Violation;

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
