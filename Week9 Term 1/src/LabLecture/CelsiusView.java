package LabLecture;

public class CelsiusView extends JLabel implements Observer{
	private TemperatureModel model;
	
	public CelsiusView(TemperatureModel model){
		super();
		this.model = model;
		
		double value model.getCelcius();
		setText(value + "Celsius");
	}

	@Override
	public void update(Observable obs, Object arg) {

		
	}
	


}
