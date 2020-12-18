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
	
	public ThreadClient(Socket s) throws IOException {
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);


	}
	
	public void run()
	{

		try {
			Grid myGrid = new Grid(10); // Askip je suis obligé de le définir ici
			Grid ennemyGrid = new Grid(10);
			System.out.println("Bernard");
			String message = "";
			while (!message.equals("quit")) {

				message = in.readLine();
				System.out.println(message);
				
				// Condition pour éviter d'afficher la grille à chaque fois.
				
				/*
				System.out.println("Votre grille est :");
				myGrid.Display();
				*/
				
				
				
				//idem
				/*
				System.out.println("La grille ennemi est");
				ennemyGrid.Display();
				*/

			}
			}catch (IOException e) {};
	}
	
	public void Listening()
	{
		
	}
	
}
