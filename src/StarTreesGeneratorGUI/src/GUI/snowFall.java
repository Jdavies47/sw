package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zsolt on 08/01/16.
 */
public class snowFall extends JPanel implements ActionListener {

    Timer tim = new Timer(50, this);

    int velocity = 2;
    int amountOfSnow = 1000;
    int[] x = new int[amountOfSnow];
    int[] y = new int[amountOfSnow];

    snowFall(int velocity, int amountOfSnow) {
        for (int i = 0; i < amountOfSnow; i++) {
            x[i] = (int) (800 * Math.random());
            y[i] = (int) (20 * Math.random());
        }
    }

    public int[] getX(int i) {
        return new int[]{x[i]};
    }

    public int[] getY(int i) {
        return new int[]{y[i]};
    }
    public static void main(String[] args) {
        snowFall sf = new snowFall(2, 10);
        JFrame frame = new JFrame();
        frame.setTitle("snowalpha");
        frame.setSize(800, 768);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0.0001f, 0.0001f, 0.0001f, 0.0001f));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(sf);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < amountOfSnow; i++) {
            g.setColor(Color.WHITE);
            g.fillOval(x[i], y[i], 5, 5);
            tim.start();
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < amountOfSnow; i++) {
            if (y[i] < 0)
                velocity = -velocity;
            y[i] = y[i] + velocity;
            repaint();
        }
    }
}
