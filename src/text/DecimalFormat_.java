package text;

import java.text.DecimalFormat;

/**
 * DecimalFormat is not thread-safe or synchronized properly. So never share DecimalFormat between multiple threads.
 * Its also not advisable to cache DecimalFormat as static resource without proper synchronization.
 */
public class DecimalFormat_ {

    public static void main(String args[]) {

        //formatting numbers up to 2 decimal places in Java
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        System.out.println(df.format(364565.14));
        System.out.println(df.format(364565.1454));
        System.out.println(df.format(0.2));

        //formatting numbers up to 3 decimal places in Java
        df = new DecimalFormat("#,###,##0.000");
        System.out.println(df.format(364565.14));
        System.out.println(df.format(364565.1454));
        System.out.println(df.format(0.2));
    }

}