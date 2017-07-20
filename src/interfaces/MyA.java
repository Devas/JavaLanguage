package interfaces;

interface MyA { // can be package-private or public

    int a = 1;
    final int f = 7;
    static int s = 100;

    void e();

    static void s() {}

    default void a() {

    }

//    private void p() {
//
//    }
//
//    private static void ps() {
//
//    }

}
