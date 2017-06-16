package collections.empty;

import java.util.Collections;
import java.util.List;

/**
 * These methods return immutable empty collections / objects and throw UnsupportedOperationException if we modify.
 * These really return always the same singleton instance so this is very efficient.
 * Immutable data can be safely shared between threads.
 * Can be used instead of null - we check size / isEmpty instead of null.
 * <p>
 * https://www.quora.com/What-is-the-use-of-Collections-emptyList
 */
public class Empty {

    public static void main(String[] args) {
        Collections.<Empty>emptyList(); // Starting with Java 5.0 you can specify the type of element in the container

        // But starting with Java 7, you can let the compiler infer the type parameter of the generic method invocation
        // from the target type
        Collections.emptyList();
        Collections.emptyMap();
        Collections.emptySet();
        Collections.emptyIterator();
        Collections.emptyListIterator();
        Collections.emptyEnumeration();
        Collections.emptyNavigableMap();
        Collections.emptyNavigableSet();
        Collections.emptySortedMap();
        Collections.emptySortedSet();

        List<Integer> objects = Collections.emptyList();
        try {
            objects.add(1);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        System.out.println("I write empty list " + objects);
    }

}
