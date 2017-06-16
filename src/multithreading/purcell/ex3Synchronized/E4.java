package multithreading.purcell.ex3Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * We can also use AtomicInteger as counter.
 */
public class E4 {

    // We must ensure that count isn't get and updated by other thread when it's operated by first thread
    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        E4 e = new E4();
        e.doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                count.incrementAndGet();
//                count.addAndGet(1); // we can also use this
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                count.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        try {
            // First - we need to wait for threads ex1StartingThreads and ex2VolatileShutdownThreadFromAnother to end their executions in order not to get count = 0
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }

}
