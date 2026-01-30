package Problems.ATM;

public class ATMClass {

    private ATMState state;
    private String id;

    private enum ATMState {
        IDLE,
        CARD_INSERTED,
        TRANSACTION_IN_PROGRESS,
        AMOUNT_INSERTED,
        DISPENSE_CASH,
    }

    public ATMClass(ATMState state , String id) {
        this.state = ATMState.IDLE;
        this.id = id;
    }

    public String generateUniqueId() {
        return "ATM-" + System.currentTimeMillis();
    }

  
    public int startTransaction() {
        if(state != ATMState.IDLE) {
            throw new IllegalArgumentException("ATM is not in idle state");
        }
        state = ATMState.TRANSACTION_IN_PROGRESS;
        id = generateUniqueId();
        return Integer.parseInt(id);
    }

    public void cancelTransaction(int transactionId) {
        if(state == ATMState.IDLE) {
            throw new IllegalArgumentException("ATM is not in idle state");
        }
        if(state == ATMState.DISPENSE_CASH) {
            throw new IllegalArgumentException("Transaction is in progress");
        }
        state = ATMState.IDLE;
        id = null;
    }


    
}
