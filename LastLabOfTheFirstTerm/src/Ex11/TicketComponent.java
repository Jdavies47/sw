package Ex11;

import javax.swing.*;

/**
 *  The example is adapted from the TemperatureComponent method we saw
 *  in week 9.  In this class we create a TicketComponent which is a
 *  JPanel to interface with a Ticket class.
 *  We will add different parts to it:
 *  - The model
 *  - The view
 *  - The oberver
 *  @version 2015-12-10
 *  @author Manfred Kerber
 */
public class TicketComponent extends JPanel {

    /**
     *  Constructor with a ticket, the available screens, the
     *  corresponding prices, and info whether they offer a 3D film.
     *  @param screens An array storing all the screens in the cinema.
     *  @param prices An array of equal size to screens storing the
     *  corresponding prices for the corresponding screen.
     *  @param screen3D An array of equal size to the screens storing the
     *  info whether the film shown in this screen is 3D.
     */
    public TicketComponent(String[] screens,
                           int[] prices, boolean[] screen3D){
        super();
		
        // model 
        TicketModel model = new TicketModel(new Ticket("0",0,false,false));
		
        // views
PriceView   priceView   = new PriceView(model);
priceView.setFont(new Font("Courier", Font.BOLD,24));
GlassesView glassesView = new GlassesView(model);
glassesView.setFont(new Font("Courier", Font.BOLD,24));
		
        // make views observe model
model.addObserver(priceView);
model.addObserver(glassesView);

        //The JFrame has a Gridlayout with 4 panels underneath each
        //other. The upper one containing the total price and the
        //information about the glasses. The next a JComboBox and a
        //CheckBox to check whether the customer needs 3D Glasses.
        //The third is empty, the fourth contains the cancel and print
        //buttons.
        this.setLayout(new GridLayout(4,1));

        JPanel north = new JPanel();
        north.setLayout(new GridLayout(1,2));
        /*        north.add(priceView);*/
        /*        north.add(glassesView);*/

        // create control
        JComboBox<String> comboBox = new JComboBox<String>(screens);
        comboBox.setMaximumRowCount(7);  // maximal number of choices displayed
        comboBox.setFont(new Font("Courier", Font.BOLD,24));
        JCheckBox glassesButton = new JCheckBox();
        glassesButton.setVisible(false); // the button should be
                                         // visible only for 3D films.
        
        JPanel empty1 = new JPanel();
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(1,3));
        middle.add(comboBox);
        middle.add(empty1);
        middle.add(glassesButton);

        JPanel empty2 = new JPanel();

        JButton cancel = new JButton("CANCEL");
        JButton print = new JButton("PRINT");
        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        south.add(cancel);
        south.add(print);

        // add the 4 panels to the frame.

        this.add(north);
        this.add(middle);
        this.add(empty2);
        this.add(south); 

        // create listener
GlassesListener listenGlasses = new GlassesListener(model, glassesButton);
ScreenListener listenScreen = new ScreenListener(model, comboBox,
                                                         prices, screen3D,
                                                         glassesButton);
        /*        CancelListener cancelOp = new CancelListener(model, glassesButton, glassesView);*/
        /*        PrintListener printOp = new PrintListener(model);*/

        // make listeners listen to controls
        /*        glassesButton.addChangeListener(listenGlasses);*/
comboBox.addActionListener(listenScreen);
        /*        cancel.addActionListener(cancelOp);*/
        /*        print.addActionListener(printOp);*/
    }
}
