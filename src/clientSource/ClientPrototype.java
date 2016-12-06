package clientSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientPrototype{
	
	Socket clientSocket;
	PrintStream outputStream;
	BufferedReader clientCommandStream;
	InputListener inListener;
	
	ClientPrototype(String ipAddress, int portNumber) throws Exception{
		this.clientSocket = new Socket(ipAddress,portNumber);
		this.inListener = new InputListener(clientSocket);
		this.outputStream=new PrintStream(clientSocket.getOutputStream());
		this.clientCommandStream=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public synchronized void runClient() throws Exception {
		Thread inListeningThread = new Thread(inListener);
		inListeningThread.start();		
		String userCommand;
		while (  true ){
			Thread.sleep(75);
			System.out.print("[ Client ] > ");
			userCommand= clientCommandStream.readLine();			
			outputStream.println(userCommand);
			
			if(userCommand.length() >= 4 && userCommand.substring(0,4).contains("QUIT")){
				break;
			}
		}
	}
	
	public InputListener getInputListener(){
		return inListener;
	}
}