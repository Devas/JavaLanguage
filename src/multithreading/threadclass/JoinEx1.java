package multithreading.threadclass;

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("one");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("two");
    }

}

public class JoinEx1 {

    /**
     * The main thread waits till the "t" thread is finished one so the output is:
     *
     * one
     * two
     * one
     * two
     *
     * Without the t.join() the output would be:
     *
     * one
     * one
     * two
     * two
     *
     * join() throws InterruptedException
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new RunnableImpl());
        Thread t2 = new Thread(new RunnableImpl());

        t.start();
        t.join();
        t2.start();
    }

}