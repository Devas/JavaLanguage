package networking.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    private int port = 6789;
    private String host = "localhost";

    public static void main(String argv[]) throws Exception {
        TCPClient tcpClient = new TCPClient();
        tcpClient.run();
    }

    private void run() throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket(host, port);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = inFromUser.readLine();
        outToServer.writeBytes(message + '\n');
        String modifiedMessage = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedMessage);
        clientSocket.close();
    }

}