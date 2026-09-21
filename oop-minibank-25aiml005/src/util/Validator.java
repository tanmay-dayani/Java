package util;

import model.Account;

public class Validator{
    public static boolean isValid(Account account){
        return account!=null&&account.isActive();
    }

    public static boolean hasSufficientBalance(Account account,long amount){
        return account!=null&&amount>0&&amount<=account.getBalance();
    }
}
