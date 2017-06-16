package multithreading;

public class Timer extends Thread {

    public void run() {
        int time = 0;
        while (true) {
            try {
                this.sleep(1000);
            } catch (InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");
                return;
            }
            time++;
            int minutes = time / 60;
            int sec = time % 60;
            System.out.println(minutes + ":" + sec);
        }
    }
}