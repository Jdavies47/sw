package chat.gui;

import chat.model.PasswordModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangePasswordController extends JDialog implements ActionListener{
	
	
	private JLabel newPassword, confirmNewPassword, matchPasswords;
	private JLabel passwordSuccess, passwordFail, passwordError;
	private JPasswordField newPasswordText, confirmNewPasswordText;
	private PasswordModel pwmodel;
	private JButton confirm;
	private int response;
	private PasswordModel model;
	
	public ChangePasswordController(PasswordModel model){
		this.createGUI();
		this.model=model;
	}
	
	private void createGUI() {
		
		setTitle("Set Password");
		setSize(600, 300);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        
		newPassword = new JLabel("New Password");
		newPassword.setBounds(40, 80, 200, 25);
		newPassword.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(newPassword);

		newPasswordText = new JPasswordField(20);
		newPasswordText.setBounds(200, 80, 160, 25);
		getContentPane().add(newPasswordText);
		
		
		confirmNewPassword = new JLabel("Confirm New Password");
		confirmNewPassword.setBounds(40, 130, 200, 25);
		confirmNewPassword.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(confirmNewPassword);

		confirmNewPasswordText = new JPasswordField(20);
		confirmNewPasswordText.setBounds(200, 130, 160, 25);
		getContentPane().add(confirmNewPasswordText);
		
		matchPasswords = new JLabel("Passwords don't match");
		matchPasswords.setBounds(200, 105, 150,25);
		matchPasswords.setForeground(Color.red);
		matchPasswords.setVisible(false);
		getContentPane().add(matchPasswords);
		
		passwordSuccess = new JLabel("Passwords change successful");
		passwordSuccess.setBounds(200, 105, 150,25);
		passwordSuccess.setForeground(Color.red);
		passwordSuccess.setVisible(false);
		getContentPane().add(passwordSuccess);
		
		passwordFail = new JLabel("Passwords change failed");
		passwordFail.setBounds(200, 105, 150,25);
		passwordFail.setForeground(Color.red);
		passwordFail.setVisible(false);
		getContentPane().add(passwordFail);
		
		passwordError = new JLabel("Error during password change");
		passwordError.setBounds(200, 105, 150,25);
		passwordError.setForeground(Color.red);
		passwordError.setVisible(false);
		getContentPane().add(passwordError);
		
		confirm = new JButton();
		confirm.setText("Confirm");
		confirm.setBounds(150, 230, 100, 25);
		confirm.addActionListener(this);
		getContentPane().add(confirm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm){
			char[] a = newPasswordText.getPassword();
			char[] b = confirmNewPasswordText.getPassword();
			
			
			if(!new String(a).equals(new String(b))){
				matchPasswords.setVisible(true);
				 JOptionPane.showMessageDialog(this, "Passwords don't match");
			}
			else {
				try {
				response = model.forgetPassword2(new String(a));
				}
				catch(IOException f) {}
				
				if (response == 1) {
					 JOptionPane.showMessageDialog(this, "Password change successful!");
					 this.dispose();
				}
				else if (response == 0) {
					 JOptionPane.showMessageDialog(this, "Password change failed!");
				}
				else {
					 JOptionPane.showMessageDialog(this, "Error Changing Password");
				}
			}
		}
	}
	
	
	   public void newWindow(PasswordModel model) {    
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	ChangePasswordController gui = new ChangePasswordController(model);
	                gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		            gui.setVisible(true);
	            }
	        });
	    }
	   
	   
//	   public static void main(String[] args) {    
//	        SwingUtilities.invokeLater(new Runnable() {
//	            public void run() {
//	            	ChangePasswordController gui = new ChangePasswordController();
//	                gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		            gui.setVisible(true);
//	            }
//	        });
//	    }

}
