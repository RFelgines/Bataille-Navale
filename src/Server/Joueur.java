package Server;

import map.Grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import map.Boat;

public class Joueur 
{
	private static List<Boat> boats;
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
	}
	
	public void SetOut(PrintWriter parOut)
	{
		out = parOut;
	}
	
	public void SetIn(BufferedReader parIn)
	{
		in = parIn;
	}
	
	public void AddBoat(Boat boat, int x, int y)
	{
		boats.add(boat);
		ownGrid.Placement(x,  y,  boat);
	}
	
	public void AskBoatPlacement(Boat boat) 
	{ 
		//IP.sendMessage();
	}
	
	public void PlaceBoat(Boat boat)
	{
			AskBoatPlacement(boat);
			
	}
	

	
	public boolean IsGameOver() 
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