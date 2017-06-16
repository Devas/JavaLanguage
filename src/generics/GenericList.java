package generics;

import java.util.*;

public class GenericList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "instantiatingObjectOfTypeParameter", "C", "C", "D");
        Iterator<String> iterator = list.iterator();

        for(String aString : list) {
            System.out.println(aString);
        }

        System.out.println(list);

        // we can use enumeration to traverse
        for(Enumeration<String> e = Collections.enumeration(list); e.hasMoreElements();) {
            String aString = e.nextElement();
            System.out.println(aString);
        }

        System.out.println(list);

        // iterator is better, because we can also remove
        while(iterator.hasNext()){
            String aString = iterator.next();
            System.out.println(aString);
            //iterator.remove(); // Every time remove the last element returned by this iterator
        }

        System.out.println(list);


    }
}
