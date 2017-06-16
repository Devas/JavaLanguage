package generics;

import java.util.LinkedList;
import java.util.List;

public class CastingVsGenerics {

    public static void main(String[] args) {
        // non-generics way
        List listOne = new LinkedList();
        listOne.add(new Integer(0));
        Integer intOne = (Integer) listOne.iterator().next(); // the cast is required


        // generics way
        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(new Integer(0));
        Integer intTwo = listTwo.iterator().next();
    }
}
