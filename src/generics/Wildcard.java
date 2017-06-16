package generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

    static void appendOne(List<Object> list) {
        list.add(new Object());
    }

    static void appendTwo(List<?> list) {
        //list.add(new Object()); // compilation error! -
    }

    static void appendThree(List list) {
        list.add(new Object());
    }

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        //appendOne(names1); // compilation error - incompatible types

        List<String> names2 = new ArrayList<String>();
        appendTwo(names2); // this part is fine! - we can pass any type to <?>

        List<String> names3 = new ArrayList<String>();
        appendTwo(names3); // this part is fine! - we can pass anything to raw type
    }
}
