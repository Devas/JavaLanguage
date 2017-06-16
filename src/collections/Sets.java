package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<String> zbior;
        zbior = new HashSet<String>(); // backed by HashMap
        zbior = new TreeSet<String>(); // backed by TreeMap (red-black trees)
        zbior.add("pierwszy");
        zbior.add("drugi");
        for (String ciagZnakow : zbior) {
            System.out.println(ciagZnakow);
        }
    }
}
