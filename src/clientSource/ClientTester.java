package clientSource;

import java.util.List;

public class ClientTester{
	
	public static void main(String[] args) throws Exception{
		ClientPrototype client = new ClientPrototype("localhost",9000);
		client.runClient();
	}
	
}