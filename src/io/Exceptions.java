package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exceptions {

    public static void main(String[] args) {

        // Classic
        InputStream input = null;
        try {
            input = new FileInputStream("c:\\data\\input-text.txt");
            int data = input.read();
            while (data != -1) {
                // do something with data...
                // doSomethingWithData(data);
                data = input.read();
            }
        } catch (IOException e) {
            //do something with e... log, perhaps rethrow etc.
        } finally {
            try {
                if (input != null) input.close(); // close() can throw exception so we should handle it
            } catch (IOException e) {
                //do something, or ignore.
            }
        }

        // Try with resource
        try (InputStream inputstream = new FileInputStream("file.txt")) {
            int data = inputstream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputstream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
