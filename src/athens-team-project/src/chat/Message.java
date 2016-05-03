package chat;

/**
 * Created by Zsolt Pazmandy on 17/03/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class Message {

    private String senderUsername;
    private String senderNickname;
    private String timestamp;
    private String message;

    public Message(String senderUsername, String senderNickname, String timestamp, String message){
        this.senderUsername = senderUsername;
        this.senderNickname = senderNickname;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "senderUsername='" + senderUsername + '\'' +
                ", senderNickname='" + senderNickname + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
