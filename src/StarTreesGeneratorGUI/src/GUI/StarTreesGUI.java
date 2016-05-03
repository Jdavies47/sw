package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StarTreesGUI extends JFrame {

    private JLabel amountOfTreesLabel, amountOfBaublesLabel, verticesLabel, stepsLabel, colourLabel, starColourLabel,
            treeSizeLabel, starThicknessLabel, messageLabel;
    private JTextField amountOfTreesBox, amountOfBaublesBox, verticesBox, stepsBox, messageBox;
    private JComboBox<String> colourBox;
    private JRadioButton starColourRadio[] = new JRadioButton[11];
    private ButtonGroup radios = new ButtonGroup();
    private JButton button = new JButton("Make Christmas");
    private JSlider treeSize;
    private JSpinner starThickness;
    private event e = new event();
    private int tmp, tmp2, tmp3, tmp4;
    private String message;

    public StarTreesGUI() {

        setLayout(new GridLayout(30, 1));

        try {
// NIMBUS LAF
// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            // GTK LAF
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        amountOfTreesLabel = new JLabel("Amount of trees:");
        add(amountOfTreesLabel);

        amountOfTreesBox = new JTextField();
        amountOfTreesBox.setColumns(3);
        amountOfTreesBox.setVisible(true);
        add(amountOfTreesBox);

        amountOfBaublesLabel = new JLabel("Amount of baubles/tree:");
        add(amountOfBaublesLabel);

        amountOfBaublesBox = new JTextField();
        amountOfBaublesBox.setColumns(3);
        amountOfBaublesBox.setVisible(true);
        add(amountOfBaublesBox);

        colourLabel = new JLabel("Colour of baubles:");
        add(colourLabel);

        colourBox = new JComboBox<>();
        colourBox.addItem("Red");
        colourBox.addItem("Blue");
        colourBox.addItem("Yellow");
        colourBox.addItem("Randomize");
        colourBox.setVisible(true);
        colourBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    tmp = colourBox.getSelectedIndex();
            }
        });
        add(colourBox);

        verticesLabel = new JLabel("Amount of star's vertices:");
        add(verticesLabel);

        verticesBox = new JTextField();
        verticesBox.setColumns(3);
        verticesBox.setVisible(true);
        add(verticesBox);

        stepsLabel = new JLabel("Amount of stars steps:");
        add(stepsLabel);

        stepsBox = new JTextField();
        stepsBox.setColumns(3);
        stepsBox.setVisible(true);
        add(stepsBox);

        starColourLabel = new JLabel("Colour of stars:");
        add(starColourLabel);

        ItemHandler handler = new ItemHandler();

        for (int i = 0; i < starColourRadio.length; i++) {
            starColourRadio[i] = new JRadioButton();
            switch (i) {
                case 0:
                    starColourRadio[i].setText("White");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 1:
                    starColourRadio[i].setText("Black");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 2:
                    starColourRadio[i].setText("Blue");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 3:
                    starColourRadio[i].setText("Cyan");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 4:
                    starColourRadio[i].setText("Green");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 5:
                    starColourRadio[i].setText("Magenta");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 6:
                    starColourRadio[i].setText("Orange");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 7:
                    starColourRadio[i].setText("Pink");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 8:
                    starColourRadio[i].setText("Red");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 9:
                    starColourRadio[i].setText("Yellow");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
                case 10:
                    starColourRadio[i].setText("Randomize");
                    starColourRadio[i].addItemListener(handler);
                    radios.add(starColourRadio[i]);
                    add(starColourRadio[i]);
                    break;
            }
        }

        starThicknessLabel = new JLabel("Thickness of stars:");
        add(starThicknessLabel);

        starThickness = new JSpinner();
        starThickness.setMinimumSize(getMinimumSize());
        starThickness.setMaximumSize(getMaximumSize());
        starThickness.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tmp4 = (int) starThickness.getValue();
            }
        });
        add(starThickness);

        treeSizeLabel = new JLabel("Boost trees' sizes:");
        add(treeSizeLabel);

        treeSize = new JSlider();
        treeSize.setMinimum(0);
        treeSize.setMaximum(50);
        treeSize.setValue(0);
        treeSize.setMajorTickSpacing(10);
        treeSize.setSnapToTicks(true);
        treeSize.setPaintTicks(true);
        treeSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tmp3 = treeSize.getValue() / 10;
            }
        });
        add(treeSize);

        messageLabel = new JLabel("Enter text to display:");
        add(messageLabel);

        messageBox = new JTextField();
        messageBox.setText("Merry Christmas!");
        add(messageBox);

        button.addActionListener(e);
        add(button);
    }

    public static void main(String[] args) {
        StarTreesGUI go = new StarTreesGUI();
        go.setVisible(true);
        go.setSize(230, 650);
        go.setLocation(558, 10);
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setTitle("Christmas Maker v3");
    }

    private class ItemHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            for (int i = 0; i < 11; i++) {
                if (starColourRadio[i].isSelected()) {
                    tmp2 = i;
                }
                ;
            }
        }
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int amountOfTrees = Integer.parseInt(amountOfTreesBox.getText());
            int userNumberOfVertices = Integer.parseInt(verticesBox.getText());
            int userSteps = Integer.parseInt(stepsBox.getText());
            int userNumberOfBaubles = Integer.parseInt(amountOfBaublesBox.getText());
            int colourOfBaubles = tmp;
            int colourOfStar = tmp2;
            int starThickness = tmp4;
            String message = messageBox.getText();

            int FRAME_WIDTH = 1376;
            int FRAME_HEIGHT = 768;
            final int TREE_BOX_WIDTH = 12;
            final int TREE_BOX_HEIGHT = 16;
            int[] xTrees = new int[amountOfTrees];
            int[] yTrees = new int[amountOfTrees];
            int[] scaleTrees = new int[amountOfTrees];

            for (int i = 0; i < amountOfTrees; i++) {
                xTrees[i] = (int) (FRAME_WIDTH * Math.random());
                yTrees[i] = (int) (FRAME_HEIGHT * Math.random());
                scaleTrees[i] = (int) (10 * Math.random());
            }

            for (int i = 0; i < amountOfTrees; i++) {
                if (xTrees[i] + TREE_BOX_WIDTH * scaleTrees[i] > FRAME_WIDTH) {
                    xTrees[i] = xTrees[i] - (FRAME_WIDTH - xTrees[i] + TREE_BOX_WIDTH * scaleTrees[i]);
                }

                if (yTrees[i] + TREE_BOX_HEIGHT * scaleTrees[i] > FRAME_HEIGHT) {
                    yTrees[i] = yTrees[i] - (FRAME_HEIGHT - yTrees[i] + TREE_BOX_HEIGHT * scaleTrees[i]);
                }
            }

            StarTreesMod christmas = new StarTreesMod(xTrees, yTrees, scaleTrees, userNumberOfBaubles,
                    userNumberOfVertices, userSteps, colourOfBaubles, colourOfStar, starThickness, message);
            christmas.addRectangle(FRAME_WIDTH, FRAME_HEIGHT);
            for (int i = 0; i < xTrees.length; i++) {
                Polygon triangle = new Polygon();
                int scale = scaleTrees[i] + tmp3;
                int x = xTrees[i];
                int y = yTrees[i];
                int[] triangleXPoints = {x + ((int) ((int) TREE_BOX_WIDTH - (int) TREE_BOX_WIDTH) * scale),
                        x + ((int) ((int) TREE_BOX_WIDTH / 2) * scale), x + ((int) ((int) TREE_BOX_WIDTH) * scale)};
                int[] triangleYPoints = {y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT / 4)) * scale),
                        y + ((int) ((int) TREE_BOX_HEIGHT - (int) TREE_BOX_HEIGHT) * scale),
                        y + ((int) ((int) TREE_BOX_HEIGHT - (int) (TREE_BOX_HEIGHT / 4)) * scale)};
                triangle.xpoints = triangleXPoints;
                triangle.ypoints = triangleYPoints;
                triangle.npoints = 3;
                christmas.addToDraw(triangle);
                Polygon trunk = new Polygon();
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
                christmas.addToDraw(trunk);

            }

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(MAXIMIZED_BOTH);
            frame.setTitle("Christmas Maker v3");
            frame.add(christmas);
            frame.setVisible(true);

            //message doesnt display properly
/*            JLabel messageDisplayed = new JLabel();
            messageDisplayed.setVisible(true);
            messageDisplayed.setText(message);
            messageDisplayed.setLocation(FRAME_WIDTH/2, FRAME_HEIGHT/2);
            messageDisplayed.setBackground(Color.white);
            messageDisplayed.setSize(100,100);
            messageDisplayed.setBounds(FRAME_WIDTH/2, FRAME_HEIGHT/2,100,100);
            frame.add(messageDisplayed);*/
        }
    }
}
