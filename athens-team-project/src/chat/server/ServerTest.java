package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zsolt on 08/03/16.
 */
public class ServerTest {

    public static void main(String[] args) {

        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(50000);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("client online");
                Server server = new Server(socket);
                server.start();
            }
        } catch (IOException e) {

        } finally {
            try {
                serverSocket.close();
            } catch (Exception e) {

            }
        }
    }
}
