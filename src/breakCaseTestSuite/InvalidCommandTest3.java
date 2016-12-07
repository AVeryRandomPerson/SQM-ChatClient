package breakCaseTestSuite;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import clientSource.MacroClientPrototype;

public class InvalidCommandTest3 {

	// Case of Invalid Command #3
	@Test
	public void test() throws Exception {
		Queue<String> emptyCommand = new LinkedList<String>();
		Queue<String> expectedOutput = new LinkedList<String>();
		
		emptyCommand.add("\\0MSG");
		emptyCommand.add("QUIT");
		
		expectedOutput.add("OK Welcome to the chat server, there are currently 1 user(s) online");
		expectedOutput.add("BAD command not recognised");
		expectedOutput.add("OK goodbye.");
		
		MacroClientPrototype bot_emptyCommand = new MacroClientPrototype("localhost",9000,emptyCommand);
		bot_emptyCommand.executeMacro();

		assertEquals(true,ErrorChecker.isOutputMatches(expectedOutput, (bot_emptyCommand.getInputListener().getResponses())));
	}

}
