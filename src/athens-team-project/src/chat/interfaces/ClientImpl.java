package chat.interfaces;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Zsolt Pazmandy on 04/03/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 *
 * JAVA Workshop Group Project 'Athens'
 */
public interface ClientImpl {
    public void sendPrivateMessage(String recipient, String message) throws IOException;
    public void sendPublicMessage(String message) throws IOException;
    public boolean login(String username, String password) throws IOException, InterruptedException, SQLException;
    public void logoff() throws IOException;
    public void verifyRegistration(String username) throws IOException;
    public void changePw() throws IOException;
    public void viewPrivateLogs(String range, String otherUser) throws IOException;
    public void viewPublicLogs() throws IOException;
    public void changeStatus(String status) throws IOException;
    public void forgottenPw(String username) throws IOException;
    public void changeNickname(String username, String newNickname) throws SQLException, IOException;
}
