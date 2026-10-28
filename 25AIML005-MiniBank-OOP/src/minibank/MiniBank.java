package minibank;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MiniBank {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void add(Account account) { accounts.put(account.getAccountNumber(), account); }
    public Account find(String number) throws AccountNotFoundException {
        Account account = accounts.get(number);
        if (account == null) throw new AccountNotFoundException(number);
        return account;
    }

    public static void main(String[] args) throws Exception {
        MiniBank bank = new MiniBank();
        Customer customer = new Customer("Aarav Sharma", "aarav.sharma@example.com", "9876543210",
                new Customer.Address("12 Lake Road", "Pune", "411001"));
        SavingsAccount savings = new SavingsAccount(customer.getName(), 25_000, 2_000);
        CurrentAccount current = new CurrentAccount("Meera Iyer", 12_000, 5_000);
        FixedDepositAccount deposit = new FixedDepositAccount("Kabir Singh", 50_000);
        bank.add(savings); bank.add(current); bank.add(deposit);

        System.out.println("MINIBANK - DIGITAL BANKING DEMONSTRATION");
        System.out.println("Customer created: " + customer.getCustomerId() + " | " + customer.getAddress());
        System.out.println("Email valid: " + Validator.isValidEmail(customer.getEmail()));
        System.out.println("Mobile valid: " + Validator.isValidMobile(customer.getMobile()));
        System.out.println();

        Command command = CommandParser.parse("DEPOSIT " + savings.getAccountNumber() + " 5000");
        bank.find(command.accountNumber()).deposit(command.amount());
        savings.transferTo(current, 3_000);
        System.out.println("Parsed command: " + command);
        System.out.println("Transfer completed successfully.");
        System.out.println(StatementFormatter.buildStatement(savings));

        System.out.println("Interest preview:");
        for (Account account : List.of(savings, current, deposit)) {
            System.out.printf("%s -> %.2f%% | Yearly interest: Rs. %.2f%n", account.getAccountNumber(),
                    account.interestRate(), account.yearlyInterest(account.getBalance()));
        }

        WithdrawRule minimumBalanceRule = (account, amount) -> account.canWithdraw(amount);
        System.out.println("Withdrawal rule check for Rs. 1000: " + minimumBalanceRule.allow(savings, 1_000));
        try {
            deposit.withdraw(500);
        } catch (BankException exception) {
            System.out.println("Handled banking error: " + exception.getMessage());
        }

        try (TransactionProcessor processor = new TransactionProcessor()) {
            for (int i = 0; i < 10; i++) {
                processor.submit(() -> {
                    try { current.deposit(100); }
                    catch (InvalidAmountException exception) { throw new IllegalStateException(exception); }
                });
            }
        }
        System.out.println("Concurrent deposits completed safely.");
        System.out.println("Current account balance: Rs. " + current.getBalance());
        System.out.println("Validation messages: " + AnnotationValidator.validate(savings));
        System.out.println("Project execution completed.");
    }
}
