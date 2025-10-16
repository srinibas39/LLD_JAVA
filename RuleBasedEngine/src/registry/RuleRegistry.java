package registry;

import model.ExpenseType;
import rules.ExpenseRule;
import rules.Implementation.DisallowRule;
import rules.Implementation.MaxAmountRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// to read it from registry
public class RuleRegistry {

    public static void getRuleRegistry() {
        Map<ExpenseType, List<ExpenseRule>> expenseRuleMap = new HashMap<>();

        expenseRuleMap.put(
                ExpenseType.AIRFARE , List.of(
                        new DisallowRule()
                )
        );

        expenseRuleMap.put(
                ExpenseType.RESTAURANT , List.of(
                        new MaxAmountRule(750.0)
                )
        );

        expenseRuleMap.put(
                ExpenseType.ENTTERTAINMENT , List.of(
                        new DisallowRule()
                )
        );
    }

    public static List<ExpenseRule> getExpenseRuleMap() {
        return null;
    }
}
