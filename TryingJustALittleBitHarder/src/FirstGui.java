public class FirstGui extends JFrame {
	
	private JLabel label;
	private JButton button;
	private JTextField textfield;
	
	public FirstGui() {
		setLayout(new FlowLayout());
		
		label = new JLabel("Hi, I am a label");
		add(label);
		
		textfield = new JTextField(15);
		add(textfield);
		
		button = new JButton("CLICK ME!!!");
		add(button);
	}
	
	public static void main(String[] args) {
		FirstGui gui = new FirstGui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setSize(200, 125);
		gui.setTitle("Title");
	}

}
