package language.arrays;

public class Arrays {

    public static void main(String[] args) {
        Object[] t1 = new Object[]{new Integer(1), new Integer(2)};
        Object t2[] = new Object[]{new Integer(1), new Integer(2)};
        Object[] t3 = {new Integer(1), new Integer(2)};

        Object tx = new Object[]{new Integer(1), new Integer(2)};
        // We must cast if we don't use []
        System.out.println(((Object[])tx).length);
    }

}
