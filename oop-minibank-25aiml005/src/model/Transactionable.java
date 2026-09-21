package model;

public interface Transactionable{
    void deposit(long amount);
    boolean withdraw(long amount);
}
