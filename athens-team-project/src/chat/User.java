package chat;

import java.net.Socket;

public class User {
    private String username;
    private String nickname;
    private String status;
    private Socket socket;

    public User(String username, String nickname, String status, Socket client) {
        this.setUsername(username);
        this.setNickname(nickname);
        this.setStatus(status);
        this.setSocket(client);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return username + ", " + nickname + ", " + getStatus();
    }
}
