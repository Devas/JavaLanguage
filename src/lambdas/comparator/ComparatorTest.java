package lambdas.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Tom"),
                new Person("Dave"),
                new Person("Matt"),
                new Person("John"),
                new Person("Adam"));

        System.out.println(personList);

        // Sort with Inner Class
        Collections.sort(personList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getSurName().compareTo(p2.getSurName());
            }
        });
        System.out.println("=== Sorted Asc SurName ===");
        System.out.println(personList);


        // Use Lambda with type instead // Print Asc
        Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
        System.out.println("=== Sorted Asc SurName ===");
        System.out.println(personList);


        // Use Lambda without type instead // Print Desc
        // Lambda supports "target typing" which infers the object type from the context in which it is used.
        // Because we are assigning the result to accessmodifiers.point.a Comparator defined with accessmodifiers.point.a generic, the compiler can infer that
        // the two parameters are of the Person type.
        Collections.sort(personList, (p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));
        System.out.println("=== Sorted Desc SurName ===");
        System.out.println(personList);
    }
}