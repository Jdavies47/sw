package Exercise1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * FLOOR LAYOUT
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 5 Exercise 1
 * The program creates an 800*600 window and is capable of displaying
 * polygons provided in the main method adding a Polygon object to
 * the toDraw array list whose elements are then automatically displayed
 * by the paintComponent method along with the dark gray panel, which 
 * is also processed as a polygon by the addRectangle method. 
 * By default 2 yellow pentagons and a pink hexagon is displayed 
 * (the 3 polygons required to be displayed by the exercise 
 * description).
 */
public class FloorLayout extends JPanel {

	/**
	 * VARIABLES 
	 * toDraw ArrayList to store graphical elements to be drawn
	 */
	private ArrayList<Polygon> toDraw = new ArrayList<>();

	/**
	 * CONSTRUCTOR
	 * @param width is the width of the rectangle
	 * @param height is the height of the rectangle
	 */
	public FloorLayout(int width, int height) {
	}

	/**
	 * METHOD that adds its parameter polygon to the toDraw ArrayList of
	 * elements to be drawn
	 * @param poly is the Polygon object to be added to the list
	 */
	public void addToDraw(Polygon poly) {
		toDraw.add(poly);
	}

	/**
	 * METHOD that converts the panel's rectangle into a Polygon object wihch is
	 * then added to the toDraw ArrayList of elements to be drawn
	 * 
	 * @param xPos is the x coordinate of the rectangle
	 * @param yPos is the y coordinate of the rectangle
	 * @param dX is the width of the rectangle
	 * @param dY is the height of the rectangle
	 */
	public void addRectangle(int xPos, int yPos, int dX, int dY) {

		// CONVERTING THE RECTANGLE INTO A POLYGON OBJECT
		Polygon poly = new Polygon();
		int[] xPoints = { xPos, dX + xPos, dX + xPos, xPos };
		int[] yPoints = { yPos, yPos, dY + yPos, dY + yPos };
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
			if (toDraw.get(i).npoints == 5) { // PENTAGONS WILL BE DRAWN YELLOW
				g.setColor(Color.yellow);
			} else if (toDraw.get(i).npoints == 4) { // RECTANGLES WILL BE DRAWN
													 // DARK GRAY
				g.setColor(Color.darkGray);
			} else { // EVERYTHING ELSE WILL BE DRAWN PINK
				g.setColor(Color.pink);
			}
			g.fillPolygon(toDraw.get(i));
		}
	}

	public static void main(String[] args) {
		final int FRAME_WIDTH = 520;
		final int FRAME_HEIGHT = 420;
		FloorLayout panel = new FloorLayout(FRAME_WIDTH, FRAME_HEIGHT);
		
		// SENDING THE RECTANGLE TO addRectangle
		panel.addRectangle(10, 10, FRAME_WIDTH-20, FRAME_HEIGHT-20);

		// SENDING A PENTAGON TO THE toDraw LIST
		Polygon poly1 = new Polygon();
		int[] poly1xPoints = { 100, 150, 200, 175, 125 };
		int[] poly1yPoints = { 100, 50, 100, 150, 150 };
		poly1.xpoints = poly1xPoints;
		poly1.ypoints = poly1yPoints;
		poly1.npoints = 5;
		panel.addToDraw(poly1);

		// SENDING ANOTHER PENTAGON TO THE toDraw LIST
		Polygon poly2 = new Polygon();
		int[] poly2xPoints = { 300, 350, 400, 375, 325 };
		int[] poly2yPoints = { 100, 50, 100, 150, 150 };
		poly2.xpoints = poly2xPoints;
		poly2.ypoints = poly2yPoints;
		poly2.npoints = 5;
		panel.addToDraw(poly2);

		// SENDING A HEXAGON TO THE toDraw LIST
		Polygon poly3 = new Polygon();
		int[] poly3xPoints = { 100, 250, 400, 400, 250, 100 };
		int[] poly3yPoints = { 170, 220, 170, 220, 320, 220 };
		poly3.xpoints = poly3xPoints;
		poly3.ypoints = poly3yPoints;
		poly3.npoints = 6;
		panel.addToDraw(poly3);

		// CREATING THE FRAME
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("WS5:EX1");
		frame.add(panel);
		frame.setVisible(true);
	}
}