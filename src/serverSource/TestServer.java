package serverSource;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;


public class TestServer implements Runnable{

	public ServerSocket server;
	public ArrayList<TestConnection> list;
	public int port;
	
	public TestServer (int port) {
		this.port = port;
	}
	
	public void run(){
		try {
			server = new ServerSocket(port);
			System.out.println("Server has been initialised on port " + port);
		}
		catch (IOException e) {
			System.err.println("error initialising server");
			e.printStackTrace();
		}
		list = new ArrayList<TestConnection>();
		while(true) {
				TestConnection c = null;
				try {
					c = new TestConnection(server.accept(), this);
				}
				catch (IOException e) {
					System.err.println("error setting up new client connection");
					e.printStackTrace();
				}
				Thread t = new Thread(c);
				t.start();
				list.add(c);
		}
	}
	
	public ArrayList<String> getUserList() {
		ArrayList<String> userList = new ArrayList<String>();
		for( TestConnection clientThread: list){
			if(clientThread.getState() == Connection.STATE_REGISTERED) {
				userList.add(clientThread.getUserName());
			}
		}
		return userList;
	}

	public boolean doesUserExist(String newUser) {
		boolean result = false;
		for( String users: this.getUserList()){
			result = users.equals(newUser);
			if(result) break;
		}
		return result;
	}
	
	public void broadcastMessage(String theMessage){
		System.out.println(theMessage);
		for( TestConnection clientThread: list){
			clientThread.messageForConnection(theMessage + System.lineSeparator());	
		}
	}
	
	public boolean sendPrivateMessage(String message, String user) {
		for( TestConnection clientThread: list) {
			if(clientThread.getState() == Connection.STATE_REGISTERED) {
				if(clientThread.getUserName().compareTo(user)==0) {
					clientThread.messageForConnection(message + System.lineSeparator());
					return true;
				}
			}
		}
		return false;
	}
	
	public void removeDeadUsers(){
		Iterator<TestConnection> it = list.iterator();
		while (it.hasNext()) {
			TestConnection c = it.next();
			if(!c.isRunning())
				it.remove();
		}
	}
	
	public int getNumberOfUsers() {
		return list.size();
	}
	
	protected void finalize() throws IOException{
		server.close();
	}
		
}
