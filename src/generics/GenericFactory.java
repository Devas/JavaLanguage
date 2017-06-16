package generics;

public class GenericFactory<T> {

    /*Class theClass = null;

    public GenericFactory(Class theClass) {
        this.theClass = theClass;
    }

    public T createInstance() {
        try {
            System.out.println("Instance created - " + theClass.toGenericString());
            return (T) this.theClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public static <T> T getInstance(Class<T> theClass) {
        try {
            return theClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        /*GenericFactory<Integer> factory1 = new GenericFactory<>(Integer.class);
        Integer integerInstance = factory1.createInstance();*/

        //GenericFactory<Box<String>> factory2 = new GenericFactory<>(Box.class);
        //Box<String> boxInstance = factory2.createInstance();

        String string = getInstance(String.class);
    }
}

