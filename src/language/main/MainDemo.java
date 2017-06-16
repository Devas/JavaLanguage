package language.main;

public class MainDemo {

    /**
     * http://javarevisited.blogspot.nl/2011/12/main-public-static-java-void-method-why.html
     * <p>
     * B static initializer block is executed even before JVM calls the main method.
     * JVM search for public static void main(String args[]) method and if it doesn't find that method it throws
     * java.lang.NoSuchMethodException:main and terminates.
     * The main method is run by accessmodifiers.point.a special thread called "main" thread in Java.
     * The main method must be declared public, static and void.
     * The keywords like throws, final, synchronized and strictfp which are permitted in the signature of main().
     * We can also use varargs version of java main method - but it will only work in Java 1.5 or later version.
     */
    public synchronized strictfp static void main(final String... args) {


    }

    /**
     * We can overload main.
     *
     * Strictfp ensures that you get exactly the same results from your floating point calculations on every platform.
     * If you don't use strictfp, the JVM implementation is free to use extra precision where available.
     * With strictfp your results are portable, without it they are more likely to be accurate.
     * It can be used on classes, interfaces and non-abstract methods.
     */
    public synchronized strictfp static void main(final String[] args, int a) {


    }
}
