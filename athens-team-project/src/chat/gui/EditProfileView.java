package chat.gui;

import chat.Client;

import java.util.Observable;
import java.util.Observer;

public class EditProfileView implements Observer{

	
	private Client clientmodel;
	
	
	public EditProfileView(Client clientmodel){
		this.clientmodel = clientmodel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		
	}

}
