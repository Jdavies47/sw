package chat.gui;

import chat.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SettingsController extends JFrame implements ActionListener{
	
	private JComboBox status;
	private JLabel setStatus;
	private JButton changePassword,changeNickname,confirm, cancel;
	private Client client;
	
	
	public SettingsController(Client client){
		this.client=client;
		this.createGUI();
	}

	public void createGUI(){
		
		try {
//          UIManager.setLookAndFeel(
                  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//          "javax.swing.plaf.nimbus.NimbusLookAndFeel");

      } catch (ClassNotFoundException |
              UnsupportedLookAndFeelException |
              IllegalAccessException |
              InstantiationException e) {
          e.printStackTrace();
      }

		setTitle("Settings");
        setSize(320, 300);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        
        Font font = new Font("Verdana", Font.PLAIN, 14);

        setStatus = new JLabel("Status");
        setStatus.setBounds(20, 150, 160, 25);
        setStatus.setFont(font);
        getContentPane().add(setStatus);

        String statusOptions[] = {"Available", "Busy","Hidden"};
        status = new JComboBox(statusOptions);
        status.setBounds(110, 150, 180, 25);
        if(client.getStatus().equals("Available"))
        	status.setSelectedIndex(0);
        else if(client.getStatus().equals("Busy"))
        	status.setSelectedIndex(1);
        else
        	status.setSelectedIndex(2);
        status.addActionListener(this);
        getContentPane().add(status);
        
        
        changePassword = new JButton("Change Password");
        changePassword.setBounds(50, 30, 180, 25);
        changePassword.addActionListener(this);
        changePassword.setFont(font);
        getContentPane().add(changePassword);

        changeNickname = new JButton("Change Nickname");
        changeNickname.setBounds(50, 80, 180, 25);
        changeNickname.addActionListener(this);
        changeNickname.setFont(font);
        getContentPane().add(changeNickname);
        
        confirm = new JButton();
        confirm.setText("Confirm");
        confirm.addActionListener(this);
        confirm.setFont(font);
        confirm.setBounds(170, 200, 120, 25);
        getContentPane().add(confirm);
        
    	cancel = new JButton();
		cancel.setText("Cancel");
		cancel.setFont(font);
		cancel.setBounds(40, 200, 80, 25);
		cancel.addActionListener(this);
		getContentPane().add(cancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == changePassword){
			try {
				System.out.println("wwww");
			NewPasswordController newGUI = new NewPasswordController(client);
		    	newGUI.newWindow(client);
		    }catch(Exception f){
		    	JOptionPane.showMessageDialog(null, "Connection lost!");
				System.exit(0);
		    }
		} else if(e.getSource() == changeNickname){
			try {
				ChangeNicknameController newGUI = new ChangeNicknameController(client);
			    	newGUI.newWindow(client);
			    }catch(Exception f){
			    	JOptionPane.showMessageDialog(null, "Connection lost!");
					System.exit(0);
			    }
		} else if(e.getSource() == confirm){
			System.out.println("wwww");
			String statusSSS = (String)status.getSelectedItem();
			
			try {
				client.setStatus(statusSSS);
				client.changeStatus(statusSSS);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Connection lost!");
				System.exit(0);
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
	            SettingsController gui = new SettingsController(client);
	            gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	            gui.setVisible(true);
	        	}catch(Exception e){
	        		JOptionPane.showMessageDialog(null, "Connection lost!");
					System.exit(0);
	        	}
	        }
		 });
		}
	
	
	
//	public static void main(String[] args) {
//		 SwingUtilities.invokeLater(new Runnable() {
//	        public void run() {
//	        	try{
//	            SettingsController gui = new SettingsController();
//	            gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//	            gui.setVisible(true);
//	        	}catch(Exception e){
//	        		e.printStackTrace();
//	        	}
//	        }
//		 });
//		}
}

