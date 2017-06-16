package casting;

import static java.lang.Integer.parseInt;

public class CastingDemo {

    public static void main(String[] args) {

        // Integer.valueOf() always caches values in the range -128 to 127, inclusive.
        // Caching means that two distinct references refer to the same object.
        // It may also cache other values outside of this range.
        // To enable assertions we have to use -enableassertions or -ea
        // If assertion is not true, AssertionError is thrown
        Integer cachedI1 = Integer.valueOf(127);
        Integer cachedI2 = Integer.valueOf(127);
        // It is cached, assertion OK.
        assert cachedI1 == cachedI2;

        Integer ncachedI1 = Integer.valueOf(128);
        Integer ncachedI2 = Integer.valueOf(128);
        // It is not cached, assertion fails ant throws AssertionError.
        // Note we can add : "String message" to specify what error message of the thrown AssertionError should be.
        assert ncachedI1 == ncachedI2 : "128 is not cached";
        // We can also change the maximum number to be cached using JVM option i.e. -XX:AutoBoxCacheMax=256

        // Integer.valueOf(int number); Integer.valueOf(String number, [int radix]) returns Integer object
        Integer I = Integer.valueOf(127);
        I = Integer.valueOf("128");
        I = Integer.valueOf("1100110", 2);
        System.out.println(I);

        // Return the value of Integer object as primitive type
        I.shortValue();
        I.intValue();
        I.longValue();
        I.floatValue();
        I.doubleValue();
        I.byteValue();

        // Integer.parseInt(String number, [int radix]) returns primitive type int
        int i = Integer.parseInt("+128"); // returns 128, radix is 10 by default
        System.out.println(i);
        parseInt("0", 10); // returns 0
        parseInt("473", 10); // returns 473
        parseInt("+42", 10); // returns 42
        parseInt("-0", 10); // returns 0
        parseInt("-FF", 16); // returns - 255
        parseInt("1100110", 2); // returns 102
        parseInt("2147483647", 10); // returns 2147483647
        parseInt("-2147483648", 10); // returns - 2147483648
        //parseInt("2147483648", 10); //throws accessmodifiers.point.a NumberFormatException
        //parseInt("99", 8); // throws accessmodifiers.point.a NumberFormatException
        //parseInt("Kona", 10); // throws accessmodifiers.point.a NumberFormatException
        parseInt("Kona", 27); // returns 411787

        System.out.println(Character.MIN_RADIX); // minimum radix is 2
        System.out.println(Character.MAX_RADIX); // maximum radix is 36

        // Return String representation of int
        System.out.println(Integer.toString(128));
        System.out.println(Integer.toString(128, 2));
        System.out.println(Integer.toBinaryString(128));
        System.out.println(Integer.toOctalString(128));
        System.out.println(Integer.toHexString(128));

        // Other wrappers also have valueOf() and parse...() methods
        Short S;
        Long L;
        Float F;
        Double D;
        Byte B;

        // String.valueOf() can also return string representation
        // Note: String class does not have parse() method
        String.valueOf(true);
        String.valueOf('a');
        String.valueOf(128);
        String.valueOf(128l);
        String.valueOf(128L);
        String.valueOf(128.0f);
        String.valueOf(128.0F);
        String.valueOf(128.0);

    }
}
