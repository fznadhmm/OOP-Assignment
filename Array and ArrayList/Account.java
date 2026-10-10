public class Account {
    private double balance;
    private static int transactionCount = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCount++;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            transactionCount++;
            return true;
        }
        return false;
    }

    public static int getTransactionCount() {
        return transactionCount;
    }
}