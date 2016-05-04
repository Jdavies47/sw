package LabLecture;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class CelsiusView extends JLabel implements Observer {
	private TemperatureModel model;
	
	public CelsiusView(TemperatureModel model){
		super();
		this.model = model;
		
		double value = model.getCelsius();
		setText(value + "Celsius");
	}

	@Override
	public void update(Observable obs, Object arg) {

		
	}
	


}
