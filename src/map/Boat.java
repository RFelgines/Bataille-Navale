package map;

abstract public class Boat
{
	private int Life;
	private int Size;
	private boolean IsVertical;
	private boolean IsOnBoard;
	private int x;
	private int y;
	
	protected Boat(int life)
	{
		Size = life;
		Life = life;
	}
	
	public int GetSize()
	{
		return Size;
	}

	public boolean IsVertical()
	{
		return IsVertical;
	}
	
	public void SetVertical(boolean isvertical) 
	{
		IsVertical = isvertical;
	}
	
	public void Setlife(int life)
	{
		Life = life;
	}
	
	public int GetLife()
	{
		return Life;
	}
	
	public void SetIsOnBoard(boolean parIsOnBoard)
	{
		IsOnBoard = parIsOnBoard;
	}
	
	public boolean GetIsOnBoard()
	{
		return IsOnBoard;
	}
	
	public void SetX(int parX)
	{
		x = parX;
	}
	
	public void SetY(int parY)
	{
		y = parY;
	}
	
	public int GetX()
	{
		return x;
	}
	
	public int GetY()
	{
		return y;
	}
}


