package language.cloneable;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception {
        C c = new C();
        Object o = c.clone();
        System.out.println("Is address of the copy the same? " + (o == c));
        System.out.println("Primitive int of C is copied: " + ((C) o).i);
        System.out.println("Whole object is copied: " + Arrays.toString(((C) o).t));

        // It a copy, change of primitive in 'c' does not affect the copy 'o'
        c.i = 2;
        System.out.println("It's a copy of primitive: " + ((C) o).i);

        // ... but this copy is only a shallow copy, change of array in 'c' affects also the copy 'o'
        c.t[0] = new B(100);
        System.out.println("But it's really only a shallow cpoy: " + Arrays.toString(((C) o).t));
    }

}
