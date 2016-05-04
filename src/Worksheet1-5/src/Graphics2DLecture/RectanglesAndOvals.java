package Graphics2DLecture;

import javax.swing.*;
import java.awt.*;

/**
 *  Class to display some Rectangles and Ovals
 *
 *  @version 2015-11-16
 *  @author Manfred Kerber
 */
public class RectanglesAndOvals extends JPanel {
    public RectanglesAndOvals() {}
    
    @Override
    /**
     *    Override the paintComponent method from the JPanel class.  
     *    Some rectangles and ovals are put on the panel.
     *    @param g The graphics component used for painting.
     */
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawOval(100,0,20,30);
	g.fillOval(100,50,20,30);
	g.drawRect(100,100,20,30);
	g.setColor(new Color(255,0,0)); // Red
	g.fillRect(100,150,20,30);
	g.setColor(new Color(0,255,0)); // Green
	g.fillRect(100,200,20,30);
	g.setColor(new Color(0,0,255)); // Blue
	g.fillRect(100,250,20,30);
    }

    /*
     *  We create a frame with a panel on which we draw the different objects.
     */
    public static void main(String[] args){ 
        RectanglesAndOvals panel =  new RectanglesAndOvals();

        JFrame frame = new JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	final int FRAME_WIDTH = 800;
	final int FRAME_HEIGHT = 600;

	frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 
	//creates a window of size 800 x 600 pixels
	frame.add(panel); 
	frame.setVisible(true); // makes the application visible.
    }
}

