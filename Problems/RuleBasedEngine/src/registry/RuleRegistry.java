package registry;

import model.ExpenseType;
import services.rules.IExpenseRule;
import services.rules.impl.DisallowRule;
import services.rules.impl.MaxAmountRule;
import services.rules.impl.TotalTripMaxRule;
import services.rules.ITripRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// to read it from registry
public class RuleRegistry {

    public static Map<ExpenseType,List<IExpenseRule>> getRuleRegistry() {
        Map<ExpenseType, List<IExpenseRule>> expenseRuleMap = new HashMap<>();

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
                ExpenseType.ENTERTAINMENT , List.of(
                        new DisallowRule()
                )
        );

        return expenseRuleMap;
    }

    public static List<IExpenseRule> getExpenseRules(){
        return List.of(
                new MaxAmountRule(1000.0)
        );
    }


    public static List<ITripRule> getTripRules(){
        return List.of(
                new TotalTripMaxRule(5000.0)
        );
    }
}
