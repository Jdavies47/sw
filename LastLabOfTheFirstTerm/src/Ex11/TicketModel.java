package Ex11;

import java.util.Observable;

/**
 *  Model of ticket classes
 *  Enhance the ticket classes by obervables.
 *  @version 2015-12-09
 *  @author Manfred Kerber
 */


public class TicketModel extends Observable {
    private Ticket ticket;
	
    /**
     *  Constructor
     *  @param ticket The ticket to modelled by the model.
     */
    public TicketModel(Ticket ticket) {
        super();
        this.ticket = ticket;
    }
	
    /**
     *  getter for price
     *  @return The price of the ticket.
     */
    public int getPrice() {
        return ticket.getPrice();
    }
	
    /**
     *  getter for needGlasses
     *  @return true if and only if the customer needs 3D glasses.
     */
    public boolean getNeedGlasses() {
        return ticket.getNeedGlasses();
    }
    
    /**
     *  getter for screen
     *  @return The screen of the film on the ticket.
     */
    public String getScreen() {
        return ticket.getScreen();
    }
	
    /**
     *  getter for film3D
     *  @return true if and only if the film is a 3D film.
     */
    public boolean getFilm3D() {
        return ticket.getFilm3D();
    }
	
    /**
     *  Change the price
     *  @param price The new price
     */
    public void setPrice(int price) {
        ticket.setPrice(price);
        setChanged();
        notifyObservers();
    }

    /**
     *  Change the needGlasses
     *  @param needGlasses New value whether the customer needs 3D glasses.
     */
    public void setNeedGlasses(boolean needGlasses) {
        ticket.setNeedGlasses(needGlasses);
        setChanged();
        notifyObservers();
    }
    
    /**
     *  Change the screen
     *  @param screen New value of the screen where is film is shown.
     */
    public void setScreen(String screen) {
        ticket.setScreen(screen);
        setChanged();
        notifyObservers();
    }
    
    /**
     *  Change the value of whether the film is a 3D film
     *  @param film3D New value of whether the film is a 3D film.
     */
    public void setFilm3D(boolean film3D) {
        ticket.setFilm3D(film3D);
        setChanged();
        notifyObservers();
    }
}
