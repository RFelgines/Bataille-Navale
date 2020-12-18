package map;

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
	
	public void Display()
	{
		if(IsShot && ContainsBoat)
			System.out.printf("*");

		if(IsShot && !ContainsBoat)
			System.out.printf("0");

		if(!IsShot && ContainsBoat)
			System.out.printf("?");

		if(!IsShot && !ContainsBoat)
			System.out.printf("~");
	}
}
