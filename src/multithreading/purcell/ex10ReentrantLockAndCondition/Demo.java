package multithreading.purcell.ex10ReentrantLockAndCondition;

public class Demo {

    public static void main(String[] args) {
//        final ReentrantRunner runner = new ReentrantRunner();
        final ReentrantConditionRunner runner = new ReentrantConditionRunner();

        Thread thread1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runner.finished();
    }

}
