package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadClient extends Thread{
	BufferedReader in;
	
	public ThreadClient(Socket s) throws IOException {
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	public void Sending()
	{
		try {
			String message = "";
			while (message.equals("")) {
				message = in.readLine();
				System.out.println(in.readLine());
			}
			}catch (IOException e) {};
	}
	
	public void Listening()
	{
		
	}
	
}
