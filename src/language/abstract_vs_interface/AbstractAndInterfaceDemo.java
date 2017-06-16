package language.abstract_vs_interface;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

interface URLProcessorA {

    public void process(URL url) throws IOException;
}

abstract class URLProcessorBaseA implements URLProcessorA {

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

class URLProcessorImplA extends URLProcessorBaseA {

    @Override
    protected void processURLData(InputStream input) throws IOException {
        int data = input.read();
        while (data != -1) {
            System.out.println((char) data);
            data = input.read();
        }
    }
}

public class AbstractAndInterfaceDemo {

    public static void main(String[] args) throws IOException {
        URLProcessorA urlProcessor = new URLProcessorImplA();
        urlProcessor.process(new URL("http://jenkov.com"));
    }
}
