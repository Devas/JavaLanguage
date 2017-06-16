package language.cloneable;

public class B {

    int i;
    A a;

    public B() {
        this.i = 1;
        this.a = new A();
    }

    public B(int i) {
        this.i = i;
        this.a = new A();
    }

    @Override
    public String toString() {
        return "B{" +
                "i=" + i +
                ", a=" + a +
                '}';
    }
}
