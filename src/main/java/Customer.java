// Program.Customer object that represents individual customers and their data
public class Customer {
    private int customerId;
    private int withdrawalLimit;
    private int balance;
    private String name;

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    // deposit given amount
    public void deposit(int amount) {
        balance += amount;
    }

    // withdraw given amount
    public void withdraw(int amount) {
        balance -= amount;
    }

    // checks if given amount exceeds the customer's withdrawal limit
    public boolean exceedsWithdrawalLimit(int amount) {
        return amount > withdrawalLimit;
    }

    // checks if given amount exceed the customer's account balance
    public boolean exceedsAccountBalance(int amount) {
        return amount > balance;
    }

    // constructor
    public Customer(int customerId, int withdrawalLimit, int balance, String name) {
        this.customerId = customerId;
        this.withdrawalLimit = withdrawalLimit;
        this.balance = balance;
        this.name = name;
    }
}
