package util;

import java.util.Calendar;

import static java.util.Calendar.*;

public class CalendarDemo1 {

    public static void say(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        // uzyskanie kalendarza domyślnego (obowiązującgo dla domyślnej lokalizacji - tu dla Polski)
        // ustawionego na bieżącą datę i czas
        Calendar cal = Calendar.getInstance();

        say("ERA.............. " + cal.get(ERA) + " (0=BC, 1=AD)");

        say("ROK.............. " + cal.get(YEAR));
        say("MIESIĄC.......... " + cal.get(MONTH) + " (0-styczeń, 2-luty, ..., 11-grudzień)");

        say("LICZBA DNI");
        say("W MIESIĄCU....... " + cal.getActualMaximum(DAY_OF_MONTH));

        say("DZIEŃ MIESIĄCA... " + cal.get(DAY_OF_MONTH));
        say("DZIEŃ MIESIĄCA... " + cal.get(DATE));
        say("TYDZIEŃ ROKU..... " + cal.get(WEEK_OF_YEAR));
        say("TYDZIEŃ MIESIĄCA. " + cal.get(WEEK_OF_MONTH));
        say("DZIEŃ W ROKU..... " + cal.get(DAY_OF_YEAR));

        say("PIERWSZY DZIEŃ");
        say("TYGODNIA......... " + cal.getFirstDayOfWeek() + " (1-niedziela, 2-poniedziałek, ..., 7 sobota)");

        say("DZIEŃ TYGODNIA... " + cal.get(DAY_OF_WEEK) + " (1-niedziela, 2-poniedziałek, ..., 7-sobota)");

        say("GODZINA.......... " + cal.get(HOUR) + " (12 godzinna skala; następne odwolanie czy AM czy PM)");

        say("AM/PM............ " + cal.get(AM_PM) + " (AM=0, PM=1)");

        say("GODZINA.......... " + cal.get(HOUR_OF_DAY) + " (24 godzinna skala)");

        say("MINUTA........... " + cal.get(MINUTE));
        say("SEKUNDA.......... " + cal.get(SECOND));
        say("MILISEKUNDA...... " + cal.get(MILLISECOND));

        int msh = 3600 * 1000; // liczba milisekund w godzinie

        say("RÓŻNICA CZASU");
        say("WOBEC GMT........ " + cal.get(ZONE_OFFSET) / msh);

        say("PRZESUNIĘCIE");
        say("CZASU............ " + cal.get(DST_OFFSET) / msh + " (w Polsce obowiązuje w lecie)");

    }
}