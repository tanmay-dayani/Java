package service;

import model.Account;
import model.Customer;
import static util.Validator.*;

public class MiniBank{
    public static void main(String[] args){
        Customer c1=new Customer("Tanmay","tanmay05@gmail.com","9909900018");
        Customer c2=new Customer("Kartavya","kartavya31@gmail.com","9909900031");
        Customer c3=new Customer("meet","meet13@gmail.com","9909900013");

        System.out.println(c1.getCustomerId()+" "+c1.getName());
        System.out.println(c2.getCustomerId()+" "+c2.getName());
        System.out.println(c3.getCustomerId()+" "+c3.getName());

        Account[] accounts=new Account[3];

        accounts[0]=new Account("Tanmay",400000);
        accounts[1]=new Account("Kartavya");
        accounts[2]=new Account("meet",950000);

        accounts[0].deposit(100000);
        accounts[1].deposit(250000);
        accounts[2].withdraw(150000);
        accounts[0].withdraw(1700000);

        System.out.println("\nAccount Details:");

        for(Account acc:accounts){
            System.out.println("Account No : "+acc.getAccountNumber());
            System.out.println("Owner      : "+acc.getOwnerName());
            System.out.println("Balance    : "+acc.getBalance());
            System.out.println("Valid      : "+isValid(acc));
            System.out.println("Interest   : "+acc.yearlyInterest());
            System.out.println();
        }

        WithdrawRule rule1=new WithdrawRule(){
            @Override
            public boolean allow(Account account,long amount){
                return amount>0&&amount<=account.getBalance();
            }
        };

        WithdrawRule rule2=(account,amount)->amount>0&&amount<=account.getBalance();

        System.out.println("Anonymous Rule: "+rule1.allow(accounts[0],50000));
        System.out.println("Lambda Rule: "+rule2.allow(accounts[0],50000));
    }
}
