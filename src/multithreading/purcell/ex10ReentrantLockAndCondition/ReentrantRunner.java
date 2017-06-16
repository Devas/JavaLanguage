package multithreading.purcell.ex10ReentrantLockAndCondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Instead of using 'synchronized void increment()' we use ReentrantLock
 * We must always place our code / method in try and place unlock() in finally because if a method throws an Exception
 * then there is no way to execute unlock()
 */
public class ReentrantRunner {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10_000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        lock.lock();
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }

}
