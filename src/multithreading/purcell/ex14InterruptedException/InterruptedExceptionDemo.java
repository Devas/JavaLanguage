package multithreading.purcell.ex14InterruptedException;

import java.util.Random;

@SuppressWarnings("Duplicates")
public class InterruptedExceptionDemo {

    private static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("Starting");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1E8; i++) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        System.out.println("We have been imterrupted");
//                        break;
//                    }
                    Math.sin(random.nextDouble());
                }
            }
        });

        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sets a flag in the thread
        t.interrupt();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }

}
