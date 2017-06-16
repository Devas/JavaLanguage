package multithreading.threadlocal;



public class Demo1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadId threadId = new ThreadId();
                System.out.println(ThreadId.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadId threadId = new ThreadId();
                System.out.println(ThreadId.get());
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(ThreadId.get());
        System.out.println(ThreadId.get());

    }

}
