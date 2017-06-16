package lambdas.methodreferences;

import java.util.AbstractList;
import java.util.List;
import java.util.function.Consumer;

public class MR1 {

    public static void main(String[] args) {
        getConsumer().accept("Hi");

        List list = new AbstractList() {
            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    private static Consumer getConsumer() {
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> c2 = s -> System.out.println(s);

        Consumer<String> c3 = System.out::println;

        return c3;
    }

}
