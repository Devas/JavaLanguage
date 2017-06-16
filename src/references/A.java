// http://dembol.org/blog/2012/04/07/silne-i-slabe-referencje-w-java/
package references;

public class A {

    @Override
    public String toString() {
        return "B{}";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize");
        super.finalize();
    }

}
