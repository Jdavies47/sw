
package chat.gui;

import chat.model.RegisterModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterController extends JDialog implements ActionListener {

	private JLabel universityID, nickname, password, invalidUser, success, fail, error;
	private JTextField universityIDText, nicknameText;
	private JPasswordField passwordText;
	private JButton registerButton;
	private RegisterModel registerModel;
	private int response;

	public RegisterController(RegisterModel registerModel){
		this.registerModel=registerModel;
		this.createGUI();
	}
	
	private void createGUI(){
		
		setTitle("Register Account");
		setSize(400, 250);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        		
		universityID = new JLabel("University ID ");
		universityID.setBounds(40, 30, 100, 25);
		universityID.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(universityID);

		universityIDText = new JTextField(20);
		universityIDText.setBounds(130, 30, 160, 25);
		getContentPane().add(universityIDText);
		
		
		password = new JLabel("Password");
		password.setBounds(40, 80, 100, 25);
		password.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(password);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(130, 80, 160, 25);
		getContentPane().add(passwordText);
		
		invalidUser = new JLabel();
		invalidUser.setText("Invalid User");
		invalidUser.setBounds(130, 180, 160, 25);
		invalidUser.setForeground(Color.red);
		invalidUser.setVisible(false);
		getContentPane().add(invalidUser);
		
		success = new JLabel();
		success.setText("Registration Successful");
		success.setBounds(130, 180, 160, 25);
		success.setForeground(Color.red);
		success.setVisible(false);
		getContentPane().add(success);
		
//		fail = new JLabel();
//		fail.setText("Error connecting to Database");
//		fail.setBounds(30, 180, 160, 25);
//		fail.setForeground(Color.red);
//		fail.setVisible(false);
//		getContentPane().add(fail);
		
		error = new JLabel();
		error.setText("Error during Registration");
		error.setBounds(130, 180, 160, 25);
		error.setForeground(Color.red);
		error.setVisible(false);
		getContentPane().add(error);
			
		nickname = new JLabel("Nickname");
		nickname.setBounds(40, 130, 100, 25);
		nickname.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(nickname);

		nicknameText = new JTextField(20);
		nicknameText.setBounds(130, 130, 160, 25);
		getContentPane().add(nicknameText);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(250, 180, 120, 25);
		registerButton.addActionListener(this);
		getContentPane().add(registerButton);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			String username = universityIDText.getText();
			char[] password = passwordText.getPassword();
			String passwordString="";
			for(char c:password){
				passwordString=passwordString+c;
			}

			String nickname = nicknameText.getText();

			if(universityIDText.getText() == ""){
            JOptionPane.showMessageDialog(this, "Must enter a valid university ID");
            }else if(passwordString == ""){
            JOptionPane.showMessageDialog(this, "Password can't be empty");
            }else if(nicknameText.getText() == ""){
            JOptionPane.showMessageDialog(this, "Nickname can't be empty");
            }else
				try {
					response = registerModel.register(username, nickname, passwordString);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			if (response == 2) {
			  	JOptionPane.showMessageDialog(this, "Invalid User");
			}
			else if (response == 1) {
				JOptionPane.showMessageDialog(this, "Registration successful.");

				this.dispose();
			}
			else if (response == 0) {
				JOptionPane.showMessageDialog(this, "Registration error");
			}
			else {
				error.setVisible(true);
			}	
		}
	}
	
	
	public void newWindow(RegisterModel register) {
		SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
	    	
	    	try{
	    	RegisterController gui = new RegisterController(register);
	        gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        gui.setVisible(true);
	    	}catch(Exception e){
        		e.printStackTrace();
        	}
	    }
		});
    }
}
        