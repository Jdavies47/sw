package chat.gui;

import chat.Client;
import chat.Message;
import chat.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class ClientController extends JPanel implements KeyListener, MouseListener, Observer {

    private JButton editProfileButton,chatHistoryButton;
    private JButton sendButton;
    private JLabel welcomeMessage;
    private JTextArea chatPane;
    private JList namePane;
    private JTextArea chatField;
    private Client client;

    private GridBagConstraints gbc;
    private JFrame frame;

    private String nickname;

    public ClientController(Client client) throws IOException, SQLException {
        this.client = client;
        gbc = new GridBagConstraints();
        frame = new JFrame();
        this.nickname = client.getNickname();
        this.createGUI();
        client.addObserver(this);
    }

    protected void createGUI() {
        setOpaque(true);
        setLayout(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setOpaque(true);
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Font font = new Font("Arial", Font.PLAIN, 20);
        welcomeMessage = new JLabel();
        welcomeMessage.setFont(font);
        welcomeMessage.setText("");
        welcomeMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        welcomeMessage.setBounds(20, 20, 500, 50);

        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        editProfileButton = new JButton("Settings");
        editProfileButton.setVisible(true);
        editProfileButton.setBounds(520, 580, 60, 50);

        editProfileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsController gui = new SettingsController(client);
                gui.newWindow(client);
            }
        });


        chatHistoryButton = new JButton("Chat History");
        chatHistoryButton.setVisible(true);
        chatHistoryButton.setBounds(600, 580, 60, 50);
        
        chatHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                ChatLogController gui;
				try {
					client.viewPublicLogs();
					gui = new  ChatLogController(client);
					gui.newWindow(client);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection lost!");
					System.exit(0);
				}
               
            }
        });

        topLeftPanel.add(welcomeMessage);
        topRightPanel.add(editProfileButton);
        topRightPanel.add(chatHistoryButton);
        topPanel.add(topLeftPanel);
        topPanel.add(topRightPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        centerPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        chatPane = new JTextArea();
        chatPane.setEditable(false);
        JScrollPane scrollerChat = new JScrollPane();
        scrollerChat.setBorder(BorderFactory.createTitledBorder("CS Chat Lobby"));
        scrollerChat.setViewportView(chatPane);
        centerPanel.add(scrollerChat, gbc);

        gbc.gridx = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 0.2;
        ArrayList<User> userlist = client.getUserList();
        String[] users = new String[userlist.size()];
        for (int i = 0; i < userlist.size(); i++) {
            users[i] = userlist.get(i).getNickname() + " (" + userlist.get(i).getStatus() + ")";
        }
        namePane = new JList(users);
        welcomeMessage.setText(client.getNickname()+" ("+client.getStatus()+") ");
        namePane.setBackground(new Color(214, 217, 223));
        namePane.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {

                    
                    int index = list.locationToIndex(evt.getPoint());
                    String recipient = "";
                    ChatController newGUI = null;
                    try {
                        recipient = ((String) namePane.getSelectedValue()).split(" ")[0];
                        if(!recipient.equals(nickname)){
                        	newGUI = new ChatController(client, recipient);
                            newGUI.newScreen(recipient);
                        }
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                   
                } else if (evt.getClickCount() == 3) {

                  
                    int index = list.locationToIndex(evt.getPoint());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {


            }

            @Override
            public void mouseEntered(MouseEvent e) {


            }

            @Override
            public void mouseExited(MouseEvent e) {


            }
        });


        JScrollPane scrollerName = new JScrollPane(namePane);
        scrollerName.setBorder(BorderFactory.createTitledBorder("Online users"));
        centerPanel.add(scrollerName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.weightx = 0.8;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 10, 10);
        chatField = new JTextArea(2, 20);
        chatField.setLineWrap(true);
        chatField.setWrapStyleWord(true);
        JScrollPane scrollerChatArea = new JScrollPane(chatField);
        chatField.setOpaque(true);
        chatField.addKeyListener(this);
        chatField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("")
                , BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        centerPanel.add(scrollerChatArea, gbc);
        chatField.requestFocusInWindow();


        gbc.gridx = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 0.2;
        gbc.insets = new Insets(10, 0, 10, 0);
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.sendPublicMessage(chatField.getText());
                } catch (IOException e1) {
                	JOptionPane.showMessageDialog(null, "Connection lost!");
					System.exit(0);
                }
                chatField.setText("");
            }
        });
        sendButton.setBorder(BorderFactory.createTitledBorder(""));
        centerPanel.add(sendButton, gbc);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);


    }

    public JTextArea getChatPane() {
        return chatPane;
    }

    public JList getNamePane() {
        return namePane;
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
            try {
                if (chatField.getText().length() != 0) {
                    client.sendPublicMessage(chatField.getText());
                    chatField.setText("");
                }

            } catch (IOException e1) {
            	JOptionPane.showMessageDialog(null, "Connection lost!");
				System.exit(0);
            }
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void update(Observable o, Object arg) {
    	  if (arg instanceof String&&client.equals(o)) {
    		  String s = (String) arg;
    		  if(s.equals("Available")||s.equals("Busy")||s.equals("Hidden")){
    			  welcomeMessage.setText(client.getNickname() + " (" + s + ")");
    		  }
    		  else{
    			  welcomeMessage.setText(s + " (" + client.getStatus() + ")");
    		  }            
             
          }
    	  else{
    	
        java.util.List list = (ArrayList) arg;
        if (o instanceof Client && list.size() != 0&&client.equals(o)) {

            System.out.println(arg);

            if (list.get(0) instanceof Message) {
                ArrayList<Message> msglist = (ArrayList<Message>) arg;

                String messageBox = "";
                for (Message m : msglist) {
                    String time = m.getTimestamp().split(" ")[1].substring(0, 5);
                    messageBox = messageBox + m.getSenderNickname() + " (" +
                            time + "): " + m.getMessage() + "\n";
                }
                chatPane.setText(messageBox);
            }

            if (list.get(0) instanceof User) {
                ArrayList<User> userlist = (ArrayList<User>) arg;

                String[] users = new String[userlist.size()];
                for (int i = 0; i < userlist.size(); i++) {
                    users[i] = userlist.get(i).getNickname() + " (" + userlist.get(i).getStatus() + ")";
                }
                namePane.setListData(users);
            }
        }
          
        }

    }

    public void newScreen() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {

                    ClientController gui = new ClientController(client);

                    gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gui.frame.setLocationRelativeTo(null);
                    gui.frame.getContentPane().add(gui);
                    gui.frame.pack();
                    gui.frame.setSize(800, 600);
                    gui.frame.setVisible(true);
                    gui.frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            try {
                                gui.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                gui.frame.dispose();
                                e.getWindow().dispose();
                                client.logoff();
                                Thread.sleep(500);
                                client.closeAll();
                            } catch (IOException e1) {
                            	JOptionPane.showMessageDialog(null, "Connection lost!");
        						System.exit(0);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            System.out.println("Closed");
                            e.getWindow().dispose();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}

	 