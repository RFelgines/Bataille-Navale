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

enum GamePhase {WAITING,PLACEMENT, GAMERUNNING, GAMEENDED}; 

public class ThreadChat extends Thread
{	
	int id;
	ArrayList<Joueur> joueurs;
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
			
			gamePhase = GamePhase.WAITING;
		}
		catch (Exception e) {}
	}
	
	public void run()
	{
		try
		{
			if(gamePhase == GamePhase.WAITING)
			{
				do
				{					
					for(Joueur joueur : joueurs)
					{
						joueur.Warning("En attente d'un autre joueur.");
					}
					sleep(1000);
				} while(joueurs.size() != 2);
			}
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
				do
				{					
					for(Joueur joueur : joueurs)
					{
						joueur.Warning("Nouveau tour de jeu");
						joueur.Shoot();
					}
				} while(!IsGameOver());
				
				gamePhase = GamePhase.GAMEENDED;
			}
			if(gamePhase == GamePhase.GAMEENDED)
			{
				for(Joueur joueur : joueurs)
				{
					joueur.Warning("Fin de la partie");
				}
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
