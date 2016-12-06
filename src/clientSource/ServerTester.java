package clientSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import serverSource.Server;

public class ServerTester{
	static Server server;
	final static int SERVER_PORT = 9000;
	
	
	private List<ClientPrototype> allClients;
	
	public static void activateServer(){
		server = new Server(SERVER_PORT);
	}
	
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
		Queue<String> commands = new LinkedList<String>();
		Queue<String> serverResponses = new LinkedList<String>();
		commands.add("IDEN bot1");
		commands.add("STAT");
		commands.add("QUIT");
		MacroClientPrototype bot1 = new MacroClientPrototype("localhost",9000,commands);
		bot1.executeMacro();

		
	}
}