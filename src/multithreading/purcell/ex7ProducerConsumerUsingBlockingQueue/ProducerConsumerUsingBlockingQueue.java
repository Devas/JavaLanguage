package multithreading.purcell.ex7ProducerConsumerUsingBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(ProducerConsumerUsingBlockingQueue::producer);
        Thread thread2 = new Thread(ProducerConsumerUsingBlockingQueue::consumer);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void producer() {
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(100); // Loop executes 10 times per second
                if (random.nextInt(10) == 0) { // But this if is executed on average 1 time per second
                    Integer value = queue.take();
                    System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
