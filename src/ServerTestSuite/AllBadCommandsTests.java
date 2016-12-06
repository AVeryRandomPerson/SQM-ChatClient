package ServerTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DirectQuitTest.class, EmptyCommandTest.class, InvalidCommandTest1.class, InvalidCommandTest2.class,
		InvalidCommandTest3.class, InvalidCommandTest4.class, MESGNoReceiverTest.class, MESGWithoutIDENTest.class })
public class AllBadCommandsTests {

}
