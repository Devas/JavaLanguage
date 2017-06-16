package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://tutorials.jenkov.com/java-nio/scatter-gather.html
 */
public class ScatterGatherDemo {

    public static void main(String[] args) {
        scatterToBuffers();
        gatherFromBuffers();
    }

    static void scatterToBuffers() {
        RandomAccessFile raFile = null;
        try {
            raFile = new RandomAccessFile("res/nio-data.txt", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileChannel inChannel = raFile.getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};

        try {
            inChannel.read(bufferArray); // Reads accessmodifiers.point.a sequence of bytes from this channel into the given buffers.
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ByteBuffer byteBuffer : bufferArray) {
            System.out.println(byteBuffer.flip());
            System.out.println(byteBuffer.asCharBuffer().get());
        }
    }

    static void gatherFromBuffers() {
        RandomAccessFile raFile = null;
        try {
            raFile = new RandomAccessFile("res/nio-data.txt", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileChannel outChannel = raFile.getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};

        try {
            outChannel.write(bufferArray); // Writes accessmodifiers.point.a sequence of bytes from the given buffers to this channel.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
