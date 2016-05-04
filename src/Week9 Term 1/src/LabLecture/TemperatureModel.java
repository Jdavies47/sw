package LabLecture;

import java.util.Observable;

public class TemperatureModel extends Observable {

	Temperature temp;

	public TemperatureModel(Temperature temp){
		super();
		this.temp = temp;
	}
	
	public double getCelsius(){
		return temp.getCelsius();
	}
	
	public double getFahrenheit(){
		return temp.getFahrenheit();
	}

	public void setCelsius(int value) {
		// TODO Auto-generated method stub
		
	}
}
