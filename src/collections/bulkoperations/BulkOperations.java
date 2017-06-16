package collections.bulkoperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The bulk operations perform some operation on an entire Collection in a single shot.
 * <p>
 * containsAll: Returns true if the target Collection contains all of the elements in the specified Collection (c).
 * <p>
 * addAll: Adds all of the elements in the specified Collection to the target Collection.
 * <p>
 * removeAll: Removes from the target Collection all of its elements that are also contained in the specified Collection.
 * <p>
 * retainAll: Removes from the target Collection all of its elements that are not also contained in the specified
 * Collection. That is to say, it retains only those elements in the target Collection that are also contained
 * in the specified Collection.
 * <p>
 * clear: Removes all elements from the Collection.
 */
public class BulkOperations {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());

        list.add(null);
        System.out.println(list.isEmpty());
        System.out.println(list.size());

        // Remove all of the null elements from a Collection:
        list.removeAll(Collections.singleton(null));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
    }

}


