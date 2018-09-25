package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleServer {
	
	ServerSocket server;
	Socket client;
	DataInputStream input;
	PrintStream output;
	
	public SimpleServer(int port) {
		
		// try to open a server Socket
		
		try {
			
			server = new ServerSocket(port);
			
		} catch (Exception e) {
			
			System.out.println("Something went wrong - Server Socket: " + e);

		}
		
		
		// try to accept connections
		
		try {
			
			 client = server.accept();
			 input = new DataInputStream( client.getInputStream() );
			 output = new PrintStream( client.getOutputStream() ); 
			
			 
		} catch (Exception e) {
			
			System.out.println("Something went wrong - Server connections: " + e);
			
		}
		

		// try to read and write from client
		
		
		try {

			output.println("Hello from server!");
			
			String line = input.readLine();			
			System.out.println("Received from client: " + line);
			 
		} catch (Exception e) {
			
			System.out.println("Something went wrong - can't read from client - Server: " + e);
			
		}
		
	}
	
	
	public static void main(String[] args) {

		int portNum = 1255;
		
		SimpleServer serverObj = new SimpleServer(portNum);


	}
	
	
}
