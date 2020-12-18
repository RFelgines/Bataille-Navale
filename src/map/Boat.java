package map;

abstract public class Boat
{
	private int Life;
	private int Size;
	private boolean IsVertical;
	
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
}


