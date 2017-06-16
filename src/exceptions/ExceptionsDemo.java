package exceptions;

public class ExceptionsDemo {

    public static void main(String[] args) {
        Integer liczba = null;

        try {
            liczba = Integer.valueOf("1");
        } catch (NumberFormatException nfe) {
            System.out.println("Wyjątek - zły format liczby");
        } catch (Exception e) {
            System.out.println("Wyjątek, ale jakiś inny");
        } finally {
            System.out.println("To się zawsze wykonuje 1");
        }

        try {
            liczba = Integer.valueOf("1");
        } finally {
            System.out.println("To się zawsze wykonuje 2");
        }

        try {
            liczba = Integer.valueOf("1");
        } catch (NumberFormatException nfe) {
            System.out.println("Wyjątek - zły format liczby");
        }

        try {
            liczba = Integer.valueOf("1");
        } catch (NumberFormatException nfe) {
            System.out.println("Wyjątek - zły format liczby");
        } catch (Exception e) {
            System.out.println("Wyjątek, ale jakiś inny");
        }

        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            int num = Integer.parseInt("1aaa");
        } catch (NumberFormatException e) {
            System.out.println("Co podaje getMessage()");
            System.out.println(e.getMessage());
            System.out.println("Co podaje toString()");
            System.out.println(e);
            System.out.println("Wydruk śladu stosu (kolejność wywołań metod)");
            e.printStackTrace();
            System.exit(1);
        }
    }
}

