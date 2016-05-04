package Graphics2DLecture;

import javax.swing.*;
import java.awt.*;

/**
 *  Class to display an empty ChessBoard.
 *
 *  @version 2015-11-16
 *  @author Manfred Kerber
 */
public class ChessBoard extends JPanel {
    public static int smallSize = 50; 
    public static int xOffset = 50; 
    public static int yOffset = 50; 

    @Override
    /**
     *    Override the paintComponent method from the JPanel class.  A
     *    simple chessboard is put on the JPanel built on a filled
     *    3-dimensional list of squares.
     *    @param g The graphics component used for painting.
     */
    public void paintComponent(Graphics g){
	Font myfont = new Font("Dialog",1,24);
        setFont(myfont);

	super.paintComponent(g);

        g.setColor(new Color(255,255,255));
	for (int j=0; j<4; j++){
	    for (int i=0; i<4; i++){
		/* 3DRect to have a rectangular with slightly adjusted colours.*/
		g.fill3DRect(xOffset+ 2*i*smallSize,
			     yOffset+2*j*smallSize,
			     smallSize,smallSize,true);
		g.fill3DRect(xOffset+ smallSize*(2*i+1),
			     yOffset+smallSize*(2*j+1),
			     smallSize,smallSize,true);
		g.fill3DRect(xOffset+ (2*i+1)*smallSize,
			     yOffset+2*j*smallSize,
			     smallSize,smallSize,false);
		g.fill3DRect(xOffset+ smallSize*2*i,
			     yOffset+smallSize*(2*j+1),
			     smallSize,smallSize,false);
	    }
	}
    }

    /*
     *  We create a frame with a panel on which we draw the empty chessboard.
     */
    public static void main(String[] args) { 
        ChessBoard panel =  new ChessBoard();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 600;
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 
        //creates a window of size 600 x 600 pixels
        frame.add(panel); 
        frame.setVisible(true); // makes the application visible.
    }
}

