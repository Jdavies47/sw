package LabLecture;

import Observable;

public class TemperatureModel extends Observable {

	public TemperatureModel(Temperature temp){
		super();
		this.temp = temp;
	}
	
	public double getCelcius(){
		return temp.getCelsius();
	}
	
	public double getFahrenheit(){
		return temp.getFahrenheit();
	}

	public void setCelsius(int value) {
		// TODO Auto-generated method stub
		
	}
}
