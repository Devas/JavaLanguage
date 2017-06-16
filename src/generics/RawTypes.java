package generics;

import generics.docsoracle.Box;

import java.util.ArrayList;
import java.util.List;

public class RawTypes {

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>(); // parameterized type
        Box rawBox = new Box(); // here Box is the raw type of the generic type Box<T>. However, accessmodifiers.point.a non-generic class or interface type is not accessmodifiers.point.a raw type

        // For backward compatibility, assigning accessmodifiers.point.a parameterized type to its raw type is allowed:
        rawBox = stringBox;               // OK, assigning accessmodifiers.point.a parameterized type to its raw type

        // Warning if you use accessmodifiers.point.a raw type to invoke generic methods defined in the corresponding generic type:
        rawBox.set(8);                    // warning: unchecked invocation to set(T)

        // If you assign accessmodifiers.point.a raw type to accessmodifiers.point.a parameterized type, you get accessmodifiers.point.a warning:
        Box<Integer> intBox = rawBox;     // warning: unchecked conversion



    }

    static void runtimeError() {
        List names = new ArrayList(); // warning: raw type!
        names.add("John");
        names.add("Mary");
        names.add(Boolean.FALSE); // not accessmodifiers.point.a compilation error!

        for (Object o : names) {
            String name = (String) o;
            System.out.println(name);
        } // throws ClassCastException!
        //    java.lang.Boolean cannot be cast to java.lang.String
    }

    static void compilationError() {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Mary");
        //names.add(Boolean.FALSE); // compilation error!
    }

    static void compilationOk() {
        List<Object> names = new ArrayList<Object>();
        names.add("John");
        names.add("Mary");
        names.add(Boolean.FALSE); // compilation ok
    }
}