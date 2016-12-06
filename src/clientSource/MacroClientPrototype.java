package clientSource;

import java.util.Queue;

public class MacroClientPrototype extends ClientPrototype{
	Queue<String> commandsQueue;
	private final int RESPONSE_TIME = 500;
	
	
	public MacroClientPrototype(String ipAddress, int portNumber, Queue<String> commandsQueue) throws Exception{
		super(ipAddress,portNumber);
		this.commandsQueue = commandsQueue;
		
	}
	
	public void executeMacro() throws Exception{
		Thread inListeningThread = new Thread(inListener);
		inListeningThread.start();		
		String userCommand;
		while (  !commandsQueue.isEmpty() ){
			Thread.sleep(75);
			System.out.print("[ Client ] > ");
			Thread.sleep(RESPONSE_TIME);
			userCommand= commandsQueue.poll();
			System.out.println(userCommand);
			outputStream.println(userCommand);
			
			if(userCommand.length() >= 4 && userCommand.substring(0,4).contains("QUIT")){
				inListeningThread.interrupt();
				break;
			}
		}
	}

}