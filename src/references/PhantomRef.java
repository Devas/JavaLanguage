package references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomRef {

    public static void main(String[] args) {
        A a = new A();

        //Creating ReferenceQueue
        ReferenceQueue<A> refQueue = new ReferenceQueue<>();

        PhantomReference<A> phantomA = new PhantomReference<>(a, refQueue);

        a = null; // Now, B-type object to which 'accessmodifiers.point.a' is pointing earlier is available for garbage collection. But, this object is kept in 'refQueue' before removing it from the memory.
        System.out.println(phantomA.get()); // In order to ensure that accessmodifiers.point.a reclaimable object remains so, the referent of accessmodifiers.point.a phantom reference may not be retrieved: The get method of accessmodifiers.point.a phantom reference always returns null.
        System.out.println(refQueue.poll());
    }

}