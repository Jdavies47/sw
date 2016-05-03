
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by Zsolt Pazmandy on 18/02/16.
 * VIEW CLASS for the GUI implementation of the T9 TreeDictionary application
 */
public class T9GUIView extends JFrame implements Observer {

    private T9GUIModel model;

    private JPanel topDisplayPanel = new JPanel();
    private JPanel sigDisplayPanel = new JPanel();

    private JButton[] buttons = new JButton[16];

    private JTextArea topDisplay = new JTextArea(1, 50);
    private JLabel sigDisplay = new JLabel();

//    private Font topFont = new Font("FreeSans", Font.PLAIN, 20);
//    private Font keyFont = new Font("FreeSans", Font.BOLD, 12);
//    private Font buttonFont = new Font("FreeSans", Font.PLAIN, 12);
//    private Font sigFont = new Font("ProFontWindows", Font.BOLD, 16);

    private ArrayList<String> temp = new ArrayList<>();

    /**
     * CONSTRUCTOR
     */
    public T9GUIView(T9GUIModel model) {
        this.model = model;
        setUpPanels();
        setUpKeyboard();
        setUpActions();
    }

    /**
     * Sets up the panels within the frame & their layout settings.
     */
    public void setUpPanels() {

        // MAIN LAYOUT
        setLayout(new BorderLayout());

        // ADDING TOP DISPLAY
        topDisplayPanel.setLayout(new BorderLayout());
        add(topDisplayPanel, BorderLayout.NORTH);
        topDisplayPanel.add(topDisplay, BorderLayout.NORTH);
        topDisplay.setLineWrap(true);
        topDisplay.setWrapStyleWord(true);
//        topDisplay.setFont(topFont);
        topDisplay.setSize(Frame.WIDTH, 60);
        topDisplay.setEditable(false);
        topDisplay.getCaret().setVisible(true);

        // ADDING BOTTOM DISPLAY FOR CURRENT SIGNATURES
        sigDisplayPanel.setLayout(new BorderLayout());
        add(sigDisplayPanel, BorderLayout.SOUTH);
        sigDisplayPanel.add(sigDisplay, BorderLayout.CENTER);
        sigDisplay.setSize(Frame.WIDTH, 60);
//        sigDisplay.setFont(sigFont);
        sigDisplay.setText("signature: ");

        /**
         * Pick LAF: Native, JAVA Cross-Platform, or Nimbus
         */
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (ClassNotFoundException |
                UnsupportedLookAndFeelException |
                IllegalAccessException |
                InstantiationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Sets up keyboard & some of the button functions.
     * The actions of the keys of the  numeric keypad are set up
     * by the setUpActions method
     */
    public void setUpKeyboard() {
        // ADDING KEYBOARD
        JPanel keyboard = new JPanel();
        add(keyboard, BorderLayout.CENTER);
        keyboard.setLayout(new GridLayout(4, 3));

        // ADDING ARROW BUTTONS
        JPanel arrows = new JPanel();
        arrows.setLayout(new GridLayout(1, 2));
        topDisplayPanel.add(arrows, BorderLayout.SOUTH);


        /**
         * Buttons initialised & labelled
         */

        buttons[0] = new JButton("1");
        buttons[1] = new JButton("2 abc");
        buttons[2] = new JButton("3 def");
        buttons[3] = new JButton("4 ghi");
        buttons[4] = new JButton("5 jkl");
        buttons[5] = new JButton("6 mno");
        buttons[6] = new JButton("7 pqrs");
        buttons[7] = new JButton("8 tuv");
        buttons[8] = new JButton("9 wxyz");
        buttons[9] = new JButton("*");
        buttons[10] = new JButton("0");
        buttons[11] = new JButton("#");
        buttons[12] = new JButton("DEL");
        add(buttons[12], BorderLayout.LINE_END);
        buttons[13] = new JButton("PREV");
        buttons[14] = new JButton("CLEAR");
        buttons[15] = new JButton("NEXT");

        /**
         * Initialising, labelling & specifying misc buttons
         * DELETE button & function
         */
        add(buttons[12], BorderLayout.LINE_END);
        buttons[12].addActionListener(ae -> {
            if (model.getSignature().length() > 0) {
                model.setSignature(model.getSignature().substring(0,
                        model.getSignature().length() - 1));
                model.currentHits(model.getSignature());
                model.setIndex(0);
                topDisplay.setText(model.getDisplayed() +
                        model.getThis(model.getIndex()));
                sigDisplay.setText(sigDisplay.getText().substring(0,
                        sigDisplay.getText().length() - 1));
            }

            if (model.getSignature().length() == 0) {
                model.setSignature("");
                model.setWordCount(0);
                model.setIndex(0);
                model.setWordsEntered(null);
                model.setDisplayed("");
                topDisplay.setText("");
                sigDisplay.setText("");
            }
        });

        /**
         * PREVIOUS button & function
         */
        buttons[13].addActionListener(ae -> {
            if (model.getIndex() > 0) {
                model.setIndex(model.getIndex() - 1);
            }
            model.currentHits(model.getSignature());
            topDisplay.setText(model.getDisplayed() + model.getThis(model.getIndex()));
        });

        /**
         * CLEAR button & function
         */
        buttons[14].addActionListener(ae -> {
            model.setSignature("");
            model.setWordCount(0);
            model.setIndex(0);
            model.setWordsEntered(null);
            model.setDisplayed("");
            topDisplay.setText("");
            sigDisplay.setText("signature: ");
        });

        /**
         * NEXT button & function
         */
        buttons[15].addActionListener(ae -> {
            if (model.getIndex() < model.getResultList().size() - 1) {
                model.setIndex(model.getIndex() + 1);
            }
            model.currentHits(model.getSignature());
            topDisplay.setText(model.getDisplayed() + model.getThis(model.getIndex()));
        });

        /**
         * Arranging misc buttons & setting their fonts
         */
        for (int j = 13; j < 16; j++) {
//            buttons[j].setFont(buttonFont);
            arrows.add(buttons[j]);
        }

        /**
         * Keys 1-12 added to the keyboard & setting font
         */
        for (int j = 0; j < 12; j++) {
            keyboard.add(buttons[j]);
//            buttons[j].setFont(keyFont);
        }
    }

    /**
     * Sets up numeric key actions & buttons
     */
    public void setUpActions() {
        for (int j = 0; j < 12; j++) {
            int i = j;
            buttons[i].addActionListener(ae -> {
                        if (i == 0) {

                        }
                        if (i == 1) {
                            model.setSignature(model.getSignature() + "2");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            sigDisplay.setText(sigDisplay.getText() + "2");
                            topDisplay.append(model.getThis(model.getIndex()));
                        }
                        if (i == 2) {

                            model.setSignature(model.getSignature() + "3");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "3");

                        }
                        if (i == 3) {
                            model.setSignature(model.getSignature() + "4");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "4");
                        }
                        if (i == 4) {
                            model.setSignature(model.getSignature() + "5");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "5");
                        }
                        if (i == 5) {
                            model.setSignature(model.getSignature() + "6");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "6");
                        }
                        if (i == 6) {
                            model.setSignature(model.getSignature() + "7");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "7");
                            buttons[i] = new JButton(i + 1 + " pqrs");
                        }
                        if (i == 7) {
                            model.setSignature(model.getSignature() + "8");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "8");
                        }
                        if (i == 8) {
                            model.setSignature(model.getSignature() + "9");
                            model.currentHits(model.getSignature());
                            model.setIndex(0);
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append(model.getThis(model.getIndex()));
                            sigDisplay.setText(sigDisplay.getText() + "9");
                        }
                        if (i == 9) {
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append("*");
                        }
                        if (i == 10) {
                            temp.add(topDisplay.getText());
                            model.setDisplayed(temp.toString()
                                    .replace(",", "")
                                    .replace("[", "")
                                    .replace("]", "")
                                    .trim());
                            model.setDisplayed(model.getDisplayed() + " ");
                            topDisplay.setText(model.getDisplayed());
                            model.setSignature("");
                            model.setIndex(0);
                            temp.addAll(model.getWordsEntered());
                            model.setWordsEntered(temp);
                            temp.clear();
                            model.setWordCount(model.getWordCount() + 1);
                            sigDisplay.setText("signature: ");
                        }
                        if (i == 11) {
                            topDisplay.setText(model.getDisplayed());
                            topDisplay.append("#");
                        }
                    }
            );
        }
    }

    @Override
    public void update(Observable o, Object object) {
        topDisplay.getCaret().setVisible(true);
    }
}

