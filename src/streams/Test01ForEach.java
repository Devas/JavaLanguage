package streams;

import java.util.List;

public class Test01ForEach {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        // Use expression lambda
        System.out.println("\n=== Western Phone List ===");
        pl.forEach(p -> p.printWesternName());

        // Use method reference
        System.out.println("\n=== Eastern Phone List ===");
        pl.forEach(Person::printEasternName);

        // Use statement lambda
        System.out.println("\n=== Custom Phone List ===");
        pl.forEach(p -> {
            System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail()));
        });

    }

}
