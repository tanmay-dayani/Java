package minibank;

public class SavingsAccount extends Account implements Premium {
    private final long minimumBalance;

    public SavingsAccount(String ownerName, long openingBalance, long minimumBalance) {
        super(ownerName, openingBalance);
        this.minimumBalance = minimumBalance;
    }

    @Override public double interestRate() { return 4.0; }
    @Override public boolean canWithdraw(long amount) { return getBalance() - amount >= minimumBalance; }
}
