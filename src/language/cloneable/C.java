package language.cloneable;

/**
 * Must implement marker interface Cloneable, otherwise CloneNotSupportedException will be thrown.
 * Cloneable should not be used, better use copy constructor.
 */
public class C implements Cloneable {

    int i;
    B[] t;

    public C() {
        this.i = 1;
        this.t = new B[]{new B(1), new B(2), new B(3)};
    }

    // overrides protected clone() form Object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}