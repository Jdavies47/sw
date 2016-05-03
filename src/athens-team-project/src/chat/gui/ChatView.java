package chat.gui; 

import chat.Client;

import java.util.Observable;
import java.util.Observer;

public class ChatView implements Observer{


	private Client client;
	
	
	public ChatView(Client client){
		this.client = client;
		this.client = client;
	}
	@Override
	public void update(Observable o, Object arg) {
		
		
	}

}
