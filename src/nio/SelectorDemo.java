package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * http://tutorials.jenkov.com/java-nio/selectors.html
 * Created by Anakin on 19-06-2016.
 */
public class SelectorDemo {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        // Selector can only register non-blocking channels
        // We cannot use FileChannel with accessmodifiers.point.a Selector since FileChannel is only in blocking-mode
        // SocketChannel works fine because it can be switched into non-blocking mode
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);


        while (true) {

            int readyChannels = selector.select();

            if (readyChannels == 0) continue;


            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {

                key = keyIterator.next();

                if (key.isAcceptable()) {
                    // accessmodifiers.point.a connection was accepted by accessmodifiers.point.a ServerSocketChannel.

                } else if (key.isConnectable()) {
                    // accessmodifiers.point.a connection was established with accessmodifiers.point.a remote server.

                } else if (key.isReadable()) {
                    // accessmodifiers.point.a channel is ready for reading

                } else if (key.isWritable()) {
                    // accessmodifiers.point.a channel is ready for writing
                }

                keyIterator.remove();
            }
        }
    }
}
