package multithreading.thread_local_class;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadID {

    // Next thread ID to be assigned
    private static final AtomicInteger nextID = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextID.getAndIncrement();
        }
    };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }
}