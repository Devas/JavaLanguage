package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherDemo {

    public static void main(String[] args) {
        boolean b;

        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        b = m.matches();

        // Pattern class has matches() method as convenience when accessmodifiers.point.a regular expression is used just once.
        // For repeated matches it is less efficient since it does not allow the compiled pattern to be reused.
        b = Pattern.matches("a*b", "aaaaab");

        // String class has also matches() method, it runs Pattern.matches(regex, this) under hood
        String s = "aaaaab";
        b = s.matches("a*b");

        System.out.println(b);
    }
}
