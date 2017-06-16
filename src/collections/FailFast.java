package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
 */
public class FailFast {

    public static void main(String[] args) {
        Map<String, String> premiumPhone = new HashMap<>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung", "S7");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z"); // ConcurrentModificationException
//            premiumPhone.put("HTC", "Xperia Z"); // ConcurrentModificationException
        }

/*        iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z"); // ConcurrentModificationException
        }*/

    }
}