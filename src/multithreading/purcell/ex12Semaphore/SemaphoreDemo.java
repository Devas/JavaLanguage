package multithreading.purcell.ex12Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore with permit == 1 can be used as lock
 * With Semaphore we can releas from differnet thread, but we had to release Lock in the same thread
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        semaphore.release(); // permits++
        try {
            semaphore.acquire(); // permits--, if permits == 0 then it will wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Number of available permits: " + semaphore.availablePermits());
    }

}
