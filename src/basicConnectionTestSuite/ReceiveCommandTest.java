package basicConnectionTestSuite;


import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.net.Socket;

import org.junit.Test;

import clientSource.InputListener;
import serverSource.TestConnection;
import serverSource.TestServer;

public class ReceiveCommandTest {

	@Test
	public void test() throws Exception {
		TestServer dummyServer = new TestServer(9000);
		Thread dummyServerThread = new Thread(dummyServer);
		dummyServerThread.start();

		Socket dummyClientSocket = new Socket("localhost",9000);
		Thread.sleep(300); // Added sleep to make sure the client is properly connected.
		TestConnection dummyConnection = dummyServer.list.get(0);
		InputListener dummyListener = new InputListener(dummyClientSocket);
		Thread dummyListenerThread = new Thread(dummyListener);
		dummyListenerThread.start();	
		
		String intendedCommand = "TESTING 123\n";
		String expectedReceive;
		PrintStream outputStream=new PrintStream(dummyClientSocket.getOutputStream());
		outputStream.print(intendedCommand);
		
		// Added sleep to make sure client-server operations are finished.
		Thread.sleep(300);		
		expectedReceive = dummyConnection.getCommandReceived();
		intendedCommand = intendedCommand.split("\n")[0]; 
		
		System.out.println(expectedReceive);
		System.out.println(intendedCommand);
		
		assertEquals(true,intendedCommand.equals(expectedReceive));
	}

}
