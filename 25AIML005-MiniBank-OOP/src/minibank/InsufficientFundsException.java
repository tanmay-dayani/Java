package minibank;

public class InsufficientFundsException extends BankException {
    public InsufficientFundsException(long shortfall) {
        super(shortfall > 0 ? "Insufficient funds. Shortfall: Rs. " + shortfall
                : "Withdrawal is not permitted for this account.");
    }
}
