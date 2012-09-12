package Parsers.Results;

import java.util.ArrayList;

public class ResultSingle 
{
	private ArrayList<String> nombres;
	private ArrayList<String> XPositions;
	private ArrayList<String> YPositions;
	private ArrayList<String> TwPositions;
	
	public ResultSingle()
	{
		nombres    = new ArrayList<String>();
		XPositions  = new ArrayList<String>();
		YPositions  = new ArrayList<String>();
		TwPositions = new ArrayList<String>();
	}
	
	public void addNombre(String nombre)
	{
		nombres.add(nombre);
	}
	
	public void addXPosition(String XPosition)
	{
		XPositions.add(XPosition);
	}
	
	public void addYPosition(String YPosition)
	{
		YPositions.add(YPosition);
	}
	
	public void addTwPosition(String TwPosition)
	{
		TwPositions.add(TwPosition);
	}
	
	
	public String getNombre(int i)
	{
		return nombres.get(i);
	}
	
	public String getXPosition(int i)
	{
		return XPositions.get(i);
	}
	
	public String getYPosition(int i)
	{
		return YPositions.get(i);
	}
	
	public String getTwPosition(int i)
	{
		return TwPositions.get(i);
	}

	public int getSize()
	{
		return nombres.size();
	}
	
	public void print()
	{
		for(int i=0; i<nombres.size(); i++)
		{
			System.out.println("Nombre: " + nombres.get(i));
			System.out.println("XPosition: "  + XPositions.get(i));
			System.out.println("YPosition: "  + YPositions.get(i));
			System.out.println("TwPosition: " + TwPositions.get(i));
		}
	}
}
