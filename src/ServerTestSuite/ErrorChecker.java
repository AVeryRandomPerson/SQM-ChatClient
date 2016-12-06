package ServerTestSuite;

import java.util.Queue;

public class ErrorChecker {
	public static boolean isOutputMatches(Queue<String> expectedOutput,Queue<String> receivedOutput){
		int mismatches = 0;
		for(String eOutput : expectedOutput){
			if(eOutput.equals(receivedOutput.poll())) System.out.print("[Match]");
			else {System.out.print("[Failed]"); mismatches++;}
			System.out.println(eOutput);
		}
		return mismatches == 0;
	}
}
