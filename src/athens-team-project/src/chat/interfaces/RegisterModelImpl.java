package chat.interfaces;

import java.io.IOException;

/**
 * Created by Zsolt Pazmandy
 * 1600690 / zxp590
 * University of Birmingham
 * Computer Science MSc 2015/16
 * on 04/03/16.
 */
public interface RegisterModelImpl {
    public int register(String username, String nickname, String newpassword) throws IOException;
}
