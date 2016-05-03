package lookFeel;

// Fig. 22.10: LookAndFeelDemo.java
// Changing the look-and-feel.
import javax.swing.*;

public class LookAndFeelDemo {
	public static void main(String[] args) {
		LookAndFeelFrame lookAndFeelFrame = new LookAndFeelFrame();
		lookAndFeelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lookAndFeelFrame.setSize(400, 220);
		lookAndFeelFrame.setVisible(true);
	}
} // end class LookAndFeelDemo