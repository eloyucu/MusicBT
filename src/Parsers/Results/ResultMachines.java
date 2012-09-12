package Parsers.Results;

import java.util.ArrayList;

public class ResultMachines
{
	private ArrayList<String> nombresMaq;
	private ArrayList<String> nombres;
	private ArrayList<String> XPositions;
	private ArrayList<String> YPositions;
	private ArrayList<String> TwPositions;
	
	public ResultMachines()
	{
		nombresMaq  = new ArrayList<String>();
		nombres     = new ArrayList<String>();
		XPositions  = new ArrayList<String>();
		YPositions  = new ArrayList<String>();
		TwPositions = new ArrayList<String>();
	}
	
	public void addNombreMaq(String nombre, int i)
	{
		nombresMaq.add(i,nombre);
	}
	
	public void addNombre(String nombre, int i)
	{
		//System.out.println("Contador= " + i + " Tamaño: " + nombres.size());
		nombres.add(i,nombre);
	}
	
	public void addXPosition(String XPosition, int i)
	{
		XPositions.add(i,XPosition);
	}
	
	public void addYPosition(String YPosition, int i)
	{
		YPositions.add(i,YPosition);
	}
	
	public void addTwPosition(String TwPosition, int i)
	{
		TwPositions.add(i,TwPosition);
	}
	
	
	public String getNombreMaq(int i)
	{
		return nombresMaq.get(i);
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
			if(nombresMaq.get(i)!=null)System.out.println("Nombre Máquina: " + nombresMaq.get(i));
			else
			{
				System.out.print("Nombre: " + nombres.get(i));
				System.out.print("XPosition: "  + XPositions.get(i));
				System.out.print("YPosition: "  + YPositions.get(i));
				System.out.println("TwPosition: " + TwPositions.get(i));
			}
		}
	}
}

