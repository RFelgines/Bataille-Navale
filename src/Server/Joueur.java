package Server;

import map.Grid;
import map.Submarine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import map.Battleship;
import map.Boat;
import map.Carrier;
import map.Cruiser;
import map.Destroyer;

public class Joueur 
{
	private static List<Boat> boats;
	private static List<Boat> allboats;
	private String IP;
	private Grid ownGrid;
	private Grid adversaryGrid;
	private int id;
	BufferedReader in;
	PrintWriter out;
	
	public Joueur(int parId)
	{
		boats = new ArrayList<Boat>();
		ownGrid = new Grid(10);
		id = parId;
		
		// RAJOUTE PAR MOI
		allboats = new ArrayList<Boat>();
		Carrier carrier = new Carrier();
		Battleship battleship = new Battleship();
		Cruiser cruiser = new Cruiser();
		Submarine submarine = new Submarine();
		Destroyer destroyer = new Destroyer();
		allboats.add(carrier);
		allboats.add(battleship);
		allboats.add(cruiser);
		allboats.add(submarine);
		allboats.add(destroyer);
		
		// FIN
	}
	
	public void SetOut(PrintWriter parOut)
	{
		out = parOut;
	}
	
	public void SetIn(BufferedReader parIn)
	{
		in = parIn;
	}
	
	public void AddBoat(Boat boat, int x, int y) // Tu voulais faire quoi dans c'te fonction ?
	{
		boats.add(boat);
		ownGrid.Placement(x,  y,  boat);
	}
	
	public void AddBoats() 
	{
		for(Boat boat : allboats) 
		{
			// AddBoat(boat, x, y);
		}
	}
	
	public void AskBoatPlacement(Boat boat) 
	{ 
		try 
		{
			String message=in.readLine();
			String positionInText[] = message.split(",");
			int x = Integer.parseInt(positionInText[0]);
			int y = Integer.parseInt(positionInText[1]);
		}
		catch (IOException e) {};


	}
	
	public void PlaceBoat(Boat boat)
	{
			AskBoatPlacement(boat);
			
	}
	

	
	public boolean IsGameOver() // Vérifie si la partie est terminée
	{
		for(Boat boat : boats)
		{
			if(boat.GetLife() != 0)
			{
				return false;
			}
		}
		
		return true;
	}
}