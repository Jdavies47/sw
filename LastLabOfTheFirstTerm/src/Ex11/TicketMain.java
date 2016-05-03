package Ex11;

import javax.swing.*;

/** 
 *  Class with the main method to demonstrate the Ticket GUI.
 *
 *  @version 2015-12-09
 *  @author Manfred Kerber
 */

public class TicketMain{
    public static void main(String[] args) {
        // Generate frame
        JFrame frame = new JFrame("Ticket Issuer");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Three arrays of equal length with the screens in the cinema,
        //the corresponding prices and a boolean to indicate whether a
        //3D film is presented.
        String[] screens = {"1", "2", "3", "Isense", "4", "5", "6", "7"};
        int[] prices = {7,8,6,9,6,6,6,10};
        boolean[] screen3D = {false,false,true,true,false,false,false,false};
		
        TicketComponent panel = new TicketComponent(screens, prices, screen3D);
        frame.add(panel);
        frame.setVisible(true);
    }
}
