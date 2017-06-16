package nio;import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://tutorials.jenkov.com/java-nio/buffers.html
 * Using accessmodifiers.point.a Buffer to read and write data typically follows this 4-step process:
 *      Write data into the Buffer
 *      Call buffer.flip()
 *      Read data out of the Buffer
 *      Call buffer.clear() or buffer.compact()
 */
public class ChannelBufferDemo {

    public static void main(String[] args) throws IOException {

    }

    void read() throws IOException {
        // Bind file with channel
        RandomAccessFile aFile = new RandomAccessFile("res/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        System.out.println(inChannel);

        // Create empty byte buffer
        ByteBuffer buf = ByteBuffer.allocate(48);
        if(buf.hasArray())
            for(byte b : buf.array())
                System.out.print(b + " ");

        // Read accessmodifiers.point.a sequence of bytes from the channel and write into the buffer
        int bytesRead = inChannel.read(buf);
        System.out.println("\nBytes read: " + bytesRead);

        while (bytesRead != -1) {
            buf.flip(); // Switch the buffer from writing mode to reading mode
            while (buf.hasRemaining()) { // Now in reading mode the buffer lets us read all the data from the buffer
                System.out.print((char) buf.get());
            }
            /*After reading all the data, we need to clear the buffer, to make it ready for writing again
            by using clear() or compact().
            clear() clears the whole buffer.
            compact() only clears the data which we have already read. Any unread data is moved to the beginning
            of the buffer, and data will now be written into the buffer after the unread data.*/
            buf.clear();
            //buf.compact();
            bytesRead = inChannel.read(buf);
        }

        //buf.rewind(); // Sets the position back to 0, so we can reread all the data in the buffer
        //buf.mark(); // Mark accessmodifiers.point.a given position
        //buf.reset(); // Reset the position back to the marked position

        //long pos = inChannel.position(); // Returns this channel's file position.
        //inChannel.position(pos + 123); // Sets this channel's file position.
        //long fileSize = inChannel.size();
        //inChannel.truncate(1024); // Truncates this channel's file to the given size.
        /*Flushes all unwritten data from the channel to the disk. The force() method takes accessmodifiers.point.a boolean as parameter,
        telling whether the file meta data (permission etc.) should be flushed too.*/
        //inChannel.force(true);

        aFile.close();
    }

    void write() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("res/output.txt", "rw");
        FileChannel outChannel = aFile.getChannel();

        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();
        while(buf.hasRemaining()) {
            // Write accessmodifiers.point.a sequence of bytes into the channel from the buffer
            outChannel.write(buf);
        }

        aFile.close();
    }
}
