package references;

import java.lang.ref.WeakReference;

/**
 * http://dembol.org/blog/2012/04/07/silne-i-slabe-referencje-w-java/
 * <p>
 * Referencje słabe są słabszą odmianą referencji miękkich.
 * Oznacza to bardziej agresywną politykę GC w stosunku do nich - są one usuwane dużo częściej niż referencje miękkie,
 * zazwyczaj podczas którejś kolekcji GC.
 * Używając w kodzie referencji słabych należy się zabezpieczyć przed sytuacją kiedy metoda weakA.get()
 * za którymś razem może zwrócić po prostu null.
 */
public class WeakRef {

    public static void main(String[] args) {
        A a = new A();

        WeakReference<A> weakA = new WeakReference<>(a);
//        WeakReference<B> weakA = new WeakReference<>(new B());

        // You can retrieve back the object which has been weakly referenced only if it hasn't been garbage-collected.
        // After few seconds (when GC runs) we get null printed
        do {
            System.out.println(weakA.get()); // we should check null additionaly
        } while (true);
    }

}