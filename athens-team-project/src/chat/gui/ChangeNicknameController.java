package chat.gui;

import chat.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeNicknameController extends JFrame implements ActionListener {

	
	private JLabel newNickname;
	private JTextField newNicknameText;
	private JButton confirmNickname, cancel;
	private Client client;
	
	public ChangeNicknameController(Client client) throws IOException, SQLException{
		
		this.client = client;
		this.createGUI();
	}
	
	
	private void createGUI(){
		
		setName("Change Nickname");
		setSize(400, 150);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        
        Font font = new Font("Verdana", Font.PLAIN, 14);
        
        newNickname = new JLabel("New Nickname");
		newNickname.setBounds(40, 30, 130, 25);
		newNickname.setHorizontalAlignment(SwingConstants.LEFT);
		newNickname.setFont(font);
		getContentPane().add(newNickname);

		newNicknameText = new JTextField(20);
		newNicknameText.setBounds(190, 30, 160, 25);
		getContentPane().add(newNicknameText);
		
		confirmNickname = new JButton();
		confirmNickname.setText("Confirm");
		confirmNickname.setBounds(240, 80, 100, 25);
		confirmNickname.addActionListener(this);
		getContentPane().add(confirmNickname);
		
		
		cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setBounds(40, 80, 80, 25);
		cancel.addActionListener(this);
		getContentPane().add(cancel);
        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String username = client.getUsername();
		if(e.getSource() == confirmNickname){
			try {
				client.setNickname(newNicknameText.getText());
				client.changeNickname(username, newNicknameText.getText());
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			dispose();
		} else if(e.getSource() == cancel){
			dispose();
		}
		
	}
	
	public void newWindow(Client client) {    
		SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
	    	
	    	try{
	    	ChangeNicknameController gui = new ChangeNicknameController(client);
	        gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        gui.setVisible(true);
	    	}catch(Exception e){
        		e.printStackTrace();
        	}
	    }
	    });
	 }
	
}