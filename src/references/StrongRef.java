package references;

/**
 * Standardowym typem referencji są referencje silne, które uzyskujemy po stworzeniu obiektu za pomocą operatora new
 * (lub oczywiście poprzez skopiowanie referencji z jakiejś zmiennej).
 * Jeżeli na dany obiekt nie wskazuje żadna referencja silna, GC jest zobligowany do usunięcia obiektu
 * w trakcie jednej z przyszłych kolekcji.
 */
public class StrongRef {

    public static void main(String[] args) {
        A a = new A(); // Strong Reference
        a = null; // If we assign null, object to which 'accessmodifiers.point.a' was pointing earlier is eligible for garbage collection.
    }

}