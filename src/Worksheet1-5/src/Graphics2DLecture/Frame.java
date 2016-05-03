package Graphics2DLecture;

import javax.swing.*;

/** 
 *  Example of a class that produces an empty frame.
 *
 *  @version 2015-11-17
 *  @author Manfred Kerber
 */
public class Frame {
    /*
     * Main method to create a panel and put the image on.
     */
    public static void main(String[] args) { 
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 600;
            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates a window of size 800 x 600 pixels
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 
        frame.setVisible(true); // makes the application visible.
    }
}

