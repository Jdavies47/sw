package chat.interfaces;

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
public interface ServerImpl {
    public void updateUserList();
    public void notifyClient(String name);
}
