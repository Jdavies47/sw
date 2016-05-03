package chat.gui;

import chat.model.PasswordModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForgetPasswordController extends JDialog implements ActionListener {
	
	private JLabel usernameLabel, messageLabel, messageLabel1, invalidCode, success, failure, error;
	private JTextField usernameText, generatedCodeText;
	private JButton confirmButton, generateCodeButton;
	private int response;
	private PasswordModel passwordModel;
	
	 public ForgetPasswordController(PasswordModel passwordModel) {
		this.passwordModel=passwordModel;
	    this.createGUI();
	  }
	 
	 private void createGUI() {

			setTitle("Forgotten Password");
			setSize(520, 300);
			setBackground(Color.WHITE);
			setLocationRelativeTo(null);
			setResizable(false);
			getContentPane().setLayout(null);
	      
			usernameLabel = new JLabel();
			usernameLabel.setText("Username");
			usernameLabel.setBounds(40, 30, 200, 25);
			getContentPane().add(usernameLabel);
			
			
			usernameText = new JTextField(20);
			usernameText.setBounds(130, 30, 160, 25);
			getContentPane().add(usernameText);
			
			
			messageLabel = new JLabel();
			messageLabel.setText("Please enter the reset password code that was sent ");
			messageLabel.setVisible(false);
			messageLabel.setHorizontalAlignment(SwingConstants.LEFT);
			messageLabel.setBounds(40, 80, 400, 25);
			getContentPane().add(messageLabel);
			
			
			messageLabel1 = new JLabel();
			messageLabel1.setText("to your email address");
			messageLabel1.setVisible(false);
			messageLabel1.setHorizontalAlignment(SwingConstants.LEFT);
			messageLabel1.setBounds(40, 110, 200, 25);
			getContentPane().add(messageLabel1);
			
			success = new JLabel();
			success.setText("Email with authenticator sent");
			success.setVisible(false);
			success.setBounds(40, 10, 200, 25);
			success.setForeground(Color.red);
			getContentPane().add(success);
			
			failure = new JLabel();
			failure.setText("User does not exist in database");
			failure.setVisible(false);
			failure.setBounds(40, 10, 200, 25);
			failure.setForeground(Color.red);
			getContentPane().add(failure);
			
			error = new JLabel();
			error.setText("Error during database communication");
			error.setVisible(false);
			error.setBounds(40, 10, 200, 25);
			error.setForeground(Color.red);
			getContentPane().add(error);
			
			generatedCodeText = new JTextField(20); 
			generatedCodeText.setBounds(90, 150, 250, 30);
			generatedCodeText.setVisible(false);
			getContentPane().add(generatedCodeText);
			
			invalidCode = new JLabel();
			invalidCode.setText("Invalid Code");
			getContentPane().add(invalidCode);
			
			generateCodeButton = new JButton();
			generateCodeButton.setText("Generate Reset Code");
			generateCodeButton.setBounds(310, 30, 200, 25);
			generateCodeButton.addActionListener(this);
			getContentPane().add(generateCodeButton);
			
			confirmButton = new JButton();
			confirmButton.setText("Confirm");
			confirmButton.setBounds(310, 200, 100, 25);
			confirmButton.addActionListener(this);
			confirmButton.setVisible(false);
			getContentPane().add(confirmButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == generateCodeButton){
			try {
			response = passwordModel.forgetPassword1(usernameText.getText());
			} catch (IOException f) {
				
			}
			
			if (response == 1) {
				messageLabel.setVisible(true);
				messageLabel1.setVisible(true);
				generatedCodeText.setVisible(true);
				success.setVisible(true);
				confirmButton.setVisible(true);
			
			}
			else if (response == 0) {
				failure.setVisible(true);
			}
			else {
				error.setVisible(true);
			}
		}
		else if (e.getSource() == confirmButton) {
			String userInput = generatedCodeText.getText();
			if (passwordModel.authenticationCheck(userInput)) {
			
			ChangePasswordController newGUI = new ChangePasswordController(passwordModel);
				newGUI.newWindow(passwordModel);
				this.dispose();
			
			}
			else {
				invalidCode.setVisible(true);
			}
		}
	}
	
	public  void newScreen(PasswordModel passwordModel) {
		 SwingUtilities.invokeLater(new Runnable() {
	        public void run() {

	        	ForgetPasswordController gui = new ForgetPasswordController(passwordModel);	
	            gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	            gui.setVisible(true);


	    }
	});
	}
}


