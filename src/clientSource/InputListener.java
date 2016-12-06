package clientSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InputListener implements Runnable{
	Socket clientSocket;
	BufferedReader inputStream;
	PrintStream outputStream;
	BufferedReader cmdIn;
	Queue<String> serverResponses = new LinkedList<String>();
	
	InputListener(Socket clientSocket) throws IOException{
		this.clientSocket = clientSocket;
		this.inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
		
	public void run(){
		while(true){
			try {
				String response = inputStream.readLine();
				if (response == null || ( response.contains(", goodbye") && response.substring(0, 2).equals("OK")) ){
					break;
				}
				serverResponses.add(response);
				System.out.println("[ Server ] > " + response);
			} catch (IOException e) {
				System.err.println("Unable to read Response");
				e.printStackTrace();
			}
		}
	}
	
	
	public synchronized Queue<String> getResponses(){
		return serverResponses;
	}
}
