package generics;

import generics.docsoracle.Box;
import generics.docsoracle.OrderedPair;

public class BasicsAutoboxing {

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<Integer>(); // Integer is here type argument
        // From Java 7 the Java compiler can infer the type of the collection instantiated from the variable
        // the collection is assigned to.
        Box<Integer> b2 = new Box<>(); // diamond notation can be used
        b1.set(new Integer(6)); // unnecessary boxing (i.e. wrapping primitive in object) can be replaced with ...
        b1.set(6);              // ... autoboxing since Java 5

        OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8); // autoboxing, 8 casted to Integer
        OrderedPair<String, String>  p2 = new OrderedPair<>("hello", "world");
        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());

    }
}