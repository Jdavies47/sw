package Ex11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenListener implements ActionListener {

    private TicketModel model;
    private JComboBox<String> comboBox;
    private int[] prices;
    private boolean[] screen3D;
    private JCheckBox glassesButton;

    public ScreenListener(TicketModel model, JComboBox<String> comboBox, int[] prices, boolean[] screen3D, JCheckBox glassesButton) {
        this.model = model;
        this.comboBox = comboBox;
        this.prices = prices;
        this.screen3D = screen3D;
        this.glassesButton = glassesButton;
    }

    public void actionPerformed(ActionEvent e){
        model.setScreen("" + comboBox.getSelectedItem());
        model.setPrice(prices[comboBox.getSelectedIndex()]);
        // later add here to make the classes button visible
        System.out.println(model.getPrice());
        if(screen3D[comboBox.getSelectedIndex()]){
        	glassesButton.setVisible(true);
        } else {
        	glassesButton.setVisible(false);
        	model.setFilm3D(false);
        }
    }
}
