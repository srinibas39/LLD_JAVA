package model;

//later we will use builder pattern
public class Expense {

    private final String expenseid;
    private final String tripId;
    private final Double amount;
    private final ExpenseType expenseType;

    public Expense(String expenseid, String tripId, Double amount, ExpenseType expenseType) {
        this.expenseid = expenseid;
        this.tripId = tripId;
        this.amount = amount;
        this.expenseType = expenseType;
    }

    public String getExpenseid() {
        return expenseid;
    }
    public String getTripId() {
        return tripId;
    }
    public Double getAmount() {
        return amount;
    }
    public ExpenseType getExpenseType() {
        return expenseType;
    }

}
