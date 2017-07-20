package multithreading.thread_local_class;

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            ThreadID threadID = new ThreadID();
            System.out.println(ThreadID.get());
        });

        Thread t2 = new Thread(() -> {
            ThreadID threadID = new ThreadID();
            System.out.println(ThreadID.get());
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(ThreadID.get());
        System.out.println(ThreadID.get());

    }

}
