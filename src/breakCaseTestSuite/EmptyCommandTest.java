package breakCaseTestSuite;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import clientSource.MacroClientPrototype;

public class EmptyCommandTest {

	// Case of Empty Command.
	@Test
	public void test() throws Exception {
		Queue<String> emptyCommand = new LinkedList<String>();
		Queue<String> expectedOutput = new LinkedList<String>();
		
		emptyCommand.add("");
		emptyCommand.add("QUIT");
		
		expectedOutput.add("OK Welcome to the chat server, there are currently 1 user(s) online");
		expectedOutput.add("BAD invalid command to server");
		expectedOutput.add("OK goodbye.");
		
		MacroClientPrototype bot_emptyCommand = new MacroClientPrototype("localhost",9000,emptyCommand);
		bot_emptyCommand.executeMacro();

		assertEquals(true,ErrorChecker.isOutputMatches(expectedOutput, (bot_emptyCommand.getInputListener().getResponses())));
	}

}
