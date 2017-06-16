package util;

import javax.swing.*;
import java.util.Calendar;

/**
 * http://edu.pjwstk.edu.pl/wyklady/ppj/scb/
 */
public class FormatterDemo {

    public static void main(String[] args) {
        System.out.println("Wyrównany wydruk tablicy (po 2 elementy w wierszu)");
        int[] arr = {1, 100, 200, 4000};
        int k = 1;
        for (int i : arr) {
            System.out.printf("%5d", i);
            if (k % 2 == 0) System.out.println();
            k++;
        }

        // Zastosowanie znaku < (elment formatu stosowany wobec argumentu z poprzedniego formatowania)
        System.out.println("Zaokraglenia");
        System.out.printf("%.3f %<.2f %<.1f", 1.256);

        // Znak < szczególnie przydatny w datach/czasie
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 1);
        System.out.printf("\nW roku %tY i miesiącu %<tm mamy %d dni", c, c.getActualMaximum(Calendar.DATE));

        // Oczywiście możemy formatować do Stringów
        String dateNow = String.format("%td-%<tm-%<tY", System.currentTimeMillis());
        JOptionPane.showMessageDialog(null, dateNow);
    }
}