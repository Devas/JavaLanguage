package multithreading.purcell.ex9ProducerConsumerUsingWaitNotify;

import java.util.LinkedList;
import java.util.Random;

class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    //    private Deque<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object(); // We must lock on the same object
    private Random random = new Random();


    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) { // Wait until there is a free space in the list to place a new element
                    lock.wait();
                }
                list.add(value++);
                lock.notify(); // Notify that there is a new element to consume
            }
            Thread.sleep(random.nextInt(1000)); // Limit the speed of items adding to the list

        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.isEmpty()) { // Wait until there is at least one element to consume
                    lock.wait();
                }
                System.out.print("List size: " + list.size());
                int value = list.removeFirst();
                System.out.println("; Value is: " + value);
                lock.notify(); // Notify that an element was removed and there is a place for a new element to add
            }
            Thread.sleep(random.nextInt(1000)); // Limit the speed of items removing from the list
        }
    }

}

@SuppressWarnings("Duplicates")
public class ProducerConsumerUsingWaitNotify {

    public static void main(String[] args) {
        final Processor processor = new Processor();

        Thread thread1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
