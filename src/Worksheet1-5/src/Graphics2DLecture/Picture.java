package Graphics2DLecture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Picture extends JPanel {
    private String image;
    private int xPos;
    private int yPos;
    private String caption;

    /**
     *  A picture consists of three parts, the image itself, the xPos
     *  and the yPos where on the JPanel it is to be placed (measured
     *  from the top left corner).
     *  @param image Position of the image in the images directory.
     *  @param xPos  The x-coordinate of the picture.
     *  @param yPos  The y-coordinate of the picture.
     *  @param caption The text above the picture
     */
    public Picture(String image, int xPos, int yPos, String caption) {
        this.image = image;
        this.xPos  = xPos;
        this.yPos  = yPos;
        this.caption = caption;
    }
    
    /**
     *    Override the paintComponent method from the JPanel class.
     *    Then we load a picture and draw it on the panel.
     *    Furthermore we write some explaining text.
     *    @param g The graphics component used for painting.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
	/* 
         * Arguments of loadImage are: an image, the xPosition, the
	 * yPosition, and an ImageObserver not needed in our context.
         */
	g.drawImage(loadImage(image), xPos, yPos, null);

        /* The font in which we write the text */
        setFont(new Font("Dialog",1,12));
        /* A String written staring at position (70,400).*/
	g.drawString(caption,10,10);
    }

    /**
     *  Method to load an image file from a file. Note that the images
     *  are put in the directory "images" and we follow the Unix/Linux
     *  directory structure.
     *  @param name The file name in the directory images.
     *  @return A buffered image found in the file.
     */
    private BufferedImage loadImage(String name){
	String imgFileName = "images/"+name;
	URL url =  Picture.class.getResource(imgFileName);
	BufferedImage img = null;
	try {
	    img = ImageIO.read(url);
	}
	catch (Exception e) {
            System.out.println("File " + name + " not found.");
	}
	return img;
    }

    /*
     * Main method to create a panel and put the image on.
     */
    public static void main(String[] args) { 
        Picture panel = new Picture("firstCar.jpg", 200, 30,
                                    "First car http://www.automotoportal.com/article/when-did-the-first-car-come-into-our.lives");
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 600;
            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates a window of size 800 x 600 pixels
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); 

        frame.add(panel);
        frame.setVisible(true); // makes the application visible.

        JFrame frame1 = new JFrame();
        Picture panel1 = new Picture("crest.jpg", 500, 30, "");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates a second window of size 800 x 600 pixels
        frame1.setSize(FRAME_WIDTH,FRAME_HEIGHT); 

        frame1.add(panel1);
        frame1.setVisible(true); // makes the application visible.

        JFrame frame2 = new JFrame();
        Picture panel2 = new Picture("paris.jpg", 500, 30, "");
        frame2.setSize(FRAME_WIDTH,FRAME_HEIGHT); 

        frame2.add(panel2);
        frame2.setVisible(true); // makes the application visible.
    }
}

