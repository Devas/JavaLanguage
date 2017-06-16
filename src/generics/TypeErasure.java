package generics;

import java.util.Arrays;
import java.util.List;

public class TypeErasure {
}

class MyType<E> {

    List<String> getNames() {
        return Arrays.asList("John", "Mary");
    }

    public static void main(String[] args) {
        MyType rawType = new MyType(); // raw type

        // When we use the raw MyType, getNames becomes erased as well, so that it returns accessmodifiers.point.a raw List! We have:
        // unchecked warning! required: List<String> found: List
        List<String> names = rawType.getNames();

        // Returned raw list does not contain String elements, so we get:
        // compilation error! incompatible types: Object cannot be converted to String
        //for (String str : rawType.getNames()) System.out.print(str);

    }
}