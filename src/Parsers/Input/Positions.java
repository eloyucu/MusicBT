package Parsers.Input;

public class Positions 
{
	private String [] position;
	
	public Positions()
	{
		position = new String [5];
	}
	public Positions(String nameMachine, String namePreset, String XPos, String YPos, String TwPos)
	{
		position = new String [5];
		position[0] = nameMachine;
		position[1] = namePreset;
		position[2] = XPos;
		position[3] = YPos;
		position[4] = TwPos;
	}
	public Positions(String[] position)
	{
		this.position=position;
	}
	
	
	public String getNameMachine()
	{
		return position[0];
	}
	
	public String getNamePreset()
	{
		return position[1];
	}
	
	public String getXPosition()
	{
		return position[2];
	}
	
	public String getYPosition()
	{
		return position[3];
	}
	
	public String getTWPosition()
	{
		return position[4];
	}
	
	
	
	public void addNameMachine(String nameMachine)
	{
		position[0] = nameMachine;
	}
	
	public void addNamePreset(String namePreset)
	{
		position[1] = namePreset;
	}
	
	public void addXPosition(String Xpos)
	{
		position[2]=Xpos;
	}
	public void addYPosition(String Ypos)
	{
		position[3]=Ypos;
	}
	public void addTWPosition(String Twpos)
	{
		position[4]=Twpos;
	}
}
