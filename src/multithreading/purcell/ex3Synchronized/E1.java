package multithreading.purcell.ex3Synchronized;

/**
 * In this example the output is bad, count is not synchronized.
 */
@SuppressWarnings("Duplicates")
public class E1 {

    // We must ensure that count isn't get and updated by other thread when it's operated by the first thread
    private int count = 0;

    public static void main(String[] args) {
        E1 e = new E1();
        e.doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                count++; // this is not atomic
//                    count = count + 1; // there are really 3 operations: get count, add 1, store back in count
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                count++;
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
