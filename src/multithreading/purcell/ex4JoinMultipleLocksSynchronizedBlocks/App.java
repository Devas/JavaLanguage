package multithreading.purcell.ex4JoinMultipleLocksSynchronizedBlocks;

public class App {

    public static void main(String[] args) {
        new WorkerBad1().main();
        System.out.println();
        new WorkerBad2().main();
        System.out.println();
        new WorkerGood().main();
    }

}
