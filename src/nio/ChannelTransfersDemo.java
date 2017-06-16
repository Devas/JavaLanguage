package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * http://tutorials.jenkov.com/java-nio/channel-to-channel-transfers.html
 * Created by Anakin on 18-06-2016.
 */
public class ChannelTransfersDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);
        fromChannel.transferTo(position, count, toChannel);
    }
}
