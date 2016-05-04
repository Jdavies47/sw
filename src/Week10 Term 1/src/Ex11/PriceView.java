package Ex11;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PriceView extends JLabel implements Observer {
    private TicketModel model;
    public PriceView(TicketModel model) {
        super();
        this.model = model;

        setText("TOTAL:");
    }

    public void update(Observable obs, Object obj) {
        setText("TOTAL: \u00A3" + model.getPrice());
    }
}
