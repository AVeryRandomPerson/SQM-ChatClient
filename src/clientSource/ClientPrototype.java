package clientSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientPrototype{
	
	public static void main (String[] args) throws Exception{
		Socket clientSocket = new Socket("localhost",9000);
		InputListener inListener = new InputListener(clientSocket);
		Thread inlisteningThread = new Thread(inListener);
		PrintStream outputStream=new PrintStream(clientSocket.getOutputStream());
		BufferedReader cmdInputStream=new BufferedReader(new InputStreamReader(System.in));		
		

		inlisteningThread.start();		
		String userCommand;
		while (  true ){
			Thread.sleep(75);
			System.out.print("Client : ");
			userCommand=cmdInputStream.readLine();			
			outputStream.println(userCommand);
			
			if(userCommand.length() >= 4 && userCommand.substring(0,4).contains("QUIT")){
				inlisteningThread.interrupt();
				break;
			}
			
		}
	}
}