package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        Lock l = new ReentrantLock();
        l.lock();
        try {
            // access the resource protected by this lock
        } finally {
            l.unlock();
        }

        Lock lock = new ReentrantLock();
        if (lock.tryLock()) {
            try {
                // manipulate protected state
            } finally {
                lock.unlock();
            }
        } else {
            // perform alternative actions
        }
    }
}
