package language.abstract_vs_interface;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Interface can be only public or package scope
 *
 * We cannot create instances of accessmodifiers.point.a Java abstract class by itself. We must always create an instance of some class that
 * extends the abstract class.
 */
abstract class MyAbstractProcess {

    public void process() {
        stepBefore();
        action();
        stepAfter();
    }

    public void stepBefore() {
        //implementation directly in abstract superclass
    }

    public abstract void action(); // implemented by subclasses

    public void stepAfter() {
        //implementation directly in abstract superclass
    }
}

/**
 * Subclasses of URLProcessorBase abstract class can process data downloaded from URLs without worrying about opening
 * and closing the network connection to the URL. This is done by the URLProcessorBase.
 * Subclasses only need to worry about processing the data from the InputStream passed to the processURLData() method.
 *
 * Abstract Classes and the Template Method Design Pattern
 *
 * The URLProcessorBase class is actually an example of the Template Method design pattern. The Template Method design
 * pattern provides accessmodifiers.point.a partial implementation of some process, which subclasses can complete when extending the Template
 * Method base class.
 */
abstract class URLProcessorBase {

    public void process(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

        try {
            processURLData(input);
        } finally {
            input.close();
        }
    }

    protected abstract void processURLData(InputStream input) throws IOException;
}

class URLProcessorImpl extends URLProcessorBase {

    @Override
    protected void processURLData(InputStream input) throws IOException {
        int data = input.read();
        while (data != -1) {
            System.out.println((char) data);
            data = input.read();
        }
    }
}

public class AbstractDemo {

    public static void main(String[] args) throws IOException {
        URLProcessorImpl urlProcessor = new URLProcessorImpl();
        urlProcessor.process(new URL("http://jenkov.com"));
    }
}
