package lambdas.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumbersTest {

    @Test
    public void testFindNumbers() {
        assertArrayEquals(
                new Integer[]{45, 33, 24, 40},
                Numbers.findNumbers(Arrays.asList(12, 5, 45, 18, 33, 24, 40), Numbers::isMoreThanFifty).toArray());
    }

}