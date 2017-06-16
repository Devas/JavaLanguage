package util.optional;

import java.util.Optional;

/**
 * We can also use @Nullable and @Nonnull
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // Optional has private constructor and is final so we must use static method of()
        Optional<String> s = Optional.of("input");

        // Return the value if this Optional contains non-null value. Otherwise throws NoSuchElementException.
        System.out.println(s.get());

        // Return boolean value - true if there is a value present, otherwise false.
        System.out.println(s.isPresent());

        // If a value is present, invoke the specified Consumer with the value, otherwise do nothing.
        s.ifPresent(v -> System.out.println(v));
        s.ifPresent(System.out::println);

        // Return the value if present, otherwise return other value which may be null.
        System.out.println(s.orElse("default"));

        // Return the value if present, otherwise invoke Supplier and return the result of that invocation.
        System.out.println(s.orElseGet(() -> "Hello".concat("World")));

        // Return the contained value, if present, otherwise throw an exception to be created by the provided Supplier.
        s.orElseThrow(() -> new RuntimeException());

        // If a value is present, and the value matches the given predicate, return an Optional describing the value, otherwise return an empty Optional.
        System.out.println(s.filter(v -> v.startsWith("i"))); // Optional object
        System.out.println(s.filter(v -> v.startsWith("A"))); // empty Optional


        System.out.println(s.map(OptionalDemo::getOutput));

        // What happens if your function is a function from T -> Optional<U>? Your result is now an Optional<Optional<U>>!
        // That's what flatMap is about: if your function already returns an Optional, flatMap is a bit smarter and
        //  doesn't double wrap it, returning Optional<U>. It's the composition of two functional idioms: map and flatten.
        System.out.println(s.flatMap(OptionalDemo::getOutputOpt));
    }

    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }

    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

}
