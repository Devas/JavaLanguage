package multithreading.purcell.ex13CallableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Callable can return T and throws Exception.
 * submit() returns Future (which represents the result of an asynchronous computation) so we can get a result from call()
 */
@SuppressWarnings("Duplicates")
public class CallableAndFutureDemo {

    private static Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int duration = random.nextInt(4000);
                if(duration > 2000) {
                    throw new IOException("Sleeping for too long");
                }
                System.out.println("Starting");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                return duration;
            }
        });

        // We can use Void if we only want rhrow exception and don't want to return value
        Future<?> futureNull = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                int duration = random.nextInt(4000);
                if(duration > 2000) {
                    throw new IOException("Sleeping for too long");
                }
                System.out.println("Starting");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                return null; // We must then return null
            }
        });

        executorService.shutdown();

        // We don't need here executorService.await() because
        // future.get() waits if necessary for the computation to complete, and then retrieves its result.
        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // if exception is thrown in call() then get() throws ExecutionException which can be inspected using the getCause()
        catch (ExecutionException e) {
            System.out.println(e);
            System.out.println("Message: " + e.getMessage());
            IOException ex = (IOException) e.getCause();
            System.out.println("Original message: " + ex.getMessage());
        }


    }

}
