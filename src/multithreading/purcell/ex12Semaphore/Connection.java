package multithreading.purcell.ex12Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Limit the number of connections in the same time to 10 using Semaphore.
 * There will be still 200 x connect() but it will take longer because we can only have 10 connections at once.
 */
public class Connection {

    private static Connection instance = new Connection();
    private int connections = 0;
//    private Semaphore semaphore = new Semaphore(10);

    // If fair == true then the thread that called acquire() first will be the first to get a permit after release()
    private Semaphore semaphore = new Semaphore(10, true);

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        } finally {
            semaphore.release(); // We should run release() in finally because of operations throwing exception
        }
    }

    private void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        // Some operations - these can throw exceptions so we cannot realese at the end of this method bu we do it in finally
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }

}
