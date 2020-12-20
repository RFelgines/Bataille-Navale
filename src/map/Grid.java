package map;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Grid
{
	private List<List<Case>> _grid;

	public Grid(int size)
	{
		_grid = new ArrayList<List<Case>>();
		for(int i = 0; i < size; ++i)
		{
			_grid.add(new ArrayList<Case>());
			for(int j = 0; j < size; ++j)
			{
				_grid.get(i).add(new Case());
			}
		}
	}
		
	public boolean IsPlacementValid(int x, int y, Boat boat) 
	/* Vérifie que le placement d'un bateau est valide
	 * Le placement est valide si le bateau ne sort pas de la carte
	 * Et si le bateau ne se superpose pas avec un autre
	 */
	{
		for(int i = 0; i< boat.GetSize(); ++i)
		{
			if(x < 0 || y < 0 || x >= _grid.size() || y >= _grid.get(0).size() || _grid.get(x).get(y).GetContainsBoat()) // Verifier, peut être size() -1 limite
				return false;
	
			if(boat.IsVertical())
				++x;
			else
				++y;
		}
		
		return true;
	}
	
	public void Placement(int x, int y, Boat boat)
	// Place le bateau sur la grille à condition que le placement soit valide
	{
		if (!IsPlacementValid(x, y, boat)) 
		{
			return;
		}
		
		for(int i = 0; i< boat.GetSize(); ++i)
		{
			_grid.get(x).get(y).SetContainsBoat(true);
	
			if(boat.IsVertical())
				++x;
			else
				++y;
		}
		
	}
	
	public void Shoot(int x, int y) // Tire sur une case à condition qu'elle n'ait pas déjà été touchée
	{
		if (IsShootValid(x, y))
		{
			_grid.get(x).get(y).SetIsShot(true);
		}
	}
	
	public boolean IsShootValid(int x, int y) // Tire sur une case à condition qu'elle n'ait pas déjà été touchée
	{
		if (_grid.get(x).get(y).GetIsShot()) // Case déjà touchée
		{
			return false;
		}
		if ( x < 0 || y < 0 || x >= _grid.size() || y >= _grid.size()) 
		{
			return false;
		}
		return true;
	}
	
	public void Display(PrintWriter parOut, boolean isOwnerGrid) // Affiche la grille
	{
		for(List<Case> ligne : _grid)
		{
			for(Case myCase : ligne)
			{
				myCase.Display(parOut, isOwnerGrid);
			}
			parOut.println("");
			
		}
	}
	
	public void DebugDisplay() 
	{
		for(List<Case> ligne : _grid)
		{
			for(Case myCase : ligne)
			{
				myCase.DebugDisplay();
			}
			System.out.println("");
		}	
	}

}


