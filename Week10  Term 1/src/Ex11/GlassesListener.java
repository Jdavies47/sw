package Ex11;

public class GlassesListener implements ChangeListener {

    private TicketModel model;
    private JCheckBox glassesButton;

    public GlassesListener(TicketModel model, JCheckBox glassesButton) {
        this.model = model;
        this.glassesButton = glassesButton;
    }

    public void stateChanged(ChangeEvent e){
        if(glassesButton.isSelected()) {
        	model.setPrice(model.getPrice() + 2);
        	model.setNeedGlasses(true);
        } else {
        	model.setNeedGlasses(false);
        }
    }
}
