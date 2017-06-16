package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Random_ {
    static Random generator = new Random();

    public static void main(String[] args) {
//        sedSeed(10);
        System.out.println(booleanList(10));
        System.out.println(Arrays.toString(byteArray(10)));
        System.out.println(intList(10));
        System.out.println(intList(10, 50));
        System.out.println(longList(10));
        System.out.println(floatList(10));
        System.out.println(floatList(10, 50.5f));
        System.out.println(doubleList(10));
        System.out.println(doubleList(10, 50.5));
        System.out.println(gaussianList(10));
    }

    /**
     * If seed is set the generator will generate the same numbers every time.
     * If two instances of Random are created with the same seed and the same sequence of method calls is made for each,
     * they will generate and return identical sequences of numbers.
     *
     * @param seed The seed of the random number generator
     */
    public static void sedSeed(long seed) {
        generator.setSeed(seed);
    }

    /**
     * @return List with any boolean values
     */
    public static LinkedList booleanList(int n) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextBoolean());
        }
        return l;
    }

    /**
     * @return Array with any byte values
     */
    public static byte[] byteArray(int n) {
        byte[] bytes = new byte[n];
        generator.nextBytes(bytes);
        return bytes;
    }

    /**
     * @return List with any int values
     */
    public static LinkedList intList(int n) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextInt());
        }
        return l;
    }

    /**
     * @return List with int values between 0 and bound exclusive i.e. [0, bound)
     */
    public static LinkedList intList(int n, int bound) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextInt(bound));
        }
        return l;
    }

    /**
     * @return List with any long values
     */
    public static LinkedList longList(int n) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextLong());
        }
        return l;
    }

    /**
     * @return List with float values between 0.0 and 1.0 exclusive i.e. [0.0, 1.0)
     */
    public static LinkedList floatList(int n) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextFloat());
        }
        return l;
    }

    /**
     * @return List with float values between 0.0 and bound exclusive i.e. [0.0, bound)
     */
    public static LinkedList floatList(int n, float bound) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextFloat() * bound);
        }
        return l;
    }

    /**
     * @return List with double values between 0.0 and 1.0 exclusive i.e. [0.0, 1.0)
     */
    public static LinkedList doubleList(int n) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextDouble());
        }
        return l;
    }

    /**
     * @return List with double values between 0.0 and bound exclusive i.e. [0.0, bound)
     */
    public static LinkedList doubleList(int n, double bound) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextDouble() * bound);
        }
        return l;
    }

    /**
     * @return List with gaussian values between 0.0 and bound exclusive i.e. [0.0, bound)
     */
    public static LinkedList gaussianList(int n) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < n; i++) {
            l.add(generator.nextGaussian());
        }
        return l;
    }
}
