/** 
 *  Example adapted from Walter Savitch TextField example Absolute
 *  Java, Fourth Edition, p.1021f to build a Memory game.
 *  @version 2015-11-30
 *  @author Manfred Kerber
 */

public class Icon extends JFrame implements ActionListener {
    // Some static variables
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final int NUMBER_OF_CHAR = 200;
    public static final int NUMBER_OF_ROWS = 4;
    public static final int NUMBER_OF_COLUMNS = 3;
    public static final int numberOfPuzzleTiles = NUMBER_OF_ROWS * NUMBER_OF_COLUMNS;
    // This is what the play sees before a card is turned over.
    public static final ImageIcon defaultIcon = new ImageIcon("default.jpg");

    /**
     *   The field variables contain an array of icons to display the
     *   memory cards, an array of JButtons to be clicked, and the
     *   file names of the images (all of the same length).
     */
    private ImageIcon icons[];
    private JButton[] buttons;
    private String[] images;

    /**
     *  Constructor that generates a JFrame with a GridLayout
     *  @param images The filenames of the images to be displayed on
     *  the Memory.
     */
    public Icon(String[] images){
        super("Memory");
        // The images field variable is initialized.
        this.images = images;

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // A grid layout of appropriate size is generated.
        this.setLayout(new GridLayout(NUMBER_OF_ROWS,NUMBER_OF_COLUMNS));

        // The icons field variable is initialized.
        icons = new ImageIcon[numberOfPuzzleTiles];
        for (int i = numberOfPuzzleTiles - 1; i >= 0; i--) {
            icons[i] = new ImageIcon(randomImage(images, i) + ".jpg");
        }

        JPanel picturesPanel = new JPanel();
        picturesPanel.setBackground(Color.WHITE);

        //The buttons field variable is initialized
        buttons = new JButton[numberOfPuzzleTiles];
        for (int i = 0; i < numberOfPuzzleTiles; i++) {
            buttons[i] = new JButton(String.format("%d", i));
            buttons[i].setIcon(defaultIcon);
        }
        //add action listeners to all numberOfPuzzleTiles buttons and
        //add the buttons to the panel
        for (int i = 0; i < numberOfPuzzleTiles; i++) {
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
    }

    public void toggleImage(String actionCommand) {
        int i = Integer.parseInt(actionCommand);
        if (buttons[i].getIcon().equals(defaultIcon)) {
            buttons[i].setIcon(icons[i]);
        } else {
            buttons[i].setIcon(defaultIcon);
        }
    }

    /**
     *   @param e Means clicking one of the two buttons.
     *   The action performed depends on which button was clicked.
     */
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        toggleImage(actionCommand);
    }

    /** 
     *  Select a random number from images in the range [0,...,upto],
     *  the selected image is put at the end of the active range so
     *  that it is not selected again.
     *  @param images An array of int represented images for random
     *  selection
     *  @param upto Only the range [0,...,upto] is active in the array.
     *  @return A random value for an image.
     *
     */
    public static String randomImage(String[] images, int upto) {
        int value = (int) (upto * Math.random());
        String tmp = images[upto];
        images[upto] = images[value];
        images[value] = tmp;
        return images[upto];
    }

    /* 
     *  main method to create the JFrame and make it visible
     */
    public static void main(String[] args){
        String[] images = new String[numberOfPuzzleTiles];
        for (int i = 0; i < numberOfPuzzleTiles; i++) {
            // there are only half as many images than number of
            // puzzle tiles, since every image has to occur exactly
            // twice.
            images[i] = "" + i/2; 
        }
        Icon calc = new Icon(images);
        calc.setVisible(true);
    }
}
