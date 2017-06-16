package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm accessmodifiers.point.a, z");
        System.out.println(sdf.toPattern());
        System.out.println(sdf.toLocalizedPattern());

        Date date = null;
        try {
            date = sdf.parse("02/09/2016 4:5 PM, PDT");
        } catch (ParseException pe) {
            System.out.println("Wrong format!");
        }

        System.out.println(date);
    }
}
