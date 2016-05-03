package Graphics2DLecture;

import javax.swing.*;
import java.awt.*;

/**
 *  Class to display a two-dimensional array of 0, 1, and 2 as big
 *  coloured dots.
 *
 *  @version 2015-11-16
 *  @author Manfred Kerber
 */

public class Grid extends JPanel{
    public static final int offset = 20;
    public static final int width = 30;

    /**
     *  One field variable, the 2-dimensional array to be displayed by
     *  coloured dots.
     */
    private int[][] grid;

    /**
     *  Constructor, which initializes the grid.
     *  @param grid The 2-dimensional array to be displayed by coloured
     *  dots.
     */
    public Grid(int[][] grid) {
        this.grid = grid;
    }
    
    @Override
    /**
     *    Override the paintComponent method from the JPanel class.
     *    We display the entries in the grid matrix as:
     *    0 not displayed, 1 as green, and 2 as red.
     *    @param g The graphics component used for painting.
     */
    public void paintComponent(Graphics g){
	super.paintComponent(g);

	for (int i = 0; i< grid.length; i++) {
            for (int j = 0; j< grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillOval(offset+j*width,offset+i*width, width, width);
                    repaint();
                } else if (grid[i][j] == 2) {
                    g.setColor(Color.RED);
                    g.fillOval(offset+j*width,offset+i*width, width, width);
                    repaint();
                }
            }
        }
    }


    /**
     *  Open new window of appropriate size with panel to paint on the
     *  grid.
     *  @param grid The two-dimensional array of 0, 1, or 2 to be displayed.
     */
    public static void displayGrid(int[][] grid){
        // JFrame to open a new window.
        JFrame frame = new JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	final int FRAME_WIDTH =  offset + width * (grid[0].length + 1);
	final int FRAME_HEIGHT = offset + width * (grid.length+2);

        Grid panel = new Grid(grid);
	//creates a window of appropriate (variable) size.
	frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 

	frame.add(panel); 
	frame.setVisible(true); // makes the application visible.
    }

    /*
     * Main method to initialize a matrix and display it.
     */
    public static void main(String[] args) {
        int[][]  grid = {{0,1,0,1,1},
                         {1,2,0,0,1},
                         {1,1,0,1,2}};
        displayGrid(grid);

        int[][]  grid1 = {{0,1,0,1,1,0,1,1},
                          {1,2,0,0,1,2,2,1},
                          {1,1,0,1,2,1,1,2}};
        displayGrid(grid1);
    }
}

