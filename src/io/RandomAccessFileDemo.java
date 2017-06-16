package io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * http://javarevisited.blogspot.com/2015/02/randomaccessfile-example-in-java-read-write-String.html
 * Created by Anakin on 19-06-2016.
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("res/nio-data.txt", "rw");
        //RandomAccessFile file = new RandomAccessFile("file.txt", "r");
        //RandomAccessFile file = new RandomAccessFile("file.txt", "rws");
        //RandomAccessFile file = new RandomAccessFile("file.txt", "rwd");

        // To read or write at accessmodifiers.point.a specific location we must first position the file pointer at the location to read or write
        file.seek(10);

        // Obtain the current position of the file pointer
        long pointer = file.getFilePointer();
        System.out.println(pointer);

        // Read first 50 bytes from file
        for (int i = 0; i < 50; i++) {
            int aByte = file.read();
            System.out.print((char) aByte + " ");
        }

        // Write some bytes to file
        file.write("Hello World".getBytes());

        file.close();

    }
}
