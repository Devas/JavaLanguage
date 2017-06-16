package multithreading.purcell.ex8WaitNotify;

import java.util.Scanner;

class Processor {

    public void produce() {
        synchronized (this) {
            System.out.println("Producer thread running");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Resumed");
        }
    }

    public void consume() {
        Scanner scanner = new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println("Waiting for return key");
            scanner.nextLine();
            System.out.println("Return key pressed");
            notify();
        }
    }

}

@SuppressWarnings("Duplicates")
public class WaitNotifyDemo {

    public static void main(String[] args) {
        final Processor processor = new Processor();

        Thread thread1 = new Thread(processor::produce);
        Thread thread2 = new Thread(processor::consume);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
