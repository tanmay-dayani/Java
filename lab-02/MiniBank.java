class Customer {
   private String name;
   private String email;
   private String mobile;
   private final String customerId;
 
   private static long customerCounter = 100;
 
   private static String generateCustomerId() {
       customerCounter++;
       return "CUST" + customerCounter;
   }
 
   public Customer(String name, String email, String mobile) {
       this.name = name;
       this.email = email;
       this.mobile = mobile;
       this.customerId = generateCustomerId();
   }
 
   public String getName() {
       return name;
   }
 
   public String getEmail() {
       return email;
   }
 
   public String getMobile() {
       return mobile;
   }
 
   public String getCustomerId() {
       return customerId;
   }
}
 
class Account {
   private final String accountNumber;
   private String ownerName;
   private long balance;
   private boolean active;
 
   private static long accountCounter = 0;
 
   private static String generateAccountNumber() {
       accountCounter++;
       return String.format("AC%04d", accountCounter);
   }
 
   public Account(String ownerName, long openingBalance) {
       this.accountNumber = generateAccountNumber();
       this.ownerName = ownerName;
       this.balance = openingBalance;
       this.active = true;
   }
 
   public Account(String ownerName) {
       this(ownerName, 0);
   }
 
   public void deposit(long amount) {
       balance += amount;
   }
 
   public boolean withdraw(long amount) {
       if (amount <= balance) {
           balance -= amount;
           return true;
       }
       return false;
   }
 
   public String getAccountNumber() {
       return accountNumber;
   }
 
   public String getOwnerName() {
       return ownerName;
   }
 
   public long getBalance() {
       return balance;
   }
 
   public boolean isActive() {
       return active;
   }
}
 
public class MiniBank {
   public static void main(String[] args) {
       Account[] accounts = new Account[3];
 
       accounts[0] = new Account("Tanmay", 5000);
       accounts[1] = new Account("Aarav");
       accounts[2] = new Account("Mehta", 2000);
 
       accounts[0].deposit(1500);
       accounts[0].withdraw(3000);
 
       accounts[1].deposit(1000);
       boolean result1 = accounts[1].withdraw(5000);
 
       accounts[2].withdraw(500);
       accounts[2].deposit(300);
 
       for (Account acc : accounts) {
           System.out.println(acc.getAccountNumber() + " | "
                   + acc.getOwnerName() + " | Balance: "
                   + acc.getBalance());
       }
 
       System.out.println("Arjun's overdraw attempt succeeded? " + result1);
   }
}