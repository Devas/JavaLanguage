package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyMain {

    public static void main(String[] args) throws InterruptedException {

        //NotSafeProcessing pt = new NotSafeProcessing();
        AtomicProcessing pt = new AtomicProcessing();

        Thread t1 = new Thread(pt, "ex1StartingThreads");
        t1.start();
        Thread t2 = new Thread(pt, "ex2VolatileShutdownThreadFromAnother");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        System.out.println("Processing count = " + pt.getCount());
    }
}

class NotSafeProcessing implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class AtomicProcessing implements Runnable {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count.incrementAndGet();
        }
    }

    public int getCount() {
        return this.count.get();
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}