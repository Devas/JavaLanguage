package networking.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class SocketDemo {

    public static void main(String[] args) throws IOException {
//        writeToSocket();
//        readFromSocket();
//        listenIncomingConnections();
//        sendDatagran();
//        receiveDatagram();
//        urlConnection();
//        jarUrlConnection();
        inetAddress();
    }

    static void writeToSocket() throws IOException {
        //Socket socket = new Socket("78.46.84.171", 80);
        Socket socket = new Socket("jenkov.com", 80);
        if (socket.isConnected()) System.out.println("Connected");

        OutputStream out = socket.getOutputStream();
        out.write("some data".getBytes());
        out.flush();

        out.close();
        socket.close();
    }

    static void readFromSocket() throws IOException {
        Socket socket = new Socket("jenkov.com", 80);
        if (socket.isConnected()) System.out.println("Connected");

        InputStream in = socket.getInputStream();

        int data = in.read();
        //... read more data...

        in.close();
        socket.close();
    }

    static void listenIncomingConnections() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        boolean isStopped = false;
        while (!isStopped) {
            Socket clientSocket = serverSocket.accept();

            //do something with clientSocket
        }
    }

    static void sendDatagran() throws IOException {
        //byte[] buffer = new byte[65508];
        byte[] buffer = "0123456789".getBytes();
        //InetAddress address = InetAddress.getByName("jenkov.com");
        InetAddress receiverAddress = InetAddress.getLocalHost();

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, 80);

        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packet);
    }

    static void receiveDatagram() throws IOException {
        byte[] buffer = new byte[10];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        DatagramSocket datagramSocket = new DatagramSocket(80);
        datagramSocket.receive(packet);
        byte[] buffer2 = packet.getData();

    }

    static void urlConnection() throws IOException {
        //URL url = new URL("file:/c:/data/test.txt"); // we can also refer to file
        URL url = new URL("http://jenkov.com");

        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true); // false for input (GET), true for output (POST)
        InputStream input = urlConnection.getInputStream();

        int data = input.read();
        while (data != -1) {
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
    }

    /**
     * JarURLConnection instances can only be used to read from JAR files. It is not possible to get accessmodifiers.point.a
     * java.io.OutputStream to modify or write to the underlying JAR file using this class.
     *
     * @throws IOException
     */
    static void jarUrlConnection() throws IOException {
        String urlString = "http://butterfly.jenkov.com/container/download/jenkov-butterfly-container-2.9.9-beta.jar";
        String urlJarEntry = "jar:http://www.foo.com/bar/baz.jar!/COM/foo/Quux.class";
        String urlJarFile = "jar:http://www.foo.com/bar/baz.jar!/";
        String urlJarDirectory = "jar:http://www.foo.com/bar/baz.jar!/COM/foo/";

        URL jarUrl = new URL(urlString);
        JarURLConnection connection = (JarURLConnection) jarUrl.openConnection();

        Manifest manifest = connection.getManifest();

        JarFile jarFile = connection.getJarFile();

        //do something with Jar file...
    }

    static void inetAddress() throws IOException {
        InetAddress addressOfDomain = InetAddress.getByName("jenkov.com");
        InetAddress addressOfIP = InetAddress.getByName("78.46.84.171");
        InetAddress addressOfLoopback1 = InetAddress.getByName(null);
        InetAddress addressOfLoopback2 = InetAddress.getLoopbackAddress();
        InetAddress addressOfLocalHost = InetAddress.getLocalHost();

        System.out.println(addressOfDomain);
        System.out.println(addressOfIP);
        System.out.println(addressOfLoopback1);
        System.out.println(addressOfLoopback2);
        System.out.println(addressOfLocalHost);

    }
}
