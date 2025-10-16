package rules;

import model.Expense;

import java.util.List;
import java.util.Optional;

public interface TripRule {

    Optional<List<Violation>> validate(List<Expense> expenses);

}
