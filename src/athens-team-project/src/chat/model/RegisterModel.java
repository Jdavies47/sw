package chat.model;

import chat.ChatroomSecurity;
import chat.interfaces.RegisterModelImpl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RegisterModel implements RegisterModelImpl {
    private String server ;
    private int port;
    private Socket socket;
    private BufferedReader socketInput;
    private DataOutputStream socketOutput;
    private ChatroomSecurity security = new ChatroomSecurity();

    public RegisterModel(String host,int port) {
    	this.server=host;
    	this.port=port;
        try {
            socket = new Socket(server, port);
        } catch (Exception e) {
            System.out.println("Error establishing connection to server");
            disconnectSocket();
        }

        try {
            socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketOutput = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error creating Input/Output Streams");
            disconnectStreams();
        }
    }

    public String getResponseType(String string) {
    	return string.substring(0,4);
    }
    
    public void disconnectSocket() {
        try {
            socket.close();
        } catch (Exception e1) {
        }
    }

    public void disconnectStreams() {
        try {
            socketInput.close();
            socketOutput.close();
        } catch (Exception e1) {
        }
    }

    public void disconnect() {
        disconnectSocket();
        disconnectStreams();
    }
    
    // Server handles registration process
    // returned integer here send to GUI (and display registration success message)
    public int register(String username, String nickname, String newpassword) throws IOException {
    	socketOutput.writeBytes(security.encrypt("2" + "req" + username+"@"+nickname+"@"+newpassword, "athens")[0]+"\n");
        try {
            String response = security.decrypt(socketInput.readLine(), "athens");
            if (getResponseType(response).equals("2res")) {
            	int intresponse = Integer.parseInt(response.substring(4));
            	//disconnect();
            	return intresponse;
            	// 2 for invalid user
            	// 1 for success
            	// 0 for database error
            }
        } catch (IOException e) {
            //disconnect();
            return -1;
        }
        //disconnect();
        return -1;
    }
}