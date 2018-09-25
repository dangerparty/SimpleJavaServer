package networking;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class SimpleClient {

	DataInputStream input;
	DataOutputStream output;
	Socket client;
	
	public SimpleClient(String name, int port) {
		
		// try to open socket
		
		try {
			
			client = new Socket(name, port);
			
		} catch (UnknownHostException e) {
			
			System.out.println("Cant connect to host: " + e);
			
		} catch (Exception e) {
			
			System.out.println("Something went wrong - Socket creation: " + e);

		}
		
		//try to open streams
		
		try {
			
			input = new DataInputStream( client.getInputStream() );
			output = new DataOutputStream( client.getOutputStream() );
		
		} catch(Exception e) {
			
			System.out.println("Something went wrong - input / output: " + e);
			
		}
		
		// try to read from the server and write to the server
		
		try {
			
			String line = input.readLine();			
			System.out.println("Received from server: " + line);
			
			output.writeBytes("Hello from client!");
			
		} catch(Exception e) {
			
			System.out.println("Something went wrong - can't write: " + e);
			
		}
		
		
		
		// try to close the Socket
		
		
		try {

			client.close();
			 
		} catch(Exception e) {
			
			System.out.println("Something went wrong - can't close Client: " + e);
			
		}
		

	}
	
	
	public static void main(String[] args) {

		int portNum = 1255;
		String hostName = "Roy";
		
		SimpleClient clientObj = new SimpleClient(hostName,portNum);


	}

}
