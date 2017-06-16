package math;

import java.math.BigDecimal;

/**
 * Using BigDecimal to represent money.
 */
@SuppressWarnings("ALL")
public class BigDecimalDemo {

    public static void main(String[] args) {
        bad();
        good();
        ilusionalGoodButReallyBad();
        threeConstants();
    }

    private static void bad() {
        BigDecimal accountBalance = new BigDecimal(0.0);

        BigDecimal point = new BigDecimal(0.01);
        System.out.println("BigDecimal doesn't work with double passed: " + point);

        for (int i = 0; i < 100; i++) {
            accountBalance = accountBalance.add(point); // add() returns new object
        }

        System.out.println("BigDecimal doesn't work with double passed: " + accountBalance + "\n");
    }

    private static void good() {
        BigDecimal accountBalance = new BigDecimal("0.0");

        BigDecimal point = new BigDecimal("0.01");
        System.out.println("BigDecimal works when String is passed: " + point);

        for (int i = 0; i < 100; i++) {
            accountBalance = accountBalance.add(point);
        }

        System.out.println("BigDecimal works when String is passed: " + accountBalance + "\n");
    }

    /**
     * Works only in this case  because generated String has 24 points precision and rest is truncated.
     * In this case truncated String gives good value but it is not true for other cases.
     */
    private static void ilusionalGoodButReallyBad() {
        BigDecimal accountBalance = BigDecimal.valueOf(0.0);

        BigDecimal point = BigDecimal.valueOf(0.01);
        System.out.println("BigDecimal.valueOf() works only in this case: " + point);

        for (int i = 0; i < 100; i++) {
            accountBalance = accountBalance.add(point);
        }

        System.out.println("BigDecimal.valueOf() works only in this case: " + accountBalance + "\n");
    }

    private static void threeConstants() {
        System.out.println("Some constants: " + BigDecimal.ZERO + " " + BigDecimal.ONE + " " + BigDecimal.TEN + "\n");
    }

}
