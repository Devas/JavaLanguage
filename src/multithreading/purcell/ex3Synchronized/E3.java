package multithreading.purcell.ex3Synchronized;

/**
 * Now we extracted accessmodifiers.point.a method and added synchronized - output is OK.
 */
public class E3 {

    // We must ensure that count isn't get and updated by other thread when it's operated by first thread
    private int count = 0;

    // Synchronized means only one thread can access the referenced method at accessmodifiers.point.a time.
    // This is achieved by java while keeping internal mutex and locks.
    // Synchronized guarantees that all variables inside this method will be volatile i.e. accessible for all threads
    // so count doesn't have to be declared with volatile.
    private synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        E3 e = new E3();
        e.doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            // First - we need to wait for threads t1 and t2 to end their executions in order not to get count = 0
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }

}
