package minibank;

public class AccountNotFoundException extends BankException {
    public AccountNotFoundException(String accountNumber) {
        super("Account " + accountNumber + " was not found.");
    }
}
