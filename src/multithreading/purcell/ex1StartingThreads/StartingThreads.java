package multithreading.purcell.ex1StartingThreads;

class RunnerThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello thread " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class RunnerRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello runnable " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class StartingThreads {

    public static void main(String[] args) {
        demo1();

        // 1st
        RunnerThread runner1 = new RunnerThread();
        runner1.start();

        // 2nd
        RunnerRunnable runner2 = new RunnerRunnable();
        new Thread(runner2).start(); // If we implement Runnable we pass it to the Thread constructor

        // 3rd
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello local " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void demo1() {
        Object[] o = new Object[]{new RunnerThread(), new RunnerThread()};
        for (int i = 0; i < o.length; i++) {
            System.out.println(o[i]);
            ((Thread) o[i]).start();
        }
    }

}
