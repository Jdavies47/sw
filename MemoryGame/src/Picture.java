import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;

public class Picture extends JPanel {
	private String image;
	private int xPos;
	private int yPos;
	private String caption;

	// const
	public Picture(String image, int xPos, int yPos, String caption) {
		this.image = image;
		this.xPos = xPos;
		this.yPos = yPos;
		this.caption = caption;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(loadImage(image), xPos, yPos, null);
		setFont(new Font("Monospace", 1, 12));
		g.drawString(caption, 10, 10);
	}

	private BufferedImage loadImage(String name) {
		String imgFileName = name;
		URL url = Picture.class.getResource(imgFileName);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("File " + name + " not found.");
		}
		return img;
	}

	public static void main(String[] args) {
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 600;
		
		Picture panel = new Picture("0.jpg", 0, 0, "");
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.add(panel);
		frame.setVisible(true);
		
		Picture panel1 = new Picture("1.jpg", 500, 500, "");
		JFrame frame1 = new JFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.add(panel1);
		frame1.setVisible(false);
		
		Picture panel2 = new Picture("2.jpg", 800, 800, "");
		JFrame frame2 = new JFrame();
		frame2.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel2);
		frame2.setVisible(false);
	}
}
