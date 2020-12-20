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
	private List<Boat> boats;
	private String IP;
	private Grid ownGrid;
	private Grid adversaryGrid;
	private int id;
	private int currentXTarget;
	private int currentYTarget;
	
	BufferedReader in;
	PrintWriter out;
	
	public Joueur(int parId)
	{
		boats = new ArrayList<Boat>();
		ownGrid = new Grid(10);
		adversaryGrid = new Grid(10);
		
		id = parId;		
		
		Carrier carrier = new Carrier();
		Battleship battleship = new Battleship();
		Cruiser cruiser = new Cruiser();
		Submarine submarine = new Submarine();
		Destroyer destroyer = new Destroyer();
		
		boats.add(carrier);
		/*boats.add(battleship);
		boats.add(cruiser);
		boats.add(submarine);
		boats.add(destroyer);*/
		
		currentXTarget = -1;
		currentYTarget = -1;
	}
	
	public void SetOut(PrintWriter parOut)
	{
		out = parOut;
	}
	
	public void SetIn(BufferedReader parIn)
	{
		in = parIn;
	}
	
	public void AskBoatPlacement(Boat boat)
	{
		try 
		{
			String splitmessage[];
			do
			{				
				out.println("Veuillez placer le bateau de taille " + boat.GetSize() + " au format colonne, ligne, vertical (y/n)");
				String message = in.readLine();
				splitmessage = message.split(",");
			} while(splitmessage.length != 3);
			
			int x = Integer.parseInt(splitmessage[0]);
			int y = Integer.parseInt(splitmessage[1]);
			String vertical = splitmessage[2];
			
			boat.SetVertical(vertical.equals("y"));
			
			boat.SetX(x);
			boat.SetY(y);
		}
		catch (IOException e) {};
	}
	
	public void Shoot()
	{
		do
		{
			out.println("adversaryGrid : ");
			adversaryGrid.Display(out, false);
			AskShoot();
		} while(!adversaryGrid.IsShootValid(currentXTarget, currentYTarget));

		out.println("Je tire en " + currentXTarget + " " + currentYTarget);
		adversaryGrid.Shoot(currentXTarget, currentYTarget);

		currentXTarget = -1;
		currentYTarget = -1;
	}
	
	public void AskShoot()
	{
		try 
		{
			out.println("Indiquer une position de tir :");
			String message = in.readLine();
			String splitmessage[] = message.split(",");
			currentXTarget = Integer.parseInt(splitmessage[0]);
			currentYTarget = Integer.parseInt(splitmessage[1]);
		}
		catch (IOException e) {};
	}
	
	public void AddBoat(Boat boat)
	{
		boat.SetIsOnBoard(true);
		ownGrid.Placement(boat.GetX(),  boat.GetY(),  boat);
	}
	
	public void AddAllBoats()
	{
		for(Boat boat : boats)
		{
			while(!boat.GetIsOnBoard())
			{
				AskBoatPlacement(boat);
				AddBoat(boat);
				
				out.println("ownGrid : ");
				ownGrid.Display(out, true);				
			}
		}
	}
	
	public void Warning(String parMessage)
	{
		out.println(parMessage);
	}
	
	public boolean IsGameOver() // V�rifie si la partie est termin�e
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