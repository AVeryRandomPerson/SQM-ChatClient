package breakCaseTestSuite;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import clientSource.MacroClientPrototype;

public class MESGNoReceiverTest {

	// Case of MESG with no receiver
	@Test
	public void test() throws Exception {
		Queue<String> emptyCommand = new LinkedList<String>();
		Queue<String> expectedOutput = new LinkedList<String>();
		
		emptyCommand.add("IDEN chatBOT1");
		emptyCommand.add("MESG I am a pancake!");
		emptyCommand.add("QUIT");
		
		expectedOutput.add("OK Welcome to the chat server, there are currently 1 user(s) online");
		expectedOutput.add("OK Welcome to the chat server chatBOT1");
		expectedOutput.add("BAD the user does not exist");
		expectedOutput.add("OK thank you for sending 0 message(s) with the chat service, goodbye.");
		
		MacroClientPrototype bot_emptyCommand = new MacroClientPrototype("localhost",9000,emptyCommand);
		bot_emptyCommand.executeMacro();

		assertEquals(true,ErrorChecker.isOutputMatches(expectedOutput, (bot_emptyCommand.getInputListener().getResponses())));
	}

}
