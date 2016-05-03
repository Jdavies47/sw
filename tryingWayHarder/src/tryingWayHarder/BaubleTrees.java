package tryingWayHarder;

import java.util.ArrayList;

/**
 * BAUBLE TREES
 *
 * @author Zsolt Pazmandy 1600690 Computer Science MSc 2015/16
 *         Software Workshop Worksheet 5 Exercise 4
 *         The Program inherits the workings of the Trees class and uses it
 *         to display several (user-defined, user-scaled) christmas trees.
 *         It then displays automatically scaled baubles of random red, blue,
 *         yellow colour on the christmas tree's triangle. Randomly calculated
 *         values: colour of baubles, location of baubles.
 */

public class BaubleTrees extends Trees {

    /**
     * VARIABLES:
     * toDraw ArrayList to store polygons to be drawn
     * int numberOfBaubles to store the amount of baubles to be drawn
     */
    private ArrayList<Polygon> toDraw = new ArrayList<>();
    private int numberOfBaubles;

    /**
     * CONSTRUCTOR to create christmas trees with baubles on them
     *
     * @param xTrees          x coordinates of the tree
     * @param yTrees          y coordinates of the tree
     * @param scaleTrees      the scale of the bas 12*16 tree
     * @param numberOfBaubles the amount of baubles drawn on the trees
     */
    public BaubleTrees(int[] xTrees, int[] yTrees, int[] scaleTrees, int numberOfBaubles) {
        super(xTrees, yTrees, scaleTrees);
        this.numberOfBaubles = numberOfBaubles;
    }

    public static void main(String[] args) {

        // DIMENSIONS OF THE BACKGROUND
        final int FRAME_WIDTH = 900;
        final int FRAME_HEIGHT = 600;

        // DIMENSIONS OF THE BOUNDING BOX OF THE
        // CHRISTMAS TREE
        final int TREE_BOX_WIDTH = 12;
        final int TREE_BOX_HEIGHT = 16;

        // DEFINING TREES' POSITIONS AND SCALES
        int[] xTrees = {0, 100, 0, 300, 320, 400, 530, 100, 750};
        int[] yTrees = {0, 100, 300, 100, 230, 20, 30, 400, 400};
        int[] scaleTrees = {10, 15, 14, 16, 20, 10, 27, 8, 9};
        int numberOfBaubles = 100;

        // CONSTRUCTING THE PANEL
        BaubleTrees christmas = new BaubleTrees(xTrees, yTrees, scaleTrees, numberOfBaubles);

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
            int[] triangleXPoints = {x + ((int) ((int) TREE_BOX_WIDTH - (int) TREE_BOX_WIDTH) * scale),
                    x + ((int) ((int) TREE_BOX_WIDTH / 2) * scale), x + ((int) ((int) TREE_BOX_WIDTH) * scale)};
            int[] triangleYPoints = {y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT / 4)) * scale),
                    y + ((int) ((int) TREE_BOX_HEIGHT - (int) TREE_BOX_HEIGHT) * scale),
                    y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT / 4)) * scale)};
            triangle.xpoints = triangleXPoints;
            triangle.ypoints = triangleYPoints;
            triangle.npoints = 3;

            // ADDING IT TO THE toDraw LIST
            christmas.addToDraw(triangle);

            // SENDING THE CHRISTMAS TREE'S TRUNK TO THE toDraw LIST
            Polygon trunk = new Polygon();

            // DEFINING THE DIMENSIONS OF THE TRUNK OF THE TREE
            int[] trunkXPoints = {x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 5)) * scale),
                    x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 7)) * scale),
                    x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 7)) * scale),
                    x + ((int) ((int) ((TREE_BOX_WIDTH / 12) * 5)) * scale)};
            int[] trunkYPoints = {y + ((int) ((int) ((TREE_BOX_HEIGHT / 4) * 3)) * scale),
                    y + ((int) ((int) ((TREE_BOX_HEIGHT / 4) * 3)) * scale),
                    y + ((int) ((int) TREE_BOX_HEIGHT) * scale), y + ((int) ((int) TREE_BOX_HEIGHT) * scale)};
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

    /**
     * METHOD to add polygon objects to the toDraw ArrayList
     *
     * @param poly the polygon object
     */
    public void addToDraw(Polygon poly) {
        toDraw.add(poly);
    }

    /**
     * MEHTOD to convert the background rectangle to a
     * polygon object add it to the toDraw ArrayList
     *
     * @param dX the width of the rectangle
     * @param dY the height of the rectangle
     */
    public void addRectangle(int dX, int dY) {
        // CONVERTING THE RECTANGLE INTO A POLYGON OBJECT
        Polygon poly = new Polygon();
        int[] xPoints = {0, dX, dX, 0};
        int[] yPoints = {0, 0, dY, dY};
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
            }
        }
    }
}
