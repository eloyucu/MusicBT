package Interfaz.Seleccion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Parsers.Results.ResultMachines;

@SuppressWarnings("serial")
public class seleccionMachines extends JFrame
{
	private JTable listaPresets;
    private JButton aceptar;
    private ArrayList <Integer> listaEnteros;
    
	public seleccionMachines(ResultMachines result, String nombre)
	{
		super( nombre );
		
		Container contenedor = getContentPane();
	    contenedor.setLayout( new FlowLayout() );

		String[][] relleno = rellenarTabla( result );
		String[] namesCol = {"MachineName", "Name", "XPos", "YPos", "TwPos"};
		
		listaPresets = new JTable(relleno,namesCol);
	    listaPresets.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
	    JScrollPane scroll = new JScrollPane(listaPresets);
	    scroll.setPreferredSize(new Dimension(500, 150));
	    scroll.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL,0,10,0,90));
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    contenedor.add( scroll );

		aceptar = new JButton("Aceptar");
	    aceptar.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		int i = listaPresets.getSelectedRow();
	    		if(!listaEnteros.contains(i)) {} //TODO
	    		setVisible(false);
	    	}
	    });
	    contenedor.add( aceptar );
	    
	    setSize( 700, 200 );
	    setVisible( true );
	}
	
	private String[][] rellenarTabla(ResultMachines result)
	{
		String[][] str = new String[result.getSize()][5];
		listaEnteros = new ArrayList<Integer>();
		
		for(int i=0; i<result.getSize(); i++)
		{
			if(result.getNombreMaq(i)!=null)
			{
				str[i][0]=result.getNombreMaq(i).toUpperCase();
				listaEnteros.add(i);
			}
			else
			{
				str[i][1] = result.getNombre(i);
				str[i][2] = result.getXPosition(i);
				str[i][3] = result.getYPosition(i);
				str[i][4] = result.getTwPosition(i);
			}
			
		}
		return str;
	}
}
