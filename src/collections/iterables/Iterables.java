package collections.iterables;

import java.util.ArrayList;
import java.util.List;

public class Iterables {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("pierwszy");
        lista.add("drugi");

        MyCollection<String> myCollection = new MyCollection<String>(lista);
        for (String s : myCollection) {
            System.out.println(s);
        }
    }

}
