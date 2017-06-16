package multithreading.purcell.ex11Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * To avoid deadlock we used lonck() and unlock() in the same order.
 * But now we can use tryLock() to manage locks so we can pass now locks in any order.
 */
public class RunnerReentrantTryLock {

    private Account account1 = new Account();
    private Account account2 = new Account();
    private Random random = new Random();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }
                if (gotFirstLock) {
                    firstLock.unlock();
                }
                if (gotSecondLock) {
                    secondLock.unlock();
                }
            }
            // Locks not acquired
            Thread.sleep(1);
        }
    }

    @SuppressWarnings("Duplicates")
    public void firstThread() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public void secondThread() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            acquireLocks(lock2, lock1); // Notice that locks are in different order now but it works
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
