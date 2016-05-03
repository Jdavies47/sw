package Exercise2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * TREES
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 5 Exercise 2
 * The program takes in coordinates of the top left pixel of bounding boxes of 
 * christmas trees, which it then stores in an ArrayList of objects to be drawn.
 * Trees can also be scaled from the base size of 12*16 pixels.
 * 
 */

public class Trees extends JPanel{

	/**
	 * VARIABLES:
	 * toDraw ArrayList to store polygons to be drawn
	 */
	private ArrayList<Polygon> toDraw = new ArrayList<>();
	
	/**
	 * CONSTRUCTOR: to create christmass tree objects
	 * @param xTrees x coordinates of the tree
	 * @param yTrees y coordinates of the tree
	 * @param scaleTrees the scale of the bas 12*16 tree
	 */
	public Trees(int[] xTrees, int[] yTrees, int[] scaleTrees) {
	}

	/**
	 * METHOD to add polygon objects to the toDraw ArrayList
	 * @param poly the polygon object
	 */
	public void addToDraw(Polygon poly) {
		toDraw.add(poly);
	}

	/**
	 * MEHTOD to convert the background rectangle to a 
	 * polygon object add it to the toDraw ArrayList
	 * @param dX the width of the rectangle
	 * @param dY the height of the rectangle
	 */
	public void addRectangle(int dX, int dY) {
		// CONVERTING THE RECTANGLE INTO A POLYGON OBJECT
		Polygon poly = new Polygon();
		int[] xPoints = { 0, dX, dX, 0 };
		int[] yPoints = { 0, 0, dY, dY };
		poly.xpoints = xPoints;
		poly.ypoints = yPoints;
		poly.npoints = 4;

		// SENDING THE RECTANGLE POLYGON OBJECT TO THE toDraw LIST
		this.addToDraw(poly);
	}

	@Override
	public void paintComponent(Graphics g) {
		// LOOPS THROUGH THE toDraw LIST & DISPLAYS EACH POLYGON
		// STORED WITHIN
		for (int i = 0; i < toDraw.size(); i++) {
			if (i == 0 && toDraw.get(i).npoints == 4) {
				g.setColor(Color.gray);
			} else if (toDraw.get(i).npoints == 3) {
				Color niceGreen = new Color(39, 84, 47);
				g.setColor(niceGreen);
			} else if (toDraw.get(i).npoints == 4) { 
				Color niceBrown = new Color(113, 76, 38);
				g.setColor(niceBrown);
			}
			g.fillPolygon(toDraw.get(i));
		}
	}

	public static void main(String[] args) {

		// DIMENSIONS OF THE BACKGROUND 
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		
		// DIMENSIONS OF THE BOUNDING BOX OF THE CHRISTMAS TREE
		final int TREE_BOX_WIDTH = 12;
		final int TREE_BOX_HEIGHT = 16;
		
		// DEFINING TREES' POSITIONS AND SCALES
		int[] xTrees = {0, 100, 0, 300, 320};
		int[] yTrees = {0, 100, 300, 100, 230};
		int[] scaleTrees = {10, 20, 10, 10, 20};
		
		// CONSTRUCTING THE PANEL 
		Trees christmas = new Trees(xTrees, yTrees, scaleTrees);

		// SENDING THE FRAME RECTANGLE TO addRectangle
		christmas.addRectangle(FRAME_WIDTH, FRAME_HEIGHT);
		
		// LOOPS THROUGH xTrees AND SENDING EVERY INSTANCE
		// OF A CHRISTMAS TREE TO THE toDraw LIST
		for(int i = 0; i < xTrees.length; i++){
			
		// SENDING THE CHRISTMAS TREE'S TRIANGLE TO THE toDraw LIST
		Polygon triangle = new Polygon();
		int scale = scaleTrees[i];
		int x = xTrees[i];
		int y = yTrees[i];
		
		// DEFINING THE DIMENSIONS OF THE TRIANGLE
		int[] triangleXPoints = {
								x + ((int) ((int) TREE_BOX_WIDTH - (int) TREE_BOX_WIDTH)*scale), 
								x + ((int) ((int) TREE_BOX_WIDTH/2)*scale),
								x + ((int) ((int) TREE_BOX_WIDTH)*scale)
								};
		int[] triangleYPoints = {
								y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT/4))*scale),
								y + ((int) ((int) TREE_BOX_HEIGHT - (int) TREE_BOX_HEIGHT)*scale),
								y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT/4))*scale)
								};
		triangle.xpoints = triangleXPoints;
		triangle.ypoints = triangleYPoints;
		triangle.npoints = 3;
		
		// ADDING IT TO THE toDraw LIST
		christmas.addToDraw(triangle);

		// SENDING THE CHRISTMAS TREE'S TRUNK TO THE toDraw LIST
		Polygon trunk = new Polygon();
		
		// DEFINING THE DIMENSIONS OF THE TRUNK OF THE TREE
		int[] trunkXPoints = {
				x + ((int) ((int) ((TREE_BOX_WIDTH/12)*5))*scale), 
				x + ((int) ((int) ((TREE_BOX_WIDTH/12)*7))*scale),
				x + ((int) ((int) ((TREE_BOX_WIDTH/12)*7))*scale),
				x + ((int) ((int) ((TREE_BOX_WIDTH/12)*5))*scale)
							 };
		int[] trunkYPoints = { 
				y + ((int) ((int) ((TREE_BOX_HEIGHT/4)*3))*scale),
				y + ((int) ((int) ((TREE_BOX_HEIGHT/4)*3))*scale),
				y + ((int) ((int) TREE_BOX_HEIGHT)*scale),
				y + ((int) ((int) TREE_BOX_HEIGHT)*scale)		
							 };
		trunk.xpoints = trunkXPoints;
		trunk.ypoints = trunkYPoints;
		trunk.npoints = 4;
		
		// ADDING IT TO THE toDraw LIST
		christmas.addToDraw(trunk);
		}
		
		// CREATING THE FRAME
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("WS5:EX2");
		frame.add(christmas);
		frame.setVisible(true);
	}
}