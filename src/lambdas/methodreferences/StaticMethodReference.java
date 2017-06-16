package lambdas.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static lambdas.methodreferences.Numbers.findNumbers;

public class StaticMethodReference {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

        // Using an anonymous class
        findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        });

        // Using accessmodifiers.point.a lambda expression
        findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));

        // Using accessmodifiers.point.a method reference
        System.out.println(findNumbers(list, Numbers::isMoreThanFifty));
    }

}

