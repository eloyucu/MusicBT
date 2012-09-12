package Parsers.Results;

import java.util.ArrayList;

public class ResultJoint 
{
	private ArrayList<String> nombresPresets;
	private ArrayList<String> nombresMaq;
	private ArrayList<String> XPositions;
	private ArrayList<String> YPositions;
	private ArrayList<String> TwPositions;
	
	public ResultJoint()
	{
		nombresPresets  = new ArrayList<String>();
		nombresMaq     = new ArrayList<String>();
		XPositions  = new ArrayList<String>();
		YPositions  = new ArrayList<String>();
		TwPositions = new ArrayList<String>();
	}
	
	public void addNombrePreset(String nombre, int i)
	{
		nombresPresets.add(i,nombre);
	}
	
	public void addNombreMaq(String nombre, int i)
	{
		//System.out.println("Contador= " + i + " Tamaño: " + nombresMaq.size());
		nombresMaq.add(i,nombre);
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

	public String getNombrePreset(int i)
	{
		return nombresPresets.get(i);
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
		return nombresMaq.size();
	}
	
	public void print()
	{
		for(int i=0; i<nombresMaq.size(); i++)
		{
			if(nombresPresets.get(i)!=null)System.out.println("Nombre Máquina: " + nombresPresets.get(i));
			else
			{
				System.out.print("Nombre: " + nombresMaq.get(i));
				System.out.print("XPosition: "  + XPositions.get(i));
				System.out.print("YPosition: "  + YPositions.get(i));
				System.out.println("TwPosition: " + TwPositions.get(i));
			}
		}
	}
}
