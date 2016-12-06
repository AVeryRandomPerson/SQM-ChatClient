package clientSource;

import java.io.*;
import java.net.*;
public class test{
public static void main (String[] args) throws Exception
{
	Socket sk=new Socket("localhost",9000);
	BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
	PrintStream sout=new PrintStream(sk.getOutputStream());
	BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	String s;
	Boolean exit = false;
	System.out.println("Server : "+sin.readLine()+"\n");
	while (  true )
	{
		
		System.out.print("Client : ");
		s=stdin.readLine();
		sout.println(s);
		do{
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
			if ( s.equalsIgnoreCase("BYE") ){
				exit = true;
				break;
			}
			System.out.println(s.substring(0,3));
		}while(s.substring(0, 3).contains("BAD"));
		if(exit) break;
		
			
	}
	 sk.close();
	 sin.close();
	 sout.close();
	 stdin.close();
}}