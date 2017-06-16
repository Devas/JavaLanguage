package multithreading.purcell.ex2VolatileShutdownThreadFromAnother;

public class VolatileShutdownThreadFromAnotherWorking {

    // volatile must be used to avoid caching optimization (this example clearly shows the difference)
    private static volatile boolean running = false;

    public static void main(String[] args) throws Exception {

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Wait for running to become true
                while (!running) {}

                // running is true now
                System.out.println("Started");

                // Wait for running to become false
                while (running) {}

                // running is false now
                System.out.println("Stopped");
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("Starting");
        running = true;

        Thread.sleep(1000);
        System.out.println("Stopping");
        running = false;
    }

}
