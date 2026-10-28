package minibank;

import java.util.Objects;

public abstract class Account implements Transactable, InterestBearing {
    private static long accountCounter = 1000;
    @Id private final String accountNumber;
    @MaxLength(40) private final String ownerName;
    @Positive private long balance;
    private boolean active = true;

    protected Account(String ownerName, long openingBalance) {
        this.accountNumber = "AC" + (++accountCounter);
        this.ownerName = ownerName;
        this.balance = openingBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public synchronized long getBalance() { return balance; }
    public boolean isActive() { return active; }

    @Override
    public synchronized void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be positive.");
        balance += amount;
    }

    @Override
    public synchronized void withdraw(long amount) throws BankException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be positive.");
        if (!canWithdraw(amount)) throw new InsufficientFundsException(Math.max(0, amount - balance));
        balance -= amount;
    }

    public abstract boolean canWithdraw(long amount);

    public void transferTo(Account destination, long amount) throws BankException {
        Account first = accountNumber.compareTo(destination.accountNumber) < 0 ? this : destination;
        Account second = first == this ? destination : this;
        synchronized (first) {
            synchronized (second) {
                withdraw(amount);
                destination.deposit(amount);
            }
        }
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Account other && accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(accountNumber); }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | Balance: Rs. " + getBalance()
                + " | " + (active ? "Active" : "Inactive");
    }
}
