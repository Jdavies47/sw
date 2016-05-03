package chat.interfaces;

import chat.Message;
import chat.User;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Zsolt Pazmandy
 * 1600690 / zxp590
 * University of Birmingham
 * Computer Science MSc 2015/16
 * on 04/03/16.
 */
public interface DatabaseImpl {
    public String getNickname(String username) throws SQLException;

    public String getPwHash(String username) throws SQLException;

    public String getLog(String username, Time time);

    public boolean isValidUser(String username) throws SQLException;

    public boolean createUser(String username, String nickname, String pwHash) throws SQLException;

    public boolean createPrivateChatLog(String timestamp, String sender, String recipient, String message) throws SQLException;

    public boolean createPublicChatLog(String timestamp, String sender, ArrayList<User> userList, String message) throws SQLException;

    public boolean changePw(String username, String newPW) throws SQLException;

    public String getPublicLog(String username);

    public String getPrivateLog(String username1, String username2);

    public ArrayList<Message> getAllLog(String username) throws SQLException;

    public boolean isExistUser(String username) throws SQLException;

    public boolean changeNickname(String username, String newNickname) throws SQLException;
}