package chat.gui;


import chat.ChatLogManager;
import chat.Client;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class ChatLogController extends JPanel 
{
	
    private JTextArea chatPane;
    private GridBagConstraints gbc;
    private JFrame frame;
    private JLabel chatHistory, user;
    private JComboBox duration;
//    private JButton confirm;
    private JTextField username;
    private Client client;
 
    
   
    public ChatLogController(Client client) throws IOException {
    	this.client=client;

    
        gbc = new GridBagConstraints();
        frame = new JFrame();
        this.createGUI();
        
        
    }

    protected void createGUI() {
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
    	
        setOpaque(true);
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel();
        topPanel.setOpaque(true);
        topPanel.setBackground(Color.WHITE);
        
        user = new JLabel("Username");
        user.setVisible(true);
        username = new JTextField();
        
        chatHistory = new JLabel("Duration");
        String [] times = {"In 30 mins","in 2 hours","Last 6 hrs","Last 12 hrs","Last Day","Last 3 Days","Last Week", "Last Month","Last 3 months", "Last 6 months","All"};
        duration = new JComboBox(times);
        duration.setSelectedIndex(times.length-1);
        
        
        
        duration.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeLog();
			}

        });
        
        username = new JTextField(20);
        username.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent evt) {
        		changeLog();
            }

        });
        
//        confirm = new JButton("Confirm");
//        confirm.addActionListener(this);
        
        topPanel.add(user);
        topPanel.add(username);
        topPanel.add(chatHistory);
        topPanel.add(duration);
       
//        topPanel.add(confirm);
        
        
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        centerPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.weightx = 0.8;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        
        
        
        while(!client.isLogUpdated()){
        	 try {
             	
     			Thread.sleep(100);
     		} catch (InterruptedException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }
       // this.client.setLogUpdated(false);
//        String log="";
//        
//        for(Message s:client.getChatlog()){
//        	log=log+s+"\n";
//        }
        chatPane = new JTextArea(ChatLogManager.print(client.getChatlog()));
        chatPane.setEditable(false);
        JScrollPane scrollerChat = new JScrollPane();
        scrollerChat.setBorder(BorderFactory.createTitledBorder("Chat History"));
        scrollerChat.setViewportView(chatPane);
        centerPanel.add(scrollerChat, gbc);
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        
    }

    public JTextArea getChatPane()
    {
        return chatPane;
    }

    
	
    public void newWindow(Client client) {    
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	try {
        	
         
            	ChatLogController gui = new ChatLogController(client);
            
                gui.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	gui.frame.setLocationRelativeTo(null);
                gui.frame.getContentPane().add(gui);
                gui.frame.pack();
                gui.frame.setSize(600, 600);
                gui.frame.setVisible(true);
                gui.frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        gui.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						gui.frame.dispose();
						e.getWindow().dispose();
						client.setLogUpdated(false);
                       // System.out.println("Closed");
                        e.getWindow().dispose();
                    }
                });
                
            }catch (Exception e) {
            	e.printStackTrace();
            }
        }
        	
        });
    }

	
	public void changeLog() {
		
			
			String durationtime;
			switch(duration.getSelectedIndex()){
			case 0:{
				durationtime="Min:30";
				break;
			}
			case 1:{
				durationtime="H:2";
				break;
			}
			case 2:{
				durationtime="H:6";
				break;
			}
			case 3:{
				durationtime="H:12";
				break;
			}
			case 4:{
				durationtime="D:1";
				break;
			}
			case 5:{
				durationtime="D:3";
				break;
			}
			case 6:{
				durationtime="W:1";
				break;
			}
			case 7:{
				durationtime="M:1";
				break;
			}
			case 8:{
				durationtime="M:3";
				break;
			}
			case 9:{
				durationtime="M:6";
				break;
			}
			default:{
				durationtime="ALL";
				break;
			}
			
			}
			chatPane.setText(ChatLogManager.print(ChatLogManager.getLog(client.getChatlog(),durationtime ,username.getText())));
		
	
		
	}
    
 
//    public static void main(String[] args) {    
//        SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//        	try {
//        	
//         
//            	ChatLogController gui = new ChatLogController();
//            
//                gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            	gui.frame.setLocationRelativeTo(null);
//                gui.frame.getContentPane().add(gui);
//                gui.frame.pack();
//                gui.frame.setSize(600, 600);
//                gui.frame.setVisible(true);
//                
//            }catch (Exception e) {
//            	e.printStackTrace();
//            }
//        }
//        	
//        });
//    }




}