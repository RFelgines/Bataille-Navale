package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import map.Grid;

public class ThreadClient extends Thread{
	BufferedReader in;
	PrintWriter out;
	
	public ThreadClient(Socket s) throws IOException
	{
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);
	}
	
	public void run()
	{
		try
		{
			String message = "";
			while (!message.equals("quit"))
			{
				message = in.readLine();
				System.out.println(message);
			}
		}
		catch (IOException e) {};
	}
	
}
