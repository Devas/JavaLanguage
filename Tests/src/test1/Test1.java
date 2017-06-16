package test1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        City a = new City("NY");
        City b = new City("NY");
        // http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals%28java.lang.Object%29
        // The default implementation of equals() and hashCode() methods simply checks for instance equality
        // (in other words, two Objects will only be equal if they are in fact the same object i.e. == returns true).
        System.out.println(a == b); // should be false - distinct objects
        System.out.println(a.equals(b)); // should be false - distinct objects - checks address using ==
        System.out.println(a.hashCode() + " " + b.hashCode()); // should be different ints - distinct objects - checks address using ==

        // Even if we create different objects with new, the String field will still be placed in String-Pool
        System.out.println("\nString field of test1.City objects");
        System.out.println(a.name == b.name); // should be true - both in String-Pool
        System.out.println(a.name.equals(b.name)); // should be true - both in String-Pool - checks address using ==
        System.out.println(a.name.hashCode() + " " + b.name.hashCode()); // should be the same ints - both in String-Pool - checks address using ==

        // So here we have 3 values because we use new and there are 3 distinct objects in memory in this Map
        System.out.println();
        Map<City, String> map = new LinkedHashMap<>();
        map.put(new City("NY"), "accessmodifiers/a");
        map.put(new City("NY"), "accessmodifiers/b");
        map.put(new City("Chicago"), "c");
        System.out.println(map.entrySet());
        System.out.println(map.values());

        // Now we have 2 values because we use the same objects as key for the first 2 items so there's only 2 distinct
        // objects in memory in this Map
        System.out.println();
        Map<City, String> map2 = new LinkedHashMap<>();
        map2.put(a, "accessmodifiers/a");
        map2.put(a, "accessmodifiers/b");
        map2.put(new City("Chicago"), "c");
        System.out.println(map2.entrySet());
        System.out.println(map2.values());

    }

}

