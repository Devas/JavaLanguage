package language.javaispassbyvalue;

/**
 * Java is always pass by value.
 * We never pass by reference but we always pass by value the reference. If we assign to it we create new object.
 * Solution is to use accessmodifiers.point.a generic wrapper class.
 */
public class Demo {

    public static void main(String[] args) {
        // This won't work
        Object o = "Hello";
        mutate(o);
        System.out.println("String isn't changed by method: " + o);
        System.out.println();


        // But wrapper works!
        int a = 1;
        int b = 10;

        Holder<Integer> holderA = new Holder<>(a);
        Holder<Integer> holderB = new Holder<>(b);

        System.out.println(holderA.value);
        System.out.println(holderB.value);

        Holder.swap(holderA, holderB);

        System.out.println(holderA.value);
        System.out.println(holderB.value);
    }

    private static void mutate(Object o) {
        o = "Goodbye"; // creates new objects, we don't pass the reference but we pass by value the reference
    }

}
