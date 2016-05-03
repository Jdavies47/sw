package Exercise5;

import Exercise4.BaubleTrees;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * STAR TREES
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 * Software Workshop Worksheet 5 Exercise 5
 * The Program extends the BaubleTrees class which extends
 * the Trees class. Through its inheritance it is capable of
 * drawing any number of christmas trees (at user-defined positions
 * and user-defined scales) and placing a user-defined amount
 * of baubles of random red, blue or yellow colour on the triangle
 * of the christmas tree at randomized positions. It then draws an 
 * automatically scaled star on the top of each christmas tree.
 * The colour of the star is entirely randomized and chosen from 10
 * colours. The user defines the specifications of the star in 2 
 * parameters: its number of vertices and the steps taken from 
 * each vertix to the other one when defining the connecting lines.
 */

public class StarTrees extends BaubleTrees {

	/**
	 * VARIABLES:
	 * toDraw ArrayList to store polygons to be drawn
	 * int numberOfBaubles to store the amount of baubles to be drawn
	 * int numberOfVertices to store the amount of vertices as parameters
	 * 						of the star on top of the christmas tree
	 * int steps to store the amount of steps taken to arrive to one
	 * 						point from another when drawing its lines
	 */
	private ArrayList<Polygon> toDraw = new ArrayList<>();
	private int numberOfBaubles, numberOfVertices, steps;
	
	/**
	 * CONSTRUCTOR to create christmas trees with baubles on them and a 
	 * random colour star
	 * @param xTrees x coordinates of the tree
	 * @param yTrees y coordinates of the tree
	 * @param scaleTrees the scale of the bas 12*16 tree
	 * @param numberOfBaubles the amount of baubles drawn on the trees
	 * @param numberOfVertices the amount of vertices as parameters
	 * 						of the star on top of the christmas tree
	 * @param steps the amount of steps taken to arrive to one
	 * 						point from another when drawing its lines
	 */
	public StarTrees(int[] xTrees, int[] yTrees, int[] scaleTrees, int numberOfBaubles, int numberOfVertices, int steps) {
		super(xTrees, yTrees, scaleTrees, numberOfBaubles);
		this.numberOfBaubles = numberOfBaubles;
		this.numberOfVertices = numberOfVertices;
		this.steps = steps;
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

		// SENDING THE RECTANGLE POLYGON OBJECT TO
		// THE toDraw LIST
		this.addToDraw(poly);
	}

	@Override
	public void paintComponent(Graphics g) {
		// LOOPS THROUGH THE toDraw LIST & DISPLAYS
		// EACH POLYGON STORED WITHIN
		for (int i = 0; i < toDraw.size(); i++) {

			// CHOOSE THE COLOUR OF THE BACKGROUND RECTANGLE GRAY
			if (i == 0 && toDraw.get(i).npoints == 4) {
				g.setColor(Color.gray);

				// CHOOSE THE COLOUR OF THE TRIANGLES GREEN
			} else if (toDraw.get(i).npoints == 3) {
				Color niceGreen = new Color(39, 84, 47);
				g.setColor(niceGreen);

				// CHOOSE THE COLOUR OF THE RECTANGLES BROWN
			} else if (toDraw.get(i).npoints == 4) {
				Color niceBrown = new Color(113, 76, 38);
				g.setColor(niceBrown);
			}

			// DISPLAY THE 'i'th POLYGON
			g.fillPolygon(toDraw.get(i));
		}

// DRAWING THE BAUBLES BEGINS HERE---------------------------------------------
		// LOOPS THROUGH THE toDraw LIST FOR ALL ITS MEMBERS
		for (int i = 1; i < toDraw.size(); i++) {

			// BAUBLES ARE ONLY DRAWN ON THE TRIANGLES
			if (toDraw.get(i).npoints == 3) {

				// DISPLAYING numberOfBaubles AMOUNT OF BAUBLES
				for (int j = 0; j < numberOfBaubles; j++) {

					// RANDOMIZING THE BAUBLES' COLOUR
					double random = Math.random();

					// 33.3% RED
					if (random <= 0.33) {
						Color niceRed = new Color(208, 14, 14);
						g.setColor(niceRed);

						// 33.3% BLUE
					} else if (random > 0.33 && random < 0.66) {
						Color niceBlue = new Color(34, 97, 181);
						g.setColor(niceBlue);

						// 33.3% YELLOW
					} else if (random >= 0.66) {
						Color niceYellow = new Color(225, 201, 34);
						g.setColor(niceYellow);
					}

					// RANDOMIZING BAUBLES' POSITIONS WITHIN THE TRIANGLES

					// random2 USED TO RANDOMIZE THE DISTANCE FROM THE MIDDLE
					// COLUMN OF THE TRIANGLE
					double random2 = Math.random();

					int XPosition; // HOLDS THE RANDOMIZED X COORDINATE
					int sizeOfBauble = (int) (toDraw.get(i).getBounds().getWidth() / 12);

					// random3 USED TO RANDOMIZE WHETHER BAUBLE IS PLACED
					// TO THE LEFT OR THE RIGHT OF THE MIDDLE COLUMN OF THE
					// TRIANGLE
					double random3 = Math.random();

					// PLACING THE BAUBLE TO THE RIGHT HALF OF THE TRIANGLE
					if (random3 > 0.5) {
						XPosition = (int) (toDraw.get(i).getBounds().getX()
								+ (toDraw.get(i).getBounds().getWidth() / 2))
								+ (int) (random2 * Math.random() * (toDraw.get(i).getBounds().getWidth() / 2))
								- (sizeOfBauble / 2);
					} else {
						// PLACING THE BAUBLE TO THE LEFT HALF OF THE TRIANGLE
						XPosition = (int) (toDraw.get(i).getBounds().getX()
								+ (toDraw.get(i).getBounds().getWidth() / 2))
								- (int) (random2 * Math.random() * (toDraw.get(i).getBounds().getWidth() / 2))
								- (sizeOfBauble / 2);
					}

					// DRAWING THE BAUBLE AT LOCATION: X, Y; OF SIZE:
					// sizeOfBauble, sizeOfBauble
					g.fillOval(XPosition,
							(int) ((toDraw.get(i).getBounds().getY())
									+ (toDraw.get(i).getBounds().getHeight() * random2)) - (sizeOfBauble / 2),
							sizeOfBauble, sizeOfBauble);
				}

// DRAWING THE STAR BEGINS HERE------------------------------------------------
				// SETTING THE STAR'S COLOUR RANDOMLY
				double random = Math.random() * 10;
				int randomInt = (int) random;
				switch (randomInt) {
				case 0:
					g.setColor(Color.WHITE);
					break;
				case 1:
					g.setColor(Color.BLACK);
					break;
				case 2:
					g.setColor(Color.BLUE);
					break;
				case 3:
					g.setColor(Color.CYAN);
					break;
				case 4:
					g.setColor(Color.GREEN);
					break;
				case 5:
					g.setColor(Color.MAGENTA);
					break;
				case 6:
					g.setColor(Color.ORANGE);
					break;
				case 7:
					g.setColor(Color.PINK);
					break;
				case 8:
					g.setColor(Color.RED);
					break;
				case 9:
					g.setColor(Color.YELLOW);
					break;
				}

				// DEFINING THE ANGLE BETWEEN TWO POINTS
				// RELATIVE TO THE CENTRE IN RADIANS
				double angle = 2 * Math.PI / numberOfVertices;

				// WILL BE INCREMENTED BY THE SAME VALUE, SO
				// IT NEEDS TO BE STORED
				double angle2 = angle;

				// Storing all points' angles relative to the centre
				// in an array
				double[] alpha = new double[numberOfVertices];
				alpha[0] = angle;
				for (int j = 1; j < numberOfVertices; j++) {
					angle = angle + angle2;
					alpha[j] = angle;
				}

				// The radius of the circle around the star is defined
				// to be equal to the scale, so the star will scale together
				// with the tree
				int radius = (int) toDraw.get(i).getBounds().getWidth() / 12;

				//CREATING A 2D ARRAY TO STORE:
				// [i] the object whose star is being drawn &
				// [j] the coordinates of the points of the star
				int[][] starXpoints = new int[toDraw.size()][numberOfVertices];
				int[][] starYpoints = new int[toDraw.size()][numberOfVertices];

				// LOOPING THROUGH THE COORDINATES ([j]) & CALCULATING EACH
				// POINTS':
				// X coordinate: by adding to the tree's bounding box's X
				// coordinate
				// the half of the width of the bounding box and adding to it
				// the 'j'th angle's cosine multiplied by the radius
				// Y coordinate: by subtracting from the tree's bounding box's Y
				// coordinate
				// the sine of the 'j'th angle multiplied by the radius
				for (int j = 0; j < numberOfVertices; j++) {
					starXpoints[i][j] = (int) (toDraw.get(i).getBounds().getX())
							+ (int) (toDraw.get(i).getBounds().getWidth() / 2) + (int) (radius * Math.cos(alpha[j]));
					starYpoints[i][j] = (int) (toDraw.get(i).getBounds().getY())
							- (int) (int) (radius * Math.sin(alpha[j]));
				}

				// LOOPING THROUGH THE 'i'TH OBJECTS STAR-POINT-COORDINATES
				for (int j = 0; j < numberOfVertices; j++) {

					// In case connecting a point of the star
					// with another point requires steps which
					// go over the amount of vertices
					// (in case of a 11-vertix 4-step star: e.g. 8),
					// the value of numberOfVertices-steps is subtracted
					// from 'j' so as to disallow reaching for
					// out of bounds elements in the array
					if (j < numberOfVertices - steps) {
						g.drawLine(starXpoints[i][j], starYpoints[i][j], starXpoints[i][j + steps],
								starYpoints[i][j + steps]);
					} else {
						// temporary value, so that j remains unchanged
						int temp = j;
						temp = temp - (numberOfVertices - steps);
						// Star is drawn
						g.drawLine(starXpoints[i][j], starYpoints[i][j], starXpoints[i][temp], starYpoints[i][temp]);
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		// DIMENSIONS OF THE BACKGROUND
		final int FRAME_WIDTH = 900;
		final int FRAME_HEIGHT = 600;
		final int numberOfVertices = 11;
		final int steps = 4;

		// DIMENSIONS OF THE BOUNDING BOX OF THE CHRISTMAS TREE
		final int TREE_BOX_WIDTH = 12;
		final int TREE_BOX_HEIGHT = 16;

		// DEFINING TREES' POSITIONS AND SCALES
		int[] xTrees = { 0, 100, 0, 300, 320, 400, 530, 100, 750 };
		int[] yTrees = { 0, 100, 300, 100, 230, 20, 30, 400, 400 };
		int[] scaleTrees = { 10, 15, 14, 16, 20, 10, 27, 8, 9 };
		int numberOfBaubles = 100;

		// CONSTRUCTING THE PANEL
		StarTrees christmas = new StarTrees(xTrees, yTrees, scaleTrees, numberOfBaubles, numberOfVertices, steps);

		// SENDING THE FRAME RECTANGLE TO addRectangle
		christmas.addRectangle(FRAME_WIDTH, FRAME_HEIGHT);

		// LOOPS THROUGH xTrees AND SENDING EVERY INSTANCE
		// OF A CHRISTMAS TREE TO THE toDraw LIST
		for (int i = 0; i < xTrees.length; i++) {

			// SENDING THE CHRISTMAS TREE'S TRIANGLE TO
			// THE toDraw LIST
			Polygon triangle = new Polygon();
			int scale = scaleTrees[i];
			int x = xTrees[i];
			int y = yTrees[i];

			// DEFINING THE DIMENSIONS OF THE TRIANGLE
			int[] triangleXPoints = { x + ((int) ((int) TREE_BOX_WIDTH - (int) TREE_BOX_WIDTH) * scale),
					x + ((int) ((int) TREE_BOX_WIDTH / 2) * scale), x + ((int) ((int) TREE_BOX_WIDTH) * scale) };
			int[] triangleYPoints = { y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT / 4)) * scale),
					y + ((int) ((int) TREE_BOX_HEIGHT - (int) TREE_BOX_HEIGHT) * scale),
					y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT / 4)) * scale) };
			triangle.xpoints = triangleXPoints;
			triangle.ypoints = triangleYPoints;
			triangle.npoints = 3;

			// ADDING IT TO THE toDraw LIST
			christmas.addToDraw(triangle);

			// SENDING THE CHRISTMAS TREE'S TRUNK TO THE toDraw LIST
			Polygon trunk = new Polygon();

			// DEFINING THE DIMENSIONS OF THE TRUNK OF THE TREE
			int[] trunkXPoints = { x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 5)) * scale),
					x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 7)) * scale),
					x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 7)) * scale),
					x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 5)) * scale) };
			int[] trunkYPoints = { y + ((int) ((int) ((TREE_BOX_HEIGHT / 4) * 3)) * scale),
					y + ((int) ((int) ((TREE_BOX_HEIGHT / 4) * 3)) * scale),
					y + ((int) ((int) TREE_BOX_HEIGHT) * scale), y + ((int) ((int) TREE_BOX_HEIGHT) * scale) };
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
		frame.setTitle("WS5:EX4");
		frame.add(christmas);
		frame.setVisible(true);
	}
}
