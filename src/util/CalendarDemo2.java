package util;

import javax.swing.*;
import java.util.Calendar;

/**
 * set - ustala wartość pola; jeśli trzeba  dostosowując inne pola (np. ustawienie pola DAY_OF_MONTH na wartość 31
 * dla kalendarza ustawionego na dowolną datę w czerwcu spowoduje, że kalendarz będzie wskazywał na 1 lipca, gdyż
 * w czerwcu jest tylko 30 dni)
 *
 * add - dodaje do pola podaną wartość, stosując przy tym arytmetykę kalendarzową (np. dodanie do 30 maja 2 dni
 * spowoduje ustawienie kalendarza na  1 czerwca)
 *
 * roll - również wykonuje dodawanie, ale przy tym nie zmienia wartości "starszych" pól np. jeżeli dodajemy dni
 * i okaże się, że nowa data znajdzie się w innym niż teraz miesiącu, to miesiąc nie zostanie zmieniony,
 * zaś "nadwyżka" dni (poza końcem bieżącego miesiąca) będzie dodawana od początku miesiąca.
 */
public class CalendarDemo2 {

    public static void main(String[] args) {
        String in;
        int d = 0;
        while ((in = JOptionPane.showInputDialog("Type 2nd parameter for set / add / roll:")) != null) {
            d = Integer.parseInt(in);
            show("set", "DATE", Calendar.DATE, d);
            show("add", "DATE", Calendar.DATE, d);
            show("roll", "DATE", Calendar.DATE, d);
        }
        System.exit(0);
    }

    static void say(String s) {
        System.out.println(s);
    }

    static void show(String oper, String what, int field, int value) {
        Calendar c = Calendar.getInstance();
        say("Teraz jest: " + c.getTime()); // returns Date object
        say("Operacja: " + oper + "(Calendar." + what + ", " + value + ")");

        if (oper.equals("set"))
            c.set(field, value);
        else if (oper.equals("add"))
            c.add(field, value);
        else if (oper.equals("roll"))
            c.roll(field, value);

        say("Aktualne ustawienia kalendarza: "
                + c.get(Calendar.YEAR) + '-'
                + (c.get(Calendar.MONTH) + 1) + '-' +
                + c.get(Calendar.DATE));
        say("-----------------------------------------------------------");
    }
}