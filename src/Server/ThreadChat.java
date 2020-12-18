package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import map.Battleship;
import map.Boat;
import map.Carrier;
import map.Cruiser;
import map.Destroyer;
import map.Submarine;

public class ThreadChat extends Thread
{	
	int id;
	static PrintWriter[] outs=new PrintWriter[100]; 
	static ArrayList<Joueur> joueurs;
	
	public ThreadChat(int id, Socket client) {

		joueurs = new ArrayList<Joueur>();
		try {
			Joueur newJoueur = new Joueur(joueurs.size());
			joueurs.add(newJoueur);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			newJoueur.SetIn(in);
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			newJoueur.SetOut(out);
			out.println("Id="+id+"\n");
			outs[id] = out;
		}
		catch (Exception e) {}
	}
	
	public void run() {
		try {
		while (true) {
			PlaceBoats();
			Play();
			/*String message=in.readLine();
			message=id+":"+message;
			System.out.println(message);
			for (int i=0;i<nbid;i++) {
				if (i!=id)outs[i].println(message);
			}*/
		}
		}catch (Exception e) {}
	}
	
	
	
	public void PlaceBoats() 
	{
		boolean gamephase = false;
		try 
		{
			Carrier carrier = new Carrier();
			Battleship battleship = new Battleship();
			Cruiser cruiser = new Cruiser();
			Submarine submarine = new Submarine();
			Destroyer destroyer = new Destroyer();
			
			/*while(!gamephase) 
			{
				out.println("Place un bateau en suivant le format colonne, ligne");
				String message=in.readLine();
				out.println("René");
				String positionInText[] = message.split(",");
				int x = Integer.parseInt(positionInText[0]);
				int y = Integer.parseInt(positionInText[1]);
				out.println("Tu as placé un bateau à la position" + x + " " + y);
				gamephase = true;
				
			}*/
		}catch (Exception e) {}
	}
	
	public void Play() 
	{
		boolean isgameover = false;
		while(!isgameover) 
		{
			/*out.println("Place un bateau en suivant le format colonne, ligne");
			String message=in.readLine();
			String positionInText[] = message.split(",");
			int x = Integer.parseInt(positionInText[0]);
			int y = Integer.parseInt(positionInText[1]);
			*/
		}
	}
}
