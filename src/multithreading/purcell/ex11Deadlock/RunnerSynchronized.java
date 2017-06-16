package multithreading.purcell.ex11Deadlock;

import java.util.Random;

public class RunnerSynchronized {

    private Account account1 = new Account();
    private Account account2 = new Account();
    Random random = new Random();

    public synchronized void firstThread() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }
    }

    public synchronized void secondThread() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            Account.transfer(account2, account1, random.nextInt(100));
        }
    }

    public void finished() {
        System.out.println("Account1 balance is: " + account1.getBalance());
        System.out.println("Account2 balance is: " + account2.getBalance());
        System.out.println("Total balance is: " + (account1.getBalance() + account2.getBalance()));
    }

}
