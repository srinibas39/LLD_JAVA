package utils;

import model.Expense;

import java.util.List;

public class ExpenseUtils {

    public static boolean checkExpenseOfSameTrip(List<Expense> expenses){
        if(expenses.isEmpty()){
            return true;
        }
        String tripId = expenses.get(0).getTripId();
        for(Expense expense : expenses){
            if(!expense.getTripId().equals(tripId)){
                return false;
            }
        }
        return true;
    }
}
