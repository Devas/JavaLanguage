package language.comparable_vs_comparator;

import java.util.Comparator;
import java.util.TreeSet;

class Dog {

    int size;

    Dog(int s) {
        size = s;
    }
}

class DogSizeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.size - o2.size;
    }
}

public class DogComparatorDemo {

    public static void main(String[] args) {
        // If we use TreeSet implementation of Set, class must provide natural ordering (implement Comparable).
        // Another option is to pass Comparator in constructor if class doesn't provide natural ordering.
        // Otherwise we get ClassCastException - cannot be cast to java.lang.Comparable
        //TreeSet<Dog> d = new TreeSet<>(); // ClassCastException
        TreeSet<Dog> d = new TreeSet<>(new DogSizeComparator());
        d.add(new Dog(1));
        d.add(new Dog(2));
        d.add(new Dog(1));
    }
}