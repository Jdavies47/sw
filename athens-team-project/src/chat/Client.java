package chat;

import chat.database.Database;
import chat.interfaces.ClientImpl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Zsolt Pazmandy on 04/03/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 * <p>
 * JAVA Workshop Group Project 'Athens'
 * Client for Chat Application
 */
public class Client extends Observable implements ClientImpl {

    /**
     * Network variables
     */
    private Socket clientSocket;
    private String host ;
    private int port ;
    private Connection connection;

    /**
     * I/O variables
     */
    private DataOutputStream request;
    private BufferedReader fromServer;
    private String response;

    /**
     * Client variables
     */
    private String username;
    private String username2;
    private String nickname;
    private String password;
    private String pw1;
    private String pw2;
    private String message;
    private ArrayList<Message> messagesList;
    private String status;
    private ArrayList<User> userList;
    private ChatroomSecurity security;
    private Database database;
    private User currentUser;
    private ArrayList<Message> Chatlog;
    private boolean logUpdated;
    private static volatile boolean isClosed;

    /**
     * Request-protocol definitions
     * Each request stream from Client to Server begins
     * with a one-char-long identifier, so the server
     * can understand what kind of request is being sent
     */
    private final String logoffProtocol = "0";
    private final String loginProtocol = "1";
    private final String verifyRegistrationProtocol = "2";
    private final String sendMessageProtocol = "3";
    private final String changePwProtocol = "4";
    private final String viewLogsProtocol = "5";
    private final String changeStatusProtocol = "6";
    private final String forgottenPwProtocol = "7";
    private final String addOrRemoveUser = "8";
    private final String changeNicknameProtocol = "n";

    /**
     * Constructor creates socket & initialises streams
     */
    public Client(String host,int port) throws IOException, SQLException {
    	this.setHost(host);
    	this.setPort(port);

        userList = new ArrayList<>();
        messagesList = new ArrayList<>();
        Chatlog=new ArrayList<>();
        status = "Available";
        clientSocket = new Socket(host, port);
        request = new DataOutputStream(clientSocket.getOutputStream());
        fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        security = new ChatroomSecurity();
        currentUser = new User(getUsername(), getNickname(), getStatus(), null);
        isClosed = false;
        setLogUpdated(false);
    }

    /**
     * Client vars' getters & setters
     */

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Message> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(ArrayList<Message> messagesList) {
        this.messagesList = messagesList;
    }

    public DataOutputStream getRequest() {
        return request;
    }

    /**
     * User vars' getters & setters
     */
    public String getUsername() {
        return username;
    }

    public String getUsername2() {
        return username2;
    }

    public String getPassword() {
        return password;
    }

    public String getPw1() {
        return pw1;
    }

    public String getPw2() {
        return pw2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname){
    	this.nickname=nickname;
    	setChanged();
        notifyObservers(nickname);
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        setChanged();
        notifyObservers(status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Loads & stores current client's user-information from
     * the database.
     *
     * @throws SQLException
     */
    public void loadUser() throws SQLException, InterruptedException {
        userList.stream()
                .filter(u -> u.getUsername()
                        .equals(username))
                .forEach(u -> nickname = u.getNickname());
        System.out.println(nickname);

    }

    /**
     * Requests sent to the server
     */

    @Override
    public void logoff() throws IOException {
        request.writeBytes(security.encrypt(logoffProtocol + "req" + username, "athens")[0] + "\n");
    }

    @Override
    public void verifyRegistration(String username) throws IOException {
        request.writeBytes(verifyRegistrationProtocol + "req" + username);
        setChanged();
        notifyObservers(userList);
    }

    @Override
    public void sendPrivateMessage(String recipient, String message) throws IOException {
        request.writeBytes(security.encrypt(sendMessageProtocol + "req" + "0"
                + getUsername() + "@" + recipient + "@" + message, "athens")[0] + "\n");
    }

    @Override
    public void sendPublicMessage(String message) throws IOException {
        request.writeBytes(security.encrypt(sendMessageProtocol + "req" + "1"
                + getUsername() + "@" + message, "athens")[0] + "\n");
    }

    @Override
    public void changePw() throws IOException {
        request.writeBytes(security.encrypt(changePwProtocol + "req" + getUsername() + "@" + getPw1() + "@" + getPw2(),"athens")[0] + "\n");
    }

    @Override
    public void viewPrivateLogs(String range, String otherUser) throws IOException {
        request.writeBytes(security.encrypt(viewLogsProtocol + "req" + "1" + getUsername() + "@" + getUsername2(), "athens")[0]);
    }

    @Override
    public void viewPublicLogs() throws IOException {
        request.writeBytes(security.encrypt(viewLogsProtocol + "req" + "0" + getUsername() , "athens")[0]+"\n");
    }

    @Override
    public void changeStatus(String status) throws IOException {
        request.writeBytes(security.encrypt(changeStatusProtocol + "req" + getUsername() + "@" + status, "athens")[0]+"\n");
    }

    @Override
    public void forgottenPw(String username) throws IOException {
        request.writeBytes(forgottenPwProtocol + "req" + username);
    }

    @Override
    public void changeNickname(String username, String newNickname) throws SQLException, IOException {
        request.writeBytes(security.encrypt(changeNicknameProtocol + "req" + username + "@" + newNickname,"athens")[0]+"\n");
    }

    private static boolean flag = false;
    private static boolean isChanged = false;

    @Override
    public boolean login(String username, String password) throws IOException, InterruptedException, SQLException {

        Thread loginThread = new Thread(new Runnable() {

            @Override
            public void run() {

                String temp = security.encrypt(loginProtocol + "req" + username + "@" + password, "athens")[0] + "\n";

                try {
                    request.writeBytes(temp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /**
                 * "Login" response
                 * Expected:
                 *      valid user:     "1" + "res" + "1" + userList
                 *      or
                 *      invalid user:   "1" + "res" + "0"
                 */

                try {


                    while ((response = fromServer.readLine()) != null && !isClosed) {

                        response = security.decrypt(response, "athens");

                        // protocol: 1 + 3 = 4 characters: one-character-long ID + "res"
                        String protocol = response.substring(0, 4);

                        // content of the response begins after the 4th character
                        String content = response.substring(4);

                        if (protocol.equals("1" + "res")) {

                            if (content.substring(0, 1).equals("1")) {
                                setUserList(rebuildUserList(content.substring(1)));
                                setUsername(username);
                                setChanged();
                                notifyObservers(userList);

                                for (User u : userList) {
                                    if (u.getUsername().equals(getUsername())) {
                                        nickname = u.getNickname();

                                    }

                                }

                                responseListener.start();
                                currentUser.setUsername(getUsername());
                                currentUser.setNickname(getNickname());
                                currentUser.setStatus(getStatus());

                                flag = true;
                                isChanged = true;

                                System.out.println("set to:" + flag);
                                break;

                            } else if (content.charAt(0) == '0') {
                                System.out.println("Invalid user, login failed.");
                                isChanged = true;
                                break;
                            } else {
                                System.out.println("Unknown error");
                                isChanged = true;
                                break;
                            }

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        isChanged = false;

        loginThread.start();

        while (!isChanged) {
            Thread.sleep(10);
        }

        System.out.println(flag);
        return flag;
    }

    /**
     * Listener thread running continuously listens for responses sent
     * by the server to client requests & handles them.
     */
    Thread responseListener = new Thread(new Runnable() {
        public void run() {

           
                while (!isClosed) {
                    try {
						while ((response = fromServer.readLine()) != null) {

						    System.out.println(response);
						    response = security.decrypt(response, "athens");
						    System.out.println(response);
						    // protocol: 1 + 3 = 4 characters: one-character-long ID + "res"
						    String protocol = response.substring(0, 4);

						    // content of the response begins after the 4th character
						    String content = response.substring(4);


						    switch (protocol) {


						        /**
						         * "User registration" response
						         * Expected:
						         *      database error:             "2" + "res" + 0
						         *      or
						         *      registration successful:    "2" + "res" + 1
						         *      or
						         *      registration failed:        "2" + "res" + 2
						         */
						        case "2" + "res": {

						            if (content.substring(0, 1).equals("0")) {
						                System.out.println("Database error");
						            } else if (content.substring(0, 1).equals("1")) {
						                System.out.println("Registration successful");
						            } else if (content.substring(0, 1).equals("2")) {
						                System.out.println("Registration failed");
						            } else {
						                System.out.println("Unknown error");
						            }
						            break;
						        }

						        /**
						         * "Send message" response
						         * Expected:
						         *      "3" + "res" + username + "@" + message
						         */
						        case "3" + "res": {

						            if (content.charAt(0) == '1' || content.charAt(0) == '0') {

						                String prefix = "[private message] ";

						                ArrayList<Message> currentMessages = new ArrayList<>();

						                String username = content.substring(1).split("@")[0];
						                String timestamp = content.substring(1).split("@")[1];
						                String message = content.substring(1).split("@")[2];


						                for (User u : getUserList()) {
						                    if (u.getUsername().equals(username)) {
						                        currentMessages = getMessagesList();
						                        currentMessages.add(
						                                new Message(
						                                        u.getUsername(),
						                                        u.getNickname(),
						                                        timestamp,
						                                        content.charAt(0) == '1' ?
						                                                message : prefix + message
						                                )
						                        );
						                    }

						                }

						                setMessagesList(currentMessages);
						                setChanged();
						                notifyObservers(messagesList);
						            } else
						                System.out.println("error");
						            break;


						        }

						        /**
						         * "Change password" response
						         * Expected:
						         *      password successfully changed: "4" + "res" + "1"
						         *      or
						         *      database error: password change failed: "4" + "res" + "0"
						         *      or
						         *      authentication failure: password change failed: "4" + "res" + "2"
						         */
						        case "4" + "res": {

						            if (content.substring(0, 1).equals("0")) {
						                System.out.println("Database error. Changing password failed.");
						            } else if (content.substring(0, 1).equals("1")) {
						                System.out.println("Password changed.");
						            } else if (content.substring(0, 1).equals("2")) {
						                System.out.println("Authentication failure. Changing password failed");
						            } else {
						                System.out.println("Unknown error");
						            }
						            break;
						        }

						        /**
						         * "View chat logs" response
						         * Expected:
						         *      view public chat log: "5" + "res" + "0" + publicLog
						         *      or
						         *      view private chat log: "5" + "res" + "1" + privateLog
						         */
						        case "5" + "res": {
						        	ArrayList<Message> loglist=new ArrayList<Message>();
						            if (content.substring(0, 1).equals("0")) {
						            	if(!content.equals("0")){
						            		for(String message:content.substring(1).split("@")){
						            			String username=message.split(":")[0];
						            			String nickname=message.split(":")[1];
						            			String timestamp=message.split(":")[2]+":"+message.split(":")[3]+":"+message.split(":")[4];
						            			String m=message.split(":")[5];
						            			loglist.add(new Message(username,nickname,timestamp,m));
						            		}
						            	}
						            	setChatlog(loglist);
						            	setLogUpdated(true);
						                System.out.println(getChatlog());
						            } else if (content.substring(0, 1).equals("1")) {
						                // PRIVATE CHATLOG
						            } else {
						                System.out.println("Unknown error.");
						            }
						            break;
						        }

						        /**
						         * "Change status" response
						         * Expected:
						         *      "6" + "res" + username + ":" + status
						         */
						        case "6" + "res": {
						            System.out.println(response);
						            if(getUsername().equals(content.split(":")[0]))
						            		setStatus(content.split(":")[1]);
						           
						            for(User u:getUserList()){
						            	if(content.split(":")[0].equals(u.getUsername()))
						            		u.setStatus(content.split(":")[1]);
						            }
						            setChanged();
						            notifyObservers(userList);
						            break;
						        }

						        /**
						         * "Forgotten password recovery" response
						         * Expected:
						         *      email authentication sent: "7" + "res" + "1" + "1" + randomString
						         *      or
						         *      username does not exist, forgotten password recovery failed: "7" + "res" + "1" + "0"
						         *      or
						         *      password changed successfully: "7" + "res" + "2" + "1"
						         *      or
						         *      changing password failed: "7" + "res" + "2" + "0"
						         */
						        case "7" + "res": {
						            if (content.substring(0, 1).equals("1")) {
						                if (content.substring(1, 2).equals("1")) {
						                    System.out.println("Authentication email sent.");
						                } else if (content.substring(1, 2).equals("0")) {
						                    System.out.println("Username does not exist. Forgotten password recovery request failed.");
						                }
						            } else if (content.substring(0, 1).equals("2")) {
						                if (content.substring(1, 2).equals("1")) {
						                    System.out.println("Password changed successfully.");
						                } else if (content.substring(1, 2).equals("0")) {
						                    System.out.println("Changing password failed.");
						                }
						            } else {
						                System.out.println("Unknown error.");
						            }
						            break;
						        }

						        /**
						         * Add/remove user from chat
						         * Expected:
						         *      add user to online users list & update everyone's userList
						         *      "8" + "res" + "1" + username + "@" + database.getNickname(username) + "@" + "Available"
						         *
						         *      or
						         *
						         *      remove user from online users list & update everyone's userList & print "You are
						         *      now offline" in client frame)
						         *      "8" + "res" + "0" + username
						         */
						        case "8" + "res": {
						            if (content.substring(0, 1).equals("1")) {
						            	 ArrayList<User> tmp = new ArrayList<>();
						                 tmp.addAll(getUserList());
						            	
						            	 for (User u : getUserList()) {
						                     if (u.getUsername().equals(content.substring(1).split(":")[0])) {
						                         tmp.remove(u);
						                     }
						                 }
						            	setUserList(tmp);
						                ArrayList<User> current = getUserList();
						                current.add(new User(
						                        content.substring(1).split(":")[0],
						                        content.substring(1).split(":")[1],
						                        content.substring(1).split(":")[2],
						                        null
						                ));

						                setUserList(current);
						                System.out.println(getUserList());

						                setChanged();
						                notifyObservers(userList);

						            } else if (content.substring(0, 1).equals("0")) {

						                ArrayList<User> tmp = new ArrayList<>();
						                tmp.addAll(getUserList());

						                for (User u : getUserList()) {
						                    if (u.getUsername().equals(content.substring(1).split(":")[0])) {
						                        tmp.remove(u);
						                    }
						                }

						                setUserList(tmp);

						                setChanged();
						                notifyObservers(userList);

						               // System.out.println("You are now offline.");
						               // System.exit(1);
						            } else {
						                System.out.println("Unknown error");
						            }
						            break;
						        }

						        /**
						         * "Change nickname" response
						         * Expected:
						         *      (changing nickname successful): "n" + "res" + username + "@" + nickname
						         *      or
						         *      (changing nickname failed): "n" + "res" + "0"
						         */
						        case "n" + "res": {
						            if (!content.substring(0, 1).equals("0")) {
						                getUserList()
						                        .stream()
						                        .filter(u -> u.getUsername().equals(content.split("@")[0]))
						                        .forEach(u -> {
						                            u.setNickname(content.split("@")[1]);
						                        });
						                setChanged();
						                notifyObservers(userList);
						                
						                if(getUsername().equals(content.split("@")[0])){
						                	setNickname(content.split("@")[1]);
						                	System.out.println("nicknamechange");
						                }
						                System.out.println("Nickname changed successfully.");
						            } else {
						                System.out.println("Changing nickname failed.");
						            }
						            break;
						        }

						        /**
						         * Any other response is considered to be an error
						         */
						        case "error" + "res": {
						            System.out.println("Unknown error");
						        }
						    }
						}
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Connection lost!");
						System.exit(0);
					}
                }
          
        }
    });

    /**
     * Reassembles User objects & returns them in an arraylist after
     * being converted to a long String and sent over from the server.
     *
     * @param userlist String containing all users' all info
     * @return arraylist of user objects
     */
    public ArrayList<User> rebuildUserList(String userlist) {
        System.out.println(userlist);
        String[] temp = userlist.split("@");
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            userList.add(new User(
                            temp[i].split(":")[0],
                            temp[i].split(":")[1],
                            temp[i].split(":")[2],
                            null
                    )
            );
        }
        return userList;
    }

    public void closeAll() throws IOException, InterruptedException {
        isClosed = true;

        Thread.sleep(500);

        fromServer.close();
        request.close();
        clientSocket.close();

    }


    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        //Client c = new Client();



    }

	public ArrayList<Message> getChatlog() {
		return Chatlog;
	}

	public void setChatlog(ArrayList<Message> chatlog) {
		Chatlog = chatlog;
	}

	public boolean isLogUpdated() {
		return logUpdated;
	}

	public void setLogUpdated(boolean logUpdated) {
		this.logUpdated = logUpdated;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}



