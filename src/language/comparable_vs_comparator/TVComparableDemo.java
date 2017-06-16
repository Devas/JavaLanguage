package language.comparable_vs_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TVComparable implements Comparable<TVComparable> {

    private int size;
    private String brand;

    public TVComparable(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(TVComparable tv) {
        if (this.getSize() > tv.getSize())
            return 1;
        else if (this.getSize() < tv.getSize())
            return -1;
        else
            return 0;
    }
}

public class TVComparableDemo {

    public static void main(String[] args) {
        TVComparable tv1 = new TVComparable(55, "Samsung");
        TVComparable tv2 = new TVComparable(60, "Sony");

        if (tv1.compareTo(tv2) > 0) {
            System.out.println(tv1.getBrand() + " is better.");
        } else {
            System.out.println(tv2.getBrand() + " is better.");
        }

        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(1);
        al.add(2);
        System.out.println(al);

        Collections.sort(al);
        System.out.println(al);

        // We may use Collections.reverseOrder() method to get accessmodifiers.point.a descending order Comparator.
        // Class must implement Comparable interface to use Collections.reverseOrder()
        Comparator<Integer> comparator = Collections.reverseOrder();
        Collections.sort(al, comparator);
        System.out.println(al);
    }
}