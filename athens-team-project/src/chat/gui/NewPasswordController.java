package chat.gui;

import chat.Client;
import chat.model.PasswordModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NewPasswordController extends JDialog implements ActionListener{
	
	
	private JLabel oldPassword, newPassword, confirmNewPassword, matchPasswords;
	private JLabel passwordSuccess, passwordFail, passwordError;
	private JPasswordField oldPasswordText, newPasswordText, confirmNewPasswordText;
	private PasswordModel pwmodel;
	private JButton confirm, cancel;
	private int response;
	private Client client;
	
	public NewPasswordController (Client client){
		this.client=client;
		pwmodel = new PasswordModel(client.getHost(),client.getPort());
		this.createGUI();
	}
	
	private void createGUI() {
		
		 try {
//           UIManager.setLookAndFeel(
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//           "javax.swing.plaf.nimbus.NimbusLookAndFeel");

       } catch (ClassNotFoundException |
               UnsupportedLookAndFeelException |
               IllegalAccessException |
               InstantiationException e) {
           e.printStackTrace();
       }
		
		setTitle("Set Password");
		setSize(400, 250);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        Font font = new Font("Verdana", Font.PLAIN, 14);
        
        oldPassword = new JLabel("Current Password");
        oldPassword.setBounds(20, 30, 200, 25);
        oldPassword.setFont(font);
        oldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(oldPassword);

		oldPasswordText = new JPasswordField(20);
		oldPasswordText.setBounds(200, 30, 160, 25);
		getContentPane().add(oldPasswordText);
        
		newPassword = new JLabel("New Password");
		newPassword.setBounds(20, 80, 200, 25);
		newPassword.setFont(font);
		newPassword.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(newPassword);

		newPasswordText = new JPasswordField(20);
		newPasswordText.setBounds(200, 80, 160, 25);
		getContentPane().add(newPasswordText);
		
		
		confirmNewPassword = new JLabel("Confirm New Password");
		confirmNewPassword.setBounds(20, 130, 200, 25);
		confirmNewPassword.setFont(font);
		confirmNewPassword.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(confirmNewPassword);

		confirmNewPasswordText = new JPasswordField(20);
		confirmNewPasswordText.setBounds(200, 130, 160, 25);
		getContentPane().add(confirmNewPasswordText);
		
		matchPasswords = new JLabel("Passwords don't match");
		matchPasswords.setBounds(200, 155, 150,25);
		matchPasswords.setForeground(Color.red);
		matchPasswords.setVisible(false);
		getContentPane().add(matchPasswords);
		
		passwordSuccess = new JLabel("Passwords change successful");
		passwordSuccess.setBounds(200, 155, 150,25);
		passwordSuccess.setForeground(Color.red);
		passwordSuccess.setVisible(false);
		getContentPane().add(passwordSuccess);
		
		passwordFail = new JLabel("Passwords change failed");
		passwordFail.setBounds(200, 155, 150,25);
		passwordFail.setForeground(Color.red);
		passwordFail.setVisible(false);
		getContentPane().add(passwordFail);
		
		passwordError = new JLabel("Error during password change");
		passwordError.setBounds(200, 155, 150,25);
		passwordError.setForeground(Color.red);
		passwordError.setVisible(false);
		getContentPane().add(passwordError);
		
		confirm = new JButton();
		confirmNewPassword.setFont(font);
		confirm.setText("Confirm");
		confirm.setBounds(220, 180, 120, 25);
		confirm.addActionListener(this);
		getContentPane().add(confirm);
		

		cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setBounds(40, 180, 80, 25);
		cancel.addActionListener(this);
		getContentPane().add(cancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm){
			if(!new String(newPasswordText.getPassword()).equals( new String(confirmNewPasswordText.getPassword()))){
				matchPasswords.setVisible(true);
			}
			else {
				try {
				response = pwmodel.changePassword(client.getUsername(), new String(oldPasswordText.getPassword()), new String(newPasswordText.getPassword()));
				}
				catch(IOException f) {}
				
				if (response == 1) {
					JOptionPane.showMessageDialog(this, "Password change successful!");
					this.dispose();
				}
				else if (response == 0) {
					passwordFail.setVisible(true);
				}
				else {
					passwordError.setVisible(true);
				}
			}
		} else if(e.getSource() == cancel){
			dispose();
		}
	}
	
	
	   public void newWindow(Client client) {    
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	NewPasswordController gui = new NewPasswordController (client);
	                gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		            gui.setVisible(true);
	            }
	        });
	    }
	   
	   
	  

}
