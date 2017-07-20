package multithreading.thread_class;

/**
 * We cannot rely on it, it's only a hint to scheduler.
 */
public class ThreadPriorityDemo {

    public static void main(String[] args) {
        Thread m1 = new Thread(() -> System.out.println("running: " + Thread.currentThread().getName() + ", priority: " + Thread.currentThread().getPriority()), "m1");
        Thread m2 = new Thread(() -> System.out.println("running: " + Thread.currentThread().getName() + ", priority: " + Thread.currentThread().getPriority()), "m2");
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();
    }

}
