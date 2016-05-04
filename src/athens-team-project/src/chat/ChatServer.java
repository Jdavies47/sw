package chat;

//import AutoEmail;

import chat.database.Database;
import chat.interfaces.DatabaseImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private int PORT; // the port number
    private static List<Socket> list = new ArrayList<Socket>(); // the list to store the sockets
    private ExecutorService exec;
    private ServerSocket server;
    private static DatabaseImpl database;
    private static ChatroomSecurity security;
    private static ArrayList<User> userlist;

    public static void main(String[] args) throws SQLException {
    	try{
        	int port=Integer.parseInt(args[0]);
    		
        	new ChatServer(port);
            
    	}catch(Exception e){
    		System.err.println("<Usage> java -jar Server <Port>");
    	}
        
    }

    public ChatServer(int port) throws SQLException {
    	this.PORT=port;
        database = new Database();
        security = new ChatroomSecurity();
        userlist = new ArrayList<User>();
        try {
        	//InetAddress addr = InetAddress.getByName(host); 
            server = new ServerSocket(port, 1600, InetAddress.getLocalHost());
            
            System.out.println("Listen at "+server.getInetAddress().getHostAddress()+":"+PORT);
            exec = Executors.newCachedThreadPool();
            System.out.println("The Athens Chat server is working!");

            Socket client = null;
            while (true) {
                client = server.accept(); // accept the client request
                if (!list.contains(client))
                    list.add(client);
                exec.execute(new ChatTask(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ChatTask implements Runnable {
        private Socket socket;
        private BufferedReader br;
        private PrintWriter pw;
        private String request;


        public ChatTask(Socket socket) throws IOException {
            this.socket = socket;
            br = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            //get the input stream

        }

        public void run() {
            try {
                while ((request = br.readLine()) != null) {

                    request = security.decrypt(request, "athens");
                    System.out.println(request);
                    String content = request.substring(4);
                    switch (request.substring(0, 4)) {
                    /*
                	 *  login
					 *	SENDS REQUEST: 		"1" + "req" + username +"@"+ password
					 *	EXPECTS RESPONSE: 	valid user:   "1" + "res" + "1" + update_users_list
					 *						invalid user: "1" + "res" + "0"
					 *
					 *	RESPONSE FOR ADDING A USER :"8" + "res" + "1"+ username+":"+nickname+":"+status
                	 */
                        case "1" + "req": {
                            System.out.println(content);
                            String username = content.split("@")[0];
                            String password = content.split("@")[1];
                            System.out.println(username + " , " + password);
                            System.out.println(database.getPwHash(username));
                            boolean isOnline=false;
                            for(User u:userlist){
                            	if(u.getUsername().equals(username))
                            		isOnline=true;
                            }
                            if(isOnline){
                            	response("1" + "res" + "0");//login fail wrong user name or password
                            }
                            else if (database.getPwHash(username).equals(security.Encrypt_SHA1(password))) {
                                //add new user to list
                                userlist.add(new User(username, database.getNickname(username), "Available", socket));

                                //notify all
                                responseAll("8" + "res" + "1" + username + ":" + database.getNickname(username) + ":" + "Available");

                                //return the online list for the client initialization
                                response("1" + "res" + "1" + getUserList());

                            } else {
                                response("1" + "res" + "0");//login fail wrong user name or password
                            }
                            break;
                        }
                	/*
                	 * logoff
					 *	SENDS REQUEST: 		"0" + "req" + username
					 *	EXPECTS RESPONSE: 	none
					 *
					 *  RESPONSE FOR ADDING A USER :    "8" + "res" + "0"+ username
                	 */
                        case "0" + "req": {
                            String username = content;
                            for (int i = 0; i < userlist.size(); i++) {
                                if (userlist.get(i).getUsername().equals(username))
                                    userlist.remove(i);
                            }

                            responseAll("8" + "res" + "0" + username);// notify all that a user is logged out

                            list.remove(socket);
                            //br.close();
                            //pw.close();
                            //socket.close();  //close everything
                            break;
                        }
                	/*
                	 * verifyRegistration
                	 *   SENDS REQUEST: 		"2" + "req" + username+"@"+nickname+"@"+password
                	 *   EXPECTS RESPONSE:   	"2" + "res" + isSuccessful (2 for the invalid user)
                	 *                                                     (1 for success)
                	 *                                                     (0 for database error)
                	 *   ACTION:             check if username has been registered already:
                	 *                       - continue reg if NOT
                	 *                       - deny reg if YES
                	 */

                        case "2" + "req": {
                            String username = content.split("@")[0];
                            String nickname = content.split("@")[1];
                            String password = content.split("@")[2];
                            try {
                                if (database.isValidUser(username)) {
                                    boolean flag = database.createUser(username, nickname, security.Encrypt_SHA1(password));
                                    if (flag) {
                                        response("2" + "res" + "1");
                                        list.remove(socket);
                                    } else
                                        response("2" + "res" + "0");        //database error
                                } else {
                                    response("2" + "res" + "2");//2 for the invalid user
                                }
                            }catch (Exception e){
                                response("2" + "res" + "2");//2 for the invalid user
                            }
                                break;
                            }
                	/*
                	 * sendMessage
					 *	SENDS REQUEST: 		"3" + "req" + "1" + username +"@"+ message  (send message to the public)
					 *                      "3" + "req" + "0" + username +"@"+ username2 +"@"+ message (send message to a person)
					 *
					 *	EXPECTS RESPONSE: 	"3" + "res" + "1" + username +"@"+ message (send message to the public)
					 *						"3" + "res" + "0" + username +"@"+ username2 +"@"+ message (send message to specific person)
					 *	ACTION:		 	    update DB:chatLogs
                	 */
                            case "3" + "req": {
                                char tag = content.charAt(0);
                                content = content.substring(1);
                                if (tag == '1') {
                                    String username = content.split("@")[0];
                                    String message = content.split("@")[1];


                                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");//set time stamp format

                                    responseAll("3" + "res" + "1" + username + "@" + df.format(new Date()) + "@" + message);

                                    database.createPublicChatLog(df.format(new Date()), username, userlist, message);
                                    //handle the fail case later
                                } else {
                                    String sender = content.split("@")[0];
                                    String receiver = content.split("@")[1];
                                    String message = content.split("@")[2];

                                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

                                    //send message to a specific person
                                    responseTo("3" + "res" + "0" + sender + "@" + df.format(new Date()) + "@" + message, getSocket(receiver));
                                    responseTo("3" + "res" + "0" + sender + "@" + df.format(new Date()) + "@" + message, socket);


                                    database.createPrivateChatLog(df.format(new Date()), sender, receiver, message);
                                }


                                break;
                            }
                	/*
                	 *  change password
                	 *  SENDS REQUEST: 		"4" + "req" + username +"@"+ password1 +"@"+ password2
                	 *  EXPECTS RESPONSE: 	"4" + "res" + isSuccessful
                	 *  ACTION:		 	    hash password2 & update DB:userbase
                	 */

                            case "4" + "req": {
                                String username = content.split("@")[0];
                                String pw1 = content.split("@")[1];
                                String pw2 = content.split("@")[2];

                                if (database.getPwHash(username).equals(security.Encrypt_SHA1(pw1))) {
                                    boolean flag = database.changePw(username, security.Encrypt_SHA1(pw2));
                                    if (flag)
                                        response("4" + "res" + "1");
                                    else
                                        response("4" + "res" + "0");//database error
                                } else
                                    response("4" + "res" + "2");//pw1 error
                                break;
                            }

                	/*
                	 *  viewLogs
					 *	SENDS REQUEST: 		"5" + "req" + "0" + username
					 *						"5" + "req" + "1" + username1 + "@" + username2
					 *	EXPECTS RESPONSE:	"5" + "res" + "0||1" + ChatLog
					 *	ACTION:		 	    display chatlog frame & view msgs between user1 & user2
                	 */

                            case "5" + "req": {
                                //chat log for public chat
                                if (content.charAt(0) == '0') {
                                    String username = content.substring(1);
                                    ArrayList<Message> publicLog = database.getAllLog(username);
                                    
                                    response("5" + "res" + "0" + getMessageList(publicLog));
                                }
                                //chat log for private chat
                                else if (content.charAt(0) == '1') {
                                    String username1 = content.split("@")[0];
                                    String username2 = content.split("@")[1];

                                    String privateLog = database.getPrivateLog(username1, username2);

                                    response("5" + "res" + "1" + privateLog);
                                } else
                                    System.out.println("error request!");

                                break;
                            }
                	/*
                	 * changeStatus
                	 * SENDS REQUEST: 		"6" + "req" + username + "@" + status
                	 * EXPECTS RESPONSE:	"6" + "res" + update clients' user list with new status
                	 */
                            case "6" + "req": {
                                String username = content.split("@")[0];
                                String status = content.split("@")[1];


                                for (int i = 0; i < userlist.size(); i++) {
                                    if (userlist.get(i).getUsername().equals(username)){
                                    	if(status.equals("Hidden")&&!userlist.get(i).getStatus().equals("Hidden")){
                                    		userlist.get(i).setStatus(status);
                                        	responseAll("8" + "res" + "0" + username);
                                        	responseTo("8" + "res" + "1" + username + ":" + database.getNickname(username) + ":" + status,socket);
                                        }
                                        else if(!status.equals("Hidden")&&userlist.get(i).getStatus().equals("Hidden")){
                                        	userlist.get(i).setStatus(status);
                                        	responseAll("8" + "res" + "1" + username + ":" + database.getNickname(username) + ":" + status);
                                        }
                                        else{
                                        	userlist.get(i).setStatus(status);
                                        	responseAll("6" + "res" + username + ":" + status);
                                        }
                  
                                    	
                                    }
                                        
                                }
                                
                            }
                	/*
                	 * forgottenPw
					 *	SENDS REQUEST1: 	"7" + "req" + "1" + username first request (user press forget password)
					 *	EXPECTS RESPONSE1: 	"7" + "res" + "1" + isExistUser(1) + randomString
					 *                      "7" + "res" + "1" + isExistUser(0) not a exist user
					 *
					 *  SENDS REQUEST2: 	"7" + "req" + "2" + username + "@" + newPassword (the string is same with email)
					 *
					 *                      "7" + "res" + "2" + "1" change password success
					 *  EXPECTS RESPONSE2:  "7" + "res" + "2" + "0" fali to change password
					 *	ACTION:		 	    generate random string, store it in the frame, send it to username@bham.ac.uk,
				     *  wait for it to be entered in the frame
                	 */
                            case "7" + "req": {
                                if (content.charAt(0) == '1') {
                                    String username = content.substring(1);
                                    System.out.println(username);
                                    if (database.isExistUser(username)) {
                                    	//String randomString=security.randomString(20);
                                    	//System.out.println(randomString);
//                				String randomString=AutoEmail.sendRandomString(username+"@student.bham.ac.uk");
//                				response("7" + "res" + "1" + "1" + randomString);
                                    } else
                                        response("7" + "res" + "1" + "0");
                                } else if (content.charAt(0) == '2') {
                                    String username = content.substring(1).split("@")[0];
                                    String newPw = content.substring(1).split("@")[1];

                                    boolean flag = database.changePw(username, security.Encrypt_SHA1(newPw));
                                    if (flag)
                                        response("7" + "res" + "2" + "1");
                                    else
                                        response("7" + "res" + "2" + "0");//database error
                                } else {
                                }
                                break;
                            }
                	/*
                	 * changeNickname
                	 * SENDS REQUEST: 		"n" + "req" + username + "@" + nickname
                	 * EXPECTS RESPONSE:	"n" + "res" + update clients' user list with new status
                	 *                      "n" + "res" + "0" for error
                	 */
                            case "n" + "req": {
                                String username = content.split("@")[0];
                                String nickname = content.split("@")[1];


                                for (int i = 0; i < userlist.size(); i++) {
                                    if (userlist.get(i).getUsername().equals(username))
                                        userlist.get(i).setNickname(nickname);
                                }
                		boolean flag=database.changeNickname(username, nickname);// change the nickname in the database
                		if(flag)
                			responseAll("n" + "res" + username +"@"+ nickname);//notify the change to all clients
                		else
                                response("n" + "res" + "0");//database error
                                break;
                            }


                            default: {
                                // error response
                                response("error" + "res");
                                break;
                            }

                        }
                    }


                }catch(IOException e){
                	System.out.println("The socket is closed in a unexpected way!");
                    e.printStackTrace();
                }catch(SQLException e){
                	System.out.println("SQL error!");
                    e.printStackTrace();
                }
            }

            /**
             * send the response to all alive socket
             * @param res
             * @throws IOException
             */

        private void responseAll(String res) throws IOException {
            System.out.println(res);
            res = security.encrypt(res, "athens")[0];
            for (User u:userlist) {
            	Socket client=u.getSocket();
                pw = new PrintWriter(client.getOutputStream(), true);
                pw.println(res);
            }
        }

        /**
         * send the response just to the sender socket
         *
         * @param res
         * @throws IOException
         */
        private void response(String res) throws IOException {
            System.out.println(res);
            res = security.encrypt(res, "athens")[0];
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(res);

        }

        /**
         * send the response just to the sender socket
         *
         * @param res
         * @throws IOException
         */
        private void responseTo(String res, Socket socket) throws IOException {
            System.out.println(res);
            res = security.encrypt(res, "athens")[0];
            System.out.println(socket);
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(res);

        }

        private Socket getSocket(String username) {
            for (User u : userlist) {
                if (u.getUsername().equals(username))
                    return u.getSocket();
            }
            return null;
        }


        /**
         * transfer the user list to String type
         *
         * @return
         */
        private String getUserList() {
            String s = "";
            for (User u : userlist) {
                if(!u.getStatus().equals("Hidden"))
                s = s + u.getUsername() + ":" + u.getNickname() + ":" + u.getStatus() + "@";
            }
            return s.substring(0, s.length() - 1);
        }
        private String getMessageList(ArrayList<Message> mlist) {
        	if(mlist.isEmpty())
        		return"";
            String s = "";
            for (Message m : mlist) {
                
                s = s + m.getSenderUsername() + ":" + m.getSenderNickname() + ":" + m.getTimestamp()+ ":"+m.getMessage() + "@";
            }
            return s.substring(0, s.length() - 1);
        }
    }
}