package generics.concepts.instantiatingObjectOfTypeParameter;

import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * You need to specify some factory to create instances of T.
 */
public class Solution<T> {

    public static void main(String[] args) {
        MyClass1<StringBuilder> s1 = new MyClass1<>(new Supplier<StringBuilder>() {
            @Override
            public StringBuilder get() {
                return new StringBuilder();
            }
        });
        MyClass1<StringBuilder> s2 = new MyClass1<>(() -> new StringBuilder());
        MyClass1<StringBuilder> s3 = new MyClass1<>(StringBuilder::new);

        MyClass3<StringBuilder> s4 = new MyClass3<>(new MyFactory<StringBuilder>() {
            @Override
            public StringBuilder newObject() {
                return new StringBuilder();
            }
        });
    }

}

/**
 * One approach could use accessmodifiers.point.a Supplier<T>
 */
class MyClass1<T> {

    private final Supplier<? extends T> ctor;

    private T field;

    MyClass1(Supplier<? extends T> ctor) {
        this.ctor = Objects.requireNonNull(ctor);
    }

    public T myMethod() {
        field = ctor.get();
        return field;
    }

}

/**
 * Alternatively, you can provide accessmodifiers.point.a Class<T> object, and then use reflection.
 */
class MyClass2<T> {

    private final Constructor<? extends T> ctor;

    private T field;

    MyClass2(Class<? extends T> impl) throws NoSuchMethodException {
        this.ctor = impl.getConstructor();
    }

    public T myMethod() throws Exception {
        field = ctor.newInstance();
        return field;
    }

}

/**
 * We can also implement own Factory / Builder which behaves like Supplier
 */
interface MyFactory<T> {
    T newObject();
}

class MyClass3<T> {

    private final MyFactory<? extends T> ctor;

    private T field;

    MyClass3(MyFactory<? extends T> ctor) {
        this.ctor = Objects.requireNonNull(ctor);
    }

    public T myMethod() {
        field = ctor.newObject();
        return field;
    }

    /**
     * We can also directly pass Factory instead of having private field for it
     */
    public T myMethod(MyFactory<T> factory) {
        field = factory.newObject();
        return field;
    }
}