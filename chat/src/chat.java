/**
 * Created by zsolt on 19/02/16.
 */
public class chat extends JFrame{

    private JPanel messagesPanel = new JPanel();
    private JPanel usersPanel = new JPanel();
    private JTextArea messages = new JTextArea("messages appear here");
    private JTextArea users = new JTextArea("users list");

    public chat(){
        this.setLayout(new BorderLayout());
        this.setSize(700, 400);
        this.setLocation(400, 200);
        this.setTitle("Chat");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(messagesPanel, BorderLayout.CENTER);
        messagesPanel.setLayout(new BorderLayout());
        messagesPanel.add(messages, BorderLayout.CENTER);
        messages.setBackground(Color.white);

        add(usersPanel, BorderLayout.LINE_END);
        usersPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        usersPanel.add(users, BorderLayout.CENTER);
        usersPanel.setSize(120, 300);
        users.setBackground(Color.black);


    }

    public static void main(String[] args) {
        chat chat = new chat();
    }
}
