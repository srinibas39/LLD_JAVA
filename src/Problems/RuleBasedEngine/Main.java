package Problems.RuleBasedEngine;

import Problems.RuleBasedEngine.model.Expense;
import Problems.RuleBasedEngine.model.ExpenseType;
import Problems.RuleBasedEngine.services.Impl.RuleEngine;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense("1","1",100.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("2","1",200.0,ExpenseType.AIRFARE));
        expenses.add(new Expense("3","1",700.0,ExpenseType.ENTERTAINMENT));
        expenses.add(new Expense("4", "1" , 4000.0,ExpenseType.RESTAURANT));



        RuleManagerRunner ruleManagerRunner = new RuleManagerRunner(
                new RuleEngine()
        );

        ruleManagerRunner.run(expenses);

    }
}
