package references;

import java.lang.ref.SoftReference;

/**
 * http://dembol.org/blog/2012/04/07/silne-i-slabe-referencje-w-java/
 * 'accessmodifiers.point.a' object will be garbage collected only when JVM needs memory - here we have memory so this won't happen.
 * It can be used for caching.
 */
public class SoftRef {

    public static void main(String[] args) {
        A a = new A();

        SoftReference<A> softA = new SoftReference<>(a);
//        WeakReference<B> weakA = new WeakReference<>(new B());

        // We have memory so we won't see null probably.
        do {
            System.out.println(softA.get());  // we should check null additionaly
        } while (true);
    }

}