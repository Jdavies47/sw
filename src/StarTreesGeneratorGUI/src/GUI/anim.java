package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zsolt on 08/01/16.
 */
public class anim extends JPanel implements ActionListener {

    Timer tm = new Timer(5, this);

    int x = 0, velX = 2;

    public static void main(String[] args) {
        anim a = new anim();
        JFrame jf = new JFrame();
        jf.setTitle("anim demo");
        jf.setSize(600, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(a);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(30, x, 50, 30);

        tm.start();
    }

    public void actionPerformed(ActionEvent e) {

        if (x < 0 || x > 370)
            velX = -velX;
        x = x + velX;
        repaint();
    }
}
