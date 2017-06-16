package multithreading.purcell.ex14InterruptedException;

import java.util.Random;
import java.util.concurrent.*;

@SuppressWarnings("Duplicates")
public class InterruptedExceptionDemo2 {

    private static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("Starting");

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                for (int i = 0; i < 5E7; i++) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });

        executorService.shutdown();

        // Wait some time
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1st way to stop
//        executorService.shutdownNow();

        // 2nd way to stop
//        future.cancel(false);
        future.cancel(true); // Attempts to stop thread

        // We can also use boolean voaltile isRunning to stop

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }

}
