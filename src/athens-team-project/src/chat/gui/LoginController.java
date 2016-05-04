package chat.gui;

import chat.Client;
import chat.model.PasswordModel;
import chat.model.RegisterModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController extends JDialog implements ActionListener {

    private JButton forgottenPasswordButton, loginButton, registerButton;
    private JLabel usernameLabel, usernameErrorLabel, passwordLabel,
            passwordErrorLabel, emptyFieldsLabel, emptyUsername, emptyPassword;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private Client client;
    
    private String host;
    private int port;


    public LoginController(Client client) throws IOException, SQLException {
        this.client=client;
        
        setHost(client.getHost());
        setPort(client.getPort());
        
        this.createGUI();
    }

    private void createGUI() {


        try {
//            UIManager.setLookAndFeel(
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            "javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (ClassNotFoundException |
                UnsupportedLookAndFeelException |
                IllegalAccessException |
                InstantiationException e) {
            e.printStackTrace();
        }

        setTitle("Login");
        setSize(320, 400);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        
        Font font = new Font("Verdana", Font.PLAIN, 14);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20, 180, 160, 25);
        usernameLabel.setFont(font);
        getContentPane().add(usernameLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(110, 180, 180, 25);
        getContentPane().add(usernameText);

        usernameErrorLabel = new JLabel("Incorrect Username");
        usernameErrorLabel.setBounds(130, 160, 200, 15);
        usernameErrorLabel.setVisible(false);
        usernameErrorLabel.setForeground(Color.red);
        getContentPane().add(usernameErrorLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 230, 160, 25);
        passwordLabel.setFont(font);
        getContentPane().add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(110, 230, 180, 25);
        getContentPane().add(passwordText);

        passwordErrorLabel = new JLabel("Incorrect User Password");
        passwordErrorLabel.setBounds(130, 210, 200, 15);
        passwordErrorLabel.setVisible(false);
        passwordErrorLabel.setForeground(Color.red);
        getContentPane().add(passwordErrorLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(210, 290, 80, 25);
        loginButton.addActionListener(this);
        loginButton.isDefaultCapable();
        loginButton.isDefaultButton();
        getContentPane().add(loginButton);

        forgottenPasswordButton = new JButton("Forgotten Password");
        forgottenPasswordButton.setBounds(20, 290, 180, 25);
        forgottenPasswordButton.addActionListener(this);
        getContentPane().add(forgottenPasswordButton);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(120, 330, 100, 25);
        registerButton.addActionListener(this);
        getContentPane().add(registerButton);

        emptyFieldsLabel = new JLabel("Both username and password can not be empty!");
        emptyFieldsLabel.setBounds(40, 265, 300, 15);
        emptyFieldsLabel.setVisible(false);
        emptyFieldsLabel.setForeground(Color.red);
        getContentPane().add(emptyFieldsLabel);

        emptyUsername = new JLabel("Please enter a username!");
        emptyUsername.setBounds(120, 210, 200, 15);
        emptyUsername.setVisible(false);
        emptyUsername.setForeground(Color.red);
        getContentPane().add(emptyUsername);
        
        emptyPassword = new JLabel("Please enter a password!");
        emptyPassword.setBounds(120, 265, 200, 15);
        emptyPassword.setVisible(false);
        emptyPassword.setForeground(Color.red);
        getContentPane().add(emptyPassword);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameText.getText();
            char[] p = passwordText.getPassword();
            String password = new String(p);
            
            if (username.equals("") && password.equals("")) {
            	JOptionPane.showMessageDialog(this, "Username and Password can't be empty");
          } else if (username.equals("")) {
        	  	JOptionPane.showMessageDialog(this, "Username can't be empty");
          } else if (password.equals("")) {
        	  	JOptionPane.showMessageDialog(this, "Password can't be empty");
          } else 
        	  try {

                  System.out.println(username + ", " + password);
            if (client.login(username, password) == true) {
                ClientController newGUI = new ClientController(client);
                this.dispose();
            	newGUI.newScreen();
            } else {
                JOptionPane.showMessageDialog(this, "Login failed.");
                usernameText.setText("");
                passwordText.setText("");
            }
        	  }catch(Exception f){
        		  f.printStackTrace();
        	  }

    	} else if(e.getSource() == forgottenPasswordButton){
    		 try {
    			 PasswordModel passwordModel=new PasswordModel(getHost(),getPort()) ;
    			ForgetPasswordController newGUI = new ForgetPasswordController( passwordModel);
    			newGUI.newScreen( passwordModel);
    		  }catch(Exception g){
        		  g.printStackTrace();
        	  }
    	} else if(e.getSource() == registerButton){
    		try {
                RegisterModel r=new RegisterModel(getHost(),getPort());
    			RegisterController newGUI = new RegisterController(r);
    			newGUI.newWindow(r);
    		 }catch(Exception h){
      		  h.printStackTrace();
      	  }
    	}
    }
    

    public static void main(String[] args) {
    	
    	
		 SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	try{
	        		String host =args[0];
	            	int port=Integer.parseInt(args[1]);
	        		
                    Client c=new Client(host,port);
                    LoginController gui = new LoginController(c);
                    gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    gui.setVisible(true);
	        	}catch(Exception e){
	        		System.err.println("<Usage> java -jar Client <Host IP> <Port>");
	        	}
	        }
		 });
		}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
