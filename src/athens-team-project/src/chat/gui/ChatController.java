package chat.gui;

import chat.Client;
import chat.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;


public class ChatController extends JFrame implements KeyListener, ActionListener {

    private JButton sendButton;

    private JLabel information;
    private JTextArea chatField;
    private JButton send;
    private String nickname;

    private Client client;

    public ChatController(Client client, String nickname) throws IOException, SQLException {
        this.client = client;
        this.nickname = nickname;
       
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

        setTitle("Private chat");
        setSize(430, 200);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        
        Font font = new Font("Verdana", Font.PLAIN, 14);

        information = new JLabel("Enter message to be sent:");
        information.setBounds(20, 20, 260, 25);
        information.setFont(font);
        getContentPane().add(information);

        chatField = new JTextArea();
        chatField.setBounds(20, 70, 300, 75);
        chatField.setLineWrap(true);
        chatField.setWrapStyleWord(true);
        chatField.addKeyListener(this);
        chatField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("")
                , BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        chatField.requestFocusInWindow();
        getContentPane().add(chatField);

        send = new JButton("Send");
        send.setBounds(330, 70, 80, 75);
        send.addActionListener(this);
        getContentPane().add(send);
       
    }


    public JTextArea getChatField() {
        return chatField;
    }


    public JButton getSendButton() {
        return sendButton;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	 String username = "";
             for (User u : client.getUserList()) {
                 if (u.getNickname().equals(nickname))
                     username = u.getUsername();
             }
             try {
                 client.sendPrivateMessage(username, chatField.getText());
             } catch (IOException e1) {
            	 JOptionPane.showMessageDialog(null, "Connection lost!");
					System.exit(0);
             }
            chatField.setText("");
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void newScreen(String nickname) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {
                    ChatController gui = new ChatController(client, nickname);
                    gui.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	            gui.setVisible(true);
                } catch (Exception e) {
                	JOptionPane.showMessageDialog(null, "Connection lost!");
					System.exit(0);
                }
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		 String username = "";
         for (User u : client.getUserList()) {
             if (u.getNickname().equals(nickname))
                 username = u.getUsername();
         }
         try {
             client.sendPrivateMessage(username, chatField.getText());
         } catch (IOException e1) {
             e1.printStackTrace();
         }
              chatField.setText("");
			}  
}