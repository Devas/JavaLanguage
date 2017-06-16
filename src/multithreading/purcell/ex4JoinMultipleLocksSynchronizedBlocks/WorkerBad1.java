package multithreading.purcell.ex4JoinMultipleLocksSynchronizedBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * We want two threads adding concurrently numbers:
 * -total execution of program should be 2 seconds total
 * -each list has to have 2000 numbers
 * <p>
 * This won't work
 * stageOne() and stageTwo() aren't synchronized so it takes 2 seconds so it's OK
 * But both threads can add to the same list in the same time so the sizes of the lists are less than 2000 - BAD
 */
@SuppressWarnings("Duplicates")
public class WorkerBad1 {

    private Random random = new Random();

    // Every object has only 1 intrinsic lock so we have to have more objects to lock
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }

    private void stageTwo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }

    // Each stage takes 1 second ro execute so it's 2 seconds total
    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting " + getClass().getSimpleName());
        long start = System.currentTimeMillis();

//        process(); // Takes 2 secs as expected

        Thread t1 = new Thread(this::process);
        Thread t2 = new Thread(this::process);

        t1.start();
        t2.start();

        // We must wait for t1 and t2 to finish in order to see proper time and sizes of lists
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1 size: " + list1.size());
        System.out.println("List2 size: " + list2.size());
    }

}
