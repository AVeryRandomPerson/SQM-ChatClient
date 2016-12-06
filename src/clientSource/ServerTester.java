package clientSource;

import java.util.List;

public class ServerTester{
	
	private List<ClientPrototype> allClients;

	
	public void setClients(List<ClientPrototype> allClients){
		this.allClients = allClients;
	}
	
	public boolean establishServerClientConnection() throws Exception{
		for(ClientPrototype client : allClients){
			client.runClient();
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		ClientPrototype client = new ClientPrototype("localhost",9000);
		client.runClient();
	}
	
}