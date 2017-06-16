package multithreading.jenkov.ex27CompareAndSwap;

import java.util.concurrent.atomic.AtomicBoolean;

public class Demo {
}

class CustomLock {

    private boolean locked = false;

    public synchronized boolean lock() {
        if (!locked) {
            locked = true;
            return true;
        }
        return false;
    }
}

class NiceCustomLock {
    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean lock() {
        return locked.compareAndSet(false, true);
    }

}