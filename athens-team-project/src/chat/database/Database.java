package chat.database;

import chat.Message;
import chat.User;
import chat.interfaces.DatabaseImpl;

import java.util.ArrayList;

/**
 * Created by Zsolt Pazmandy on 09/03/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 * <p>
 * JAVA Workshop Group Project 'Athens'
 * Database functions for Chat Application
 */
public class Database implements DatabaseImpl {

    private SetUpDBConnection setup;
    private Connection connection;

    public Database() throws SQLException {
        setup = new SetUpDBConnection(connection);
        setup.initiate();
    }

    @Override
    public String getNickname(String username) throws SQLException {
        PreparedStatement query = null;

        try {
            query = setup.getConnection().prepareStatement(
                    "SELECT nickname FROM athens_messenger.registered WHERE username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query.setString(1, username);

        ResultSet results = query.executeQuery();

        while (results.next()) {
            return results.getString(1);
        }
        return "#";
    }

    @Override
    public String getPwHash(String username) throws SQLException {
        PreparedStatement query = null;

        try {
            query = setup.getConnection().prepareStatement(
                    "SELECT pw_hash FROM athens_messenger.registered WHERE username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query.setString(1, username);

        ResultSet results = query.executeQuery();

        while (results.next()) {
            return results.getString(1);
        }
        return "#";
    }

    @Override
    public String getLog(String username, Time time) {
        return null;
    }

    @Override
    public boolean isValidUser(String username) throws SQLException {
        PreparedStatement query = null;

        try {
            query = setup.getConnection().prepareStatement(
                    "SELECT usernames FROM athens_messenger.usernames WHERE usernames = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query.setString(1, username);

        ResultSet results = query.executeQuery();

        if (results.next() && results.getString(1).equals(username)) {
            return true;
        } else return false;

    }

    @Override
    public boolean createUser(String username, String nickname, String pwHash) throws SQLException {

        if (!isExistUser(username)) {

            PreparedStatement query = setup.getConnection().prepareStatement(
                    "SELECT username FROM athens_messenger.registered WHERE username = ?");
            query.setString(1, username);
            ResultSet results = query.executeQuery();

            PreparedStatement insert = setup.getConnection().prepareStatement(
                    "INSERT INTO athens_messenger.registered VALUES(?,?,?)"
            );
            insert.setString(1, username);
            insert.setString(2, nickname);
            insert.setString(3, pwHash);
            insert.executeUpdate();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean createPrivateChatLog(String timestamp, String sender, String recipient, String message) throws SQLException {

        String msg_id = sender + "@" + timestamp;

        PreparedStatement update = null;

        update = setup.getConnection().prepareStatement(
                "INSERT INTO athens_messenger.messages VALUES(?,?)"
        );

        update.setString(1, msg_id);
        update.setString(2, message);
        update.executeUpdate();

        update = null;

        update = setup.getConnection().prepareStatement(
                "INSERT INTO athens_messenger.accessto VALUES(?,?)"
        );

        update.setString(1, sender);
        update.setString(2, msg_id);

        update.executeUpdate();

        update.setString(1, recipient);
        update.setString(2, msg_id);

        update.executeUpdate();


        return false;
    }

    @Override
    public boolean createPublicChatLog(String timestamp, String sender, ArrayList<User> userList, String message) throws SQLException {
        String msg_id = sender + "@" + timestamp;

        PreparedStatement update = null;

        update = setup.getConnection().prepareStatement(
                "INSERT INTO athens_messenger.messages VALUES(?,?)"
        );

        update.setString(1, msg_id);
        update.setString(2, message);
        update.executeUpdate();

        for (User u : userList) {

            update = setup.getConnection().prepareStatement(
                    "INSERT INTO athens_messenger.accessto VALUES(?,?)"
            );

            update.setString(1, u.getUsername());
            update.setString(2, msg_id);
            update.executeUpdate();

        }
        return false;
    }

    @Override
    public boolean changePw(String username, String newPW) throws SQLException {
        PreparedStatement update = null;

        try {
            update = setup.getConnection().prepareStatement(
                    "UPDATE athens_messenger.registered SET pw_hash=? WHERE username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        update.setString(1, newPW);
        update.setString(2, username);
        update.executeUpdate();

        PreparedStatement query = null;

        try {
            query = setup.getConnection().prepareStatement(
                    "SELECT pw_hash FROM athens_messenger.registered WHERE username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query.setString(1, username);
        ResultSet result = query.executeQuery();

        if (result.next()) {
            if (newPW.equals(result.getString(1))) {
                return true;
            }
            return false;
        } else return false;
    }

    @Override
    public String getPublicLog(String username) {
        return null;
    }

    @Override
    public String getPrivateLog(String username1, String username2) {
        return null;
    }

    @Override
    public ArrayList<Message> getAllLog(String username) throws SQLException {

        ArrayList<Message> allMsgs = new ArrayList<>();

        PreparedStatement query = setup.getConnection().prepareStatement(
                "SELECT M.msg_id " +
                        "FROM athens_messenger.accessto A " +
                        "INNER JOIN athens_messenger.messages M " +
                        "ON (A.msg_id=M.msg_id) " +
                        "WHERE A.username=?"
        );
        query.setString(1, username);
        ResultSet result = query.executeQuery();

        ArrayList<String> msgIDs = new ArrayList<>();

        while (result.next()) {
            msgIDs.add(result.getString(1));
        }

        for (String id : msgIDs) {
            String u = id.split("@")[0];
            String t = id.split("@")[1];
            String n = getNickname(u);

            PreparedStatement queryTheMsg = setup.getConnection().prepareStatement(
                    "SELECT M.message FROM athens_messenger.messages M WHERE M.msg_id=?"
            );
            queryTheMsg.setString(1, id);
            ResultSet msg = queryTheMsg.executeQuery();
            String m = "";

            while (msg.next()) {
                m = msg.getString(1);
            }
            allMsgs.add(new Message(u, n, t, m));
        }
        return allMsgs;
    }

    @Override
    public boolean isExistUser(String username) throws SQLException {


        PreparedStatement query = setup.getConnection().prepareStatement(
                "SELECT username FROM athens_messenger.registered WHERE username = ?");
        query.setString(1, username);
        ResultSet results = query.executeQuery();
        if (results.next()) {
            if (!results.getString(1).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public boolean changeNickname(String username, String newNickname) throws SQLException {
        PreparedStatement update = setup.getConnection().prepareStatement(
                "UPDATE athens_messenger.registered SET nickname=? WHERE username = ?");

        update.setString(1, newNickname);
        update.setString(2, username);
        update.executeUpdate();

        PreparedStatement query = setup.getConnection().prepareStatement(
                "SELECT nickname FROM athens_messenger.registered WHERE username=?");

        query.setString(1, username);
        ResultSet result = query.executeQuery();

        if (result.next()) {
            if (result.getString(1).equals(newNickname)) {
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    // USE THIS TO REGENERATE USERS TABLE IN DB IF MESSED UP
    public static void main(String[] args) throws SQLException {
        Database d = new Database();
//        ChatroomSecurity sec = new ChatroomSecurity();

//        UserReg u = new UserReg();
//        for(String user : u.CSusers){
//            System.out.println(user);
//            PreparedStatement insert = d.setup.getConnection().prepareStatement(
//                    "INSERT INTO athens_messenger.usernames (usernames) VALUES (?)");
//            insert.setString(1, user);
//            int results = insert.executeUpdate();
//
//        }

//        System.out.println(d.getPwHash("gew580"));
//        d.createUser("zxp590", "zsolt", sec.Encrypt_SHA1("password"));

        System.out.println(d.getAllLog("wxh575"));

    }
}
