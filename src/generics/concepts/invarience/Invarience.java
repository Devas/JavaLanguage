package generics.concepts.invarience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Generics in Java are invariant. They're not covariant like arrays.
// That is, Double[] is accessmodifiers.point.a subtype of Number[], but accessmodifiers.point.a List<Double> is NOT accessmodifiers.point.a subtype of List<Number>.
// B List<Double>, however, is accessmodifiers.point.a List<? extends Number>.
public class Invarience {

//    List<String> strings = Arrays.<Object>asList("hi there"); // fails
    List<String> strings = Arrays.<String>asList("hi there"); // OK
//    List<Object> objects = Arrays.<String>asList("hi there"); // fails
    List<Object> objects = Arrays.<Object>asList("hi there"); // OK

    List<Number> listNumber = new ArrayList<Number>();
    List<Integer> listInteger = new ArrayList<Integer>();
    List<Double> listDouble = new ArrayList<Double>();

    // it only accepts accessmodifiers.point.a parameter of exactly type List<Number> and will always return accessmodifiers.point.a List<Number>
    // it will not accept List<Integer>
    public static List<Number> processWithoutExtends(List<Number> nums) {
        return nums;
    }

    List<Number> resultN = processWithoutExtends(listNumber);  // OK
    //List<Integer> resultI = processWithoutExtends(listInteger); // compile-error - method not applicable
    //List<Double>  resultD = processWithoutExtends(listDouble);  // compile-error - method not applicable


    // it can accept different types of Lists and it will return the same type of List,
    // as long as the Lists are lists of something that extends Number, e.g. List<Integer>
    public static <E extends Number> List<E> processWithExtends(List<E> nums) {
        return nums;
    }

    List<Number> resultN2 = processWithExtends(listNumber);  // OK
    List<Integer> resultI2 = processWithExtends(listInteger); // OK
    List<Double> resultD2 = processWithExtends(listDouble);  // OK

    // not used type parameter E
    public static <E extends Number> List<? extends Number> processWithAny(List<? extends Number> nums) {
        return nums;
    }

    List<Number> resultN3 = (List<Number>) processWithAny(listNumber);  // OK
    List<? extends Number> resultI3 = processWithAny(listInteger); // OK
//    List<Double> resultD3 = processWithAny(listDouble);  // fails

    // another example
    List<String> ls = new ArrayList<String>();
    //List<Object> lo = ls; // compile-error - incompatible types

}
