package asd;

import javax.swing.*;

/**
 *  Class to display three objects of class RegularPolygon which are
 *  filled in the XORMode.
 *
 *  @version 2015-11-16
 *  @author Manfred Kerber
 */
public class Ornaments extends JPanel {

    @Override
    /**
     *    Override the paintComponent method from the JPanel class.
     *    Six different filled polygons are put on the panel and
     *    x-or-ed.
     *    @param g The graphics component used for painting.
     */
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	
	/* The XORMode means e.g. that black and black gives white. */
	g.setXORMode(new Color(255,255,255));

	Polygon p1 =  RegularPolygon(4, 100, 100, 100, (float) Math.PI/4);
	g.fillPolygon(p1);

	Polygon p2 =  RegularPolygon(4, 100, 100, 100, (float) 0);
	g.fillPolygon(p2);

	Polygon p3 =  RegularPolygon(5, 100, 300, 100, (float) Math.PI/5);
	g.fillPolygon(p3);

	Polygon p4 =  RegularPolygon(5, 100, 300, 100, (float) 0);
	g.fillPolygon(p4);

	Polygon p5 =  RegularPolygon(13, 100, 500, 100, (float) Math.PI/4);
	g.fillPolygon(p5);

	Polygon p6 =  RegularPolygon(13, 100, 500, 100, (float) 0);
	g.fillPolygon(p6);
    }

    /** 
     *  A regular polygon is defined by the number of vertices, its
     *  scale (size), position and rotation.
     *
     *  @param vertices The number of vertices of the regular polygon.
     *  @param scale A factor to enlarge the regular polygon.
     *  @param xOffset The regular polygon is shifted so many pixels
     *  to the right.
     *  @param yOffset The regular polygon is shifted so many pixels
     *  down.
     *  @param rotation The regular polygon is rotated by the
     *  corresponding amount counter-clockwise, where a full rotation
     *  corresponds to 2 * Math.PI.
     *  @return The corresponding Polygon.
     */
    public Polygon RegularPolygon(int vertices, float scale, 
				  int xOffset, int yOffset, float rotation){

	int[] xpoints = new int[vertices];
	int[] ypoints = new int[vertices];

	for (int i = 0; i< vertices; i++)
	    {
		xpoints[i] = xOffset + 
		    (int) Math.round(scale * 
				     Math.cos(rotation + 
                                              2*i*Math.PI/vertices));
		ypoints[i] = yOffset + 
		    (int) Math.round(scale * 
				     Math.sin(rotation + 
                                              2*i*Math.PI/vertices));
	    }
	return new Polygon(xpoints,ypoints,vertices);
    }

    /*
     * Main method to display the ornaments produced.
     */
    public static void main(String[] args){ 
        Ornaments panel = new Ornaments();

        JFrame frame = new JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	final int FRAME_WIDTH = 800;
	final int FRAME_HEIGHT = 600;

	//creates a window of size 800 x 600 pixels
	frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 
	frame.add(panel); 
	frame.setVisible(true); // makes the application visible.
    }
}