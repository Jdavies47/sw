package chat.gui;

import chat.Client;

import java.util.Observable;
import java.util.Observer;

public class LoginView implements Observer {

	private Client client;
	
	public LoginView(Client client){
		this.client = client;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		
	}
}
