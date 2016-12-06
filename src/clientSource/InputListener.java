package clientSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class InputListener implements Runnable{
	Socket clientSocket;
	BufferedReader inputStream;
	PrintStream outputStream;
	BufferedReader cmdIn;
	
	InputListener(Socket clientSocket) throws IOException{
		this.clientSocket = clientSocket;
		this.inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public void run(){
		while(true){
			try {
				String response = inputStream.readLine();
				System.out.println("Server : " + response);
				if (response == null || ( response.contains(", goodbye") && response.substring(0, 2).equals("OK")) ){
					System.out.println("TERMINATING LISTENER");
					break;
				}
			} catch (IOException e) {
				System.err.println("Unable to read Response");
				e.printStackTrace();
			}
		}
	}
}