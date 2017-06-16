package multithreading.purcell.ex11Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * To avoid deadlock we must lonck() and unlock() in the same order
 */
public class RunnerReentrant {

    private Account account1 = new Account();
    private Account account2 = new Account();
    private Random random = new Random();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    @SuppressWarnings("Duplicates")
    public void firstThread() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            lock1.lock();
            lock2.lock();
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }        }
    }

    @SuppressWarnings("Duplicates")
    public void secondThread() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            lock1.lock(); // If we swap these 2 lines we get deadlock
            lock2.lock(); // If we swap these 2 lines we get deadlock
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account1 balance is: " + account1.getBalance());
        System.out.println("Account2 balance is: " + account2.getBalance());
        System.out.println("Total balance is: " + (account1.getBalance() + account2.getBalance()));
    }

}
