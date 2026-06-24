package CarRentalSystem.models;

import java.util.ArrayList;
import java.util.List;

public class BillManager {
    private List<Bill> bills;

    public BillManager() {
        this.bills = new ArrayList<>();
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public Bill getBill(int billID) {
        return bills.stream()
                .filter(bill -> bill.getBillID() == billID)
                .findFirst()
                .orElse(null);
    }
}
