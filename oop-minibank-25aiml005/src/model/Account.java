package model;

public class Account implements Transactionable,InterestBearing,Premium{
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;
    private static int counter=1;

    private static String generateAccountNumber(){
        return String.format("AC%04d",counter++);
    }

    public Account(String ownerName,long balance){
        this.accountNumber=generateAccountNumber();
        this.ownerName=ownerName;
        this.balance=balance;
        this.active=true;
    }

    public Account(String ownerName){
        this(ownerName,0);
    }

    @Override
    public void deposit(long amount){
        if(amount>0)
            balance+=amount;
    }

    @Override
    public boolean withdraw(long amount){
        if(amount>0&&amount<=balance){
            balance-=amount;
            return true;
        }
        return false;
    }

    @Override
    public double interestRate(){
        return 0.05;
    }

    @Override
    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public boolean isActive(){
        return active;
    }
}
