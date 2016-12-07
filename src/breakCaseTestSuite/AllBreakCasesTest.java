package breakCaseTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DirectQuitTest.class, EmptyCommandTest.class, HAILNoMessageTest.class, IDENNoNameTest.class,
		InvalidCommandTest1.class, InvalidCommandTest2.class, InvalidCommandTest3.class, InvalidCommandTest4.class,
		MESGNoMessageTest.class, MESGNoReceiverTest.class, MESGWithoutIDENTest.class })
public class AllBreakCasesTest {

}
