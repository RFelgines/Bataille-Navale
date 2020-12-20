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

enum GamePhase {PLACEMENT, GAMERUNNING, GAMEENDED}; 

public class ThreadChat extends Thread
{	
	int id;
	static ArrayList<Joueur> joueurs;
	GamePhase gamePhase;
	
	public ThreadChat(int id, Socket client)
	{
		joueurs = new ArrayList<Joueur>();
		try {
			Joueur newJoueur = new Joueur(joueurs.size());
			joueurs.add(newJoueur);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			newJoueur.SetIn(in);
			
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			newJoueur.SetOut(out);
			
			out.println("Id="+id+"\n");
			
			gamePhase = GamePhase.PLACEMENT;
		}
		catch (Exception e) {}
	}
	
	public void run()
	{
		try
		{
			if(gamePhase == GamePhase.PLACEMENT)
			{
				for(Joueur joueur : joueurs)
				{
					joueur.AddAllBoats();
				}
				gamePhase = GamePhase.GAMERUNNING;
				
				for(Joueur joueur : joueurs)
				{
					joueur.Warning("Tous les joueurs ont placés leurs bateaux");
				}
				
			}
			if(gamePhase == GamePhase.GAMERUNNING)
			{
				for(Joueur joueur : joueurs)
				{
					joueur.Warning("Nouveau tour de jeu");
					joueur.Shoot();
				}
				if(IsGameOver())
				{
					gamePhase = GamePhase.GAMEENDED;
				}
			}
			if(gamePhase == GamePhase.GAMEENDED)
			{
				//Dire au joueur que c'est fini
			}
		}
		catch (Exception e) {}
	}
	
	private boolean IsGameOver()
	{
		for(Joueur joueur : joueurs)
		{
			if(joueur.IsGameOver())
			{
				return true;
			}
		}
		return false;
	}
}
