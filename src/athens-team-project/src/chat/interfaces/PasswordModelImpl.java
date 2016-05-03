package chat.interfaces;

import java.io.IOException;

/**
 * Created by Zsolt Pazmandy
 * 1600690 / zxp590
 * University of Birmingham
 * Computer Science MSc 2015/16
 * on 04/03/16.
 */
public interface PasswordModelImpl {
    
    public boolean authenticationCheck(String userString);
    
    public int forgetPassword1(String username) throws IOException;
    
    public int forgetPassword2(String newPassword) throws IOException;
}
