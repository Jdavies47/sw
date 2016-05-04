package chat.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zsolt on 08/03/16.
 */
public class Server extends Thread {

    Socket socket = null;
    DataOutputStream response;

    public Server(Socket socket) throws IOException {
        this.socket = socket;
        response = new DataOutputStream(socket.getOutputStream());
        run();
    }

    public void run() {

        int action = 0;

        while (action != -1) {

            try {
                action = socket.getInputStream().read() - 48;
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (action) {
                case 0:
                    System.out.println("this is a logoff request");
                    try {
                        socket.getOutputStream().write(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    System.out.println("this is a login request");
                    try {
                        socket.getOutputStream().write(1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("this is a verifyRegistration request");
                    try {
                        socket.getOutputStream().write(2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("this is a send message request");
                    try {
                        socket.getOutputStream().write(3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("this is a change password request");
                    try {
                        socket.getOutputStream().write(4);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("this is a view chatlog request");
                    try {
                        socket.getOutputStream().write(5);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("this is a change status request");
                    try {
                        socket.getOutputStream().write(6);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("this is a forgotten PW request");
                    try {
                        socket.getOutputStream().write(7);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}

