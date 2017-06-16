package multithreading.purcell.ex2VolatileShutdownThreadFromAnother;

import java.util.Scanner;

class Runner extends Thread {

    // volatile must be used to avoid caching optimization (but this example works even without volatile)
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

}

public class VolatileShutdownThreadFromAnother {

    public static void main(String[] args) {
        Runner proc1 = new Runner();
        proc1.start();

        System.out.println("Press to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }

}
