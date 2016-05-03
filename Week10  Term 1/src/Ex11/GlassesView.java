package Ex11;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class GlassesView extends JLabel implements Observer {
    private TicketModel model;
	
    public GlassesView(TicketModel model) {
        super();
        this.model = model;
    }

    public void update(Observable obs, Object obj) {
         }
}
