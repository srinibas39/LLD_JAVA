package Problems.RuleBasedEngine;

import Problems.RuleBasedEngine.model.Expense;
import Problems.RuleBasedEngine.model.ExpenseType;
import Problems.RuleBasedEngine.registry.RuleRegistry;
import Problems.RuleBasedEngine.services.Impl.RuleEngine;
import Problems.RuleBasedEngine.services.rules.IExpenseRule;
import Problems.RuleBasedEngine.services.rules.ITripRule;
import Problems.RuleBasedEngine.services.rules.Violation;

import java.util.List;
import java.util.Map;

public class RuleManagerRunner {
    private final RuleEngine ruleEngine;
    public RuleManagerRunner(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void run(List<Expense> expenses) {
        Map<ExpenseType,List<IExpenseRule>> rulesMap =  RuleRegistry.getRuleRegistry();
        List<IExpenseRule> expenseRules =  RuleRegistry.getExpenseRules();
        List<ITripRule> tripRules =  RuleRegistry.getTripRules();

        List<Violation> violations = ruleEngine.findViolations(expenses,rulesMap,expenseRules,tripRules);

      for(Violation violation : violations){
//          System.out.println(violation.toString());
       System.out.println(violation.getMessage());
      }

    }
}
