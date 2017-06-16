package multithreading.uncaughtexceptionhandler;

public class UncaughtExceptionHandlerDemo {

    /**
     * Catch an exception in one thread (here main thread) thrown by another thread
     */
    public static void main(String[] args) {
        // create our uncaught exception handler
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.println("Uncaught exception: " + ex);
            }
        };

        // create another thread
        Thread otherThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Sleeping ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.");
                }
                System.out.println("Throwing exception ...");
                throw new RuntimeException();
            }
        };

        // set our uncaught exception handler as the one to be used when the new thread throws an uncaught exception
        otherThread.setUncaughtExceptionHandler(handler);

        // our uncaught exception handler will be invoked when the otherThread throws an uncaught exception
        otherThread.start();
    }
}
