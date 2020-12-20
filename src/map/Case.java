package map;

import java.io.PrintWriter;

public class Case {
	private boolean IsShot;
	private boolean ContainsBoat;
	private int idBoat;
	
	public boolean GetIsShot()
	{
		return IsShot;
	}
	public void SetIsShot(boolean isShot) 
	{
		IsShot = isShot;
	}
	
	public boolean GetContainsBoat()
	{
		return ContainsBoat;
	}

	public void SetContainsBoat(boolean containsBoat)
	{
		ContainsBoat = containsBoat;
	}

	
	public void SetidBoat(int IdBoat)
	{
		idBoat = IdBoat;
	}

	public int GetidBoat() 
	{
		return idBoat;
	}
	
	public void Display(PrintWriter parOut)
	{
		if(IsShot && ContainsBoat)
			parOut.printf("*");

		if(IsShot && !ContainsBoat)
			parOut.printf("0");

		if(!IsShot && ContainsBoat)
			parOut.printf("?");

		if(!IsShot && !ContainsBoat)
			parOut.printf("~");
	}
}
