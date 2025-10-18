package services.rules;

import model.Expense;

import java.util.List;
import java.util.Optional;

public interface ITripRule {

    Optional<Violation> validate(List<Expense> expenses);

}
