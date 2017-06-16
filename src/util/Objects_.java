package util;

import java.util.Objects;

/**
 * Objects is used to safely invoke some methods e.g toString()hello w
 *
 * @since 1.7
 */
public class Objects_ {

    public static void main(String[] args) {
        System.out.println(safeCompareObjects(null, "abc"));
        safePrintObjects(null);
    }

    public static boolean safeCompareObjects(Object o1, Object o2) {
        return Objects.equals(o1, o2);
    }

    public static void safePrintObjects(String s) {
        System.out.println(Objects.toString(s));
    }
}
