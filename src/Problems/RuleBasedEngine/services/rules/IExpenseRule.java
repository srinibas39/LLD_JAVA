package Problems.RuleBasedEngine.services.rules;

import Problems.RuleBasedEngine.model.Expense;

import java.util.Optional;

public interface IExpenseRule {

    Optional<Violation> validate(Expense expense);
}
