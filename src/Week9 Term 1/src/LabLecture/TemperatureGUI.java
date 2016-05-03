package LabLecture;

import javax.swing.*;

public class TemperatureGUI{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature converter");
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        Temperature temp = new Temperature(0);
		
        TemperatureComponent panel = new TemperatureComponent(temp, -200, 200,
                                                              0);
        frame.add(panel);
        frame.setVisible(true);
    }
}
