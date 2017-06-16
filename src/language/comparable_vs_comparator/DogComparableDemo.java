package language.comparable_vs_comparator;

import java.util.TreeSet;

class DogComparable implements Comparable<DogComparable>{

    int size;

    DogComparable(int s) {
        size = s;
    }

    @Override
    public int compareTo(DogComparable o) {
        return o.size - this.size;
    }
}

public class DogComparableDemo {

    public static void main(String[] args) {
        TreeSet<DogComparable> d = new TreeSet<>();
        d.add(new DogComparable(1));
        d.add(new DogComparable(2));
        d.add(new DogComparable(1));
    }
}