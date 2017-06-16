package lang;

public class ObjectClass {

    public static void main(String[] args) {
        Object o = new Object();
        try {
            o.wait(); // TODO
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * http://stackoverflow.com/questions/2506488/when-is-the-finalize-method-called-in-java
     */
    @Override
    protected void finalize() {
        System.out.println("Will i execute?");
    }

}
