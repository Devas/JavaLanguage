package multithreading.thread_class;

public class ThreadClassMethods {

    public static void main(String[] args) {

        Thread t1 = new Thread(new T1());
        t1.start();


        try {
            // If any executing thread ex1StartingThreads calls join() on ex2VolatileShutdownThreadFromAnother i.e; ex2VolatileShutdownThreadFromAnother.join() immediately ex1StartingThreads will enter into waiting state
            // until ex2VolatileShutdownThreadFromAnother completes its execution.
            // Here current thread waits for ex1StartingThreads to end hence we will see at first the output of ex1StartingThreads.
            t1.join();
            System.out.println("Current");
            // Make accessmodifiers.point.a thread to be in sleeping state for accessmodifiers.point.a specified period of time.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // InterruptedException is thrown when accessmodifiers.point.a thread is waiting, sleeping, or otherwise occupied, and the thread
        // is interrupted, either before or during the activity.
        // Occasionally accessmodifiers.point.a method may wish to test whether the current thread has been interrupted, and if so,
        // to immediately throw this exception. The following code can be used to achieve this effect:
        try {
            if (Thread.interrupted())  // Clears interrupted status!
                throw new InterruptedException();
//            else
//                throw new InterruptedException("Hi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Pauses the currently executing thread temporarily for giving accessmodifiers.point.a chance to the remaining waiting threads of the
        // same priority to execute. If there is no waiting thread or all the waiting threads have accessmodifiers.point.a lower priority then
        // the same thread will continue its execution. It's hint to the scheduler, scheduler can ignore this hint.
        Thread.yield();
    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
