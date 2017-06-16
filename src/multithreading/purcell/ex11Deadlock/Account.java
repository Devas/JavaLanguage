package multithreading.purcell.ex11Deadlock;

public class Account {

    private int balance = 10_000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account withdrawAccount, Account depositAccount, int amount) {
        withdrawAccount.withdraw(amount);
        depositAccount.deposit(amount);
    }

}
