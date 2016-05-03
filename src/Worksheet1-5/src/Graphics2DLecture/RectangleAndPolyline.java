package Graphics2DLecture;

import javax.swing.*;

/**
 *  Class to display a Rectangle, a Polyline, and a Polygon as well as
 *  an example of the copyArea() method.
 *
 *  @version 2015-11-16
 *  @author Manfred Kerber
 */
public class RectangleAndPolyline extends JPanel{


    @Override
    /**
     *    Override the paintComponent method from the JPanel class.  
     *    A Rectangle, a Polyline, and a Polygone are put on the panel. 
     *    Furthermore, an area of the panel is copied to a different part.
     *    @param g The graphics component used for painting.
     */
    public void paintComponent(Graphics g){
	super.paintComponent(g);

	int vertices = 20;
	float rotation = (float) 0.0;
	float scale = (float) 100;
	int xOffset = (int) (1.3*scale);
	int yOffset = (int) (1.3*scale);
	int[] xPoints = new int[vertices];
	int[] yPoints = new int[vertices];


        /* Draw rectangle in position (50,100) ie., 50 to the left and
         * 100 down from the left top position with 200 pixels wide
         * and 100 heigh.
         */ 
        g.drawRect(50,100,200,100);

        /* Define two one-dimensional arrays that can be used to draw
         * a polyline or a polygon. In a polygon the edges are closed.
         * Here all vertices are equally distributed on a circle.
         */
	for (int i = 0; i< vertices; i++){
            xPoints[i] = xOffset + 
                (int) Math.round(scale * 
                                 Math.cos(rotation + 
                                          2*i*Math.PI/vertices));
            yPoints[i] = yOffset + 
                (int) Math.round(scale * 
                                 Math.sin(rotation + 
                                          2*i*Math.PI/vertices));
        }
        
	/* A polyline is like a polygon, except that the last and the
	 * first point are not automatically connected.
	 */
        g.drawPolyline(xPoints,yPoints,vertices);
        //        g.drawPolygon(xPoints, yPoints, vertices);

	/* copy area from x,y, width, height, toX, toY */
	g.copyArea(0,0,100,100,300,300); 

    }

    /*
     *  We create a frame with a panel on which we draw all the objects above.
     */
    public static void main(String[] args) { 
        RectangleAndPolyline panel = new RectangleAndPolyline();

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

