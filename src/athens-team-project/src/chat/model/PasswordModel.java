package chat.model;

import chat.ChatroomSecurity;
import chat.interfaces.PasswordModelImpl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

public class PasswordModel extends Observable implements PasswordModelImpl {
    private String server ;
    private int port ;
    private Socket socket;
    private BufferedReader socketInput;
    private DataOutputStream socketOutput;
    private ChatroomSecurity security = new ChatroomSecurity();
    private String authenticator = "";
    private String username;

    public void setAuthenticator(String newString) {
    	authenticator = newString;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String newUsername) {
    	username = newUsername;
    }
    
    public String getResponseType(String string) {
    	return string.substring(0,4);
    }
    
    public String getForgetPassType(String string) {
    	return string.substring(4,5);
    }
    
    public PasswordModel(String host,int port) {
    	this.server=host;
    	this.port=port;
        try {
            socket = new Socket(server, port);
        } catch (Exception e) {
            System.out.println("Error establishing connection to server");
            disconnectSocket();
        }

        try {
            socketOutput = new DataOutputStream(socket.getOutputStream());
            socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            System.out.println("Error creating Input/Output Streams");
            disconnectStreams();
        }
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
    
    // Server handles password change
    // return int response to GUI to display relevant message (success or failure)
    public int changePassword(String username, String currentPassword, String newPassword) throws IOException {
        socketOutput.writeBytes(security.encrypt("4" + "req" + username +"@"+ currentPassword +"@"+ newPassword, "athens")[0]+"\n");
        try {
        	String response = security.decrypt(socketInput.readLine(), "athens");
            if (getResponseType(response).equals("4res")) {
               	int intresponse = Integer.parseInt(response.substring(4, 5));
                //disconnect();
               	return intresponse;
               	// 1 is successful
               	// 0 is database error
               	// 2 is password1 error???
            }
            else {
               	//disconnect();
               	return -1;
            }
        } catch (IOException e) {
        	//disconnect();
         	return -1; // Error during new password verification
        }         
    }
    
    public boolean authenticationCheck(String userString) {
    	if (userString.equals(authenticator)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int forgetPassword1(String username) throws IOException {
    	setUsername(username);
    	
    	socketOutput.writeBytes(security.encrypt("7" + "req" + 1 + username, "athens")[0]+"\n");
    	
    	try {
            String response = security.decrypt(socketInput.readLine(), "athens");
            if (getResponseType(response).equals("7res") && getForgetPassType(response).equals("1")) {
            	if(response.substring(5, 6).equals("1")) {
            		String randomString = response.substring(6);
            		setAuthenticator(randomString);
            		return 1; // Email with authenticator sent
            	}
            	else {
            		return 0; // User does not exist in database
            	}
            }
        } catch (IOException e) {

            return -1; // Error during database communication
        }
 
        return -1;
    }
    
    public int forgetPassword2(String newPassword) throws IOException {
    	socketOutput.writeBytes(security.encrypt("7" + "req" + 2 + getUsername() + "@" + newPassword, "athens")[0]+"\n");
    	
    	try {
            String response = security.decrypt(socketInput.readLine(), "athens");
            if (getResponseType(response).equals("7res") && getForgetPassType(response).equals("2")) {
            	if(response.substring(5, 6).equals("1")) {
            		
            		return 1; // Password change successful
            	}
            	else {
            		
            		return 0; // Password change failed
            	}
            }
        } catch (IOException e) {
            
            return -1; // Error during password change
        }
    	
        return -1;
    }

	
}