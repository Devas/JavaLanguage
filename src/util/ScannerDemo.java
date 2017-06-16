package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.delimiter());
        System.out.println(sc.radix());
        System.out.println(sc);

        // hasNext[Type](); next[Type]() methods are available
        if (sc.hasNextBoolean()) { // executes if contains "true|false"
            boolean b = sc.nextBoolean();
        }
        if (sc.hasNextInt()) {
            int i = sc.nextInt();
        }
        if (sc.hasNextBigDecimal()) {
            BigDecimal bd = sc.nextBigDecimal();
        }

        // We have also methods to check and read one token or one line
        if (sc.hasNext()) {
            System.out.println(sc.next());
        }
        if (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        // We can also pass as argument String regex or Pattern
        if (sc.hasNext("A\\+*")) {
            System.out.println(sc.next("A\\+*"));
        }
        if (sc.hasNext(Pattern.compile("A\\+*"))) {
            System.out.println(sc.next("A\\+*"));
        }

        // Scanner's constructor can also take String
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*"); // "1 2 red blue"
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.reset(); // Reset delimiter to default
        s.close();

        // We can also pass File object to Scanner
        Scanner fsc = new Scanner(new File("myNumbers"));
        while (fsc.hasNextLong()) {
            long aLong = sc.nextLong();
        }

    }
}
