package multithreading.purcell.ex4JoinMultipleLocksSynchronizedBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * We want two threads adding concurrently numbers:
 * -total execution of program should be 2 seconds total
 * -each list has to have 2000 numbers
 * <p>
 * We want accessmodifiers.point.a system whereby two threads can't run stageOne() method at the same time and also can't run stageTwo()
 * method at the same time.
 * But we want that one thread can run stageOne() method while another thread is running stageTwo() method, so we must
 * lock on different objects.
 * <p>
 * Now works
 * stageOne() and stageTwo() are now synchronized on different objects and it takes 2 seconds now - OK
 * Both threads can't add to the same list in the same time so the sizes of the lists are exactly 2000 - OK
 */
@SuppressWarnings("Duplicates")
public class WorkerGood {

    private Random random = new Random();

    // Every object has only 1 intrinsic lock so we have to have more objects to lock
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    // We can do this because both methods write to different list

    private void stageOne() {
        synchronized (lock1) {
            try { // this try block doesn't have to be in synchronized block
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            try { // this try block doesn't have to be in synchronized block
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
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