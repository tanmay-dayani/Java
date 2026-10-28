package minibank;

public final class StatementFormatter {
    private StatementFormatter() { }
    public static String buildStatement(Account account) {
        return new StringBuilder()
                .append("MINIBANK ACCOUNT STATEMENT\n")
                .append("Account Number: ").append(account.getAccountNumber()).append('\n')
                .append("Account Holder: ").append(account.getOwnerName()).append('\n')
                .append("Available Balance: Rs. ").append(account.getBalance()).append('\n')
                .append("Status: ").append(account.isActive() ? "Active" : "Inactive")
                .toString();
    }
}
