package multithreading.thread_group_class;

public class ThreadGroupDemo {

    public static void main(String[] args) {
//        basics();
//        priority1();
//        enumerate();
    }

    private static void basics() {
        ThreadGroup tg = new ThreadGroup("subgroup 1");
        Thread t1 = new Thread(tg, "thread 1");
        Thread t2 = new Thread(tg, "thread 2");
        Thread t3 = new Thread(tg, "thread 3");

        tg = new ThreadGroup("subgroup 2");
        Thread t4 = new Thread(tg, "my thread");

        tg = Thread.currentThread().getThreadGroup();
        System.out.println("Active thread groups in " + tg.getName() + " thread group: " + tg.activeGroupCount());
        tg.list();
    }

    private static void priority1() {
        ThreadGroup tg = new ThreadGroup("A");
        System.out.println("tg maximum priority = " + tg.getMaxPriority());

        Thread t1 = new Thread(tg, "X");
        System.out.println("t1 priority = " + t1.getPriority());

        t1.setPriority(Thread.NORM_PRIORITY + 1);
        System.out.println("t1 priority after setPriority() = " + t1.getPriority());

        tg.setMaxPriority(Thread.NORM_PRIORITY - 1);
        System.out.println("tg maximum priority after setMaxPriority() = " + tg.getMaxPriority());
        System.out.println("t1 priority after setMaxPriority() = " + t1.getPriority());

        Thread t2 = new Thread(tg, "Y");
        System.out.println("t2 priority = " + t2.getPriority());

        t2.setPriority(Thread.NORM_PRIORITY);
        System.out.println("t2 priority after setPriority() = " + t2.getPriority());
    }

    private static void enumerate() {
        ThreadGroup tg = new ThreadGroup("subgroup 1");
        Thread t1 = new Thread(tg, () -> System.out.println("Hello 1"), "thread 1");
        Thread t2 = new Thread(tg, () -> System.out.println("Hello 2"), "thread 2");
        Thread t3 = new Thread(tg, () -> System.out.println("Hello 3"), "thread 3");
        Thread[] threads = new Thread[3];
        t1.start();
        tg.enumerate(threads);
        for (int i = 0; i < 3; i++) System.out.println(threads[i]);
//        for (Thread thread : threads) {
//            thread.start(); // NullPointerException
//        }
    }

}
