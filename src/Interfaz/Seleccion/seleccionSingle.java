package Interfaz.Seleccion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Parsers.Results.ResultSingle;

@SuppressWarnings("serial")
public class seleccionSingle extends JFrame
{
	private JTable listaPresets;
    private JButton aceptar;
    
	public seleccionSingle(ResultSingle result, String nombre)
	{
		super( nombre );
		
		Container contenedor = getContentPane();
	    contenedor.setLayout( new FlowLayout() );

		String[][] relleno = rellenarTabla( result );
		String[] namesCol = {"Name", "XPos", "YPos", "TwPos"};
		
		listaPresets = new JTable(relleno,namesCol);
	    listaPresets.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
	    JScrollPane scroll = new JScrollPane(listaPresets);
	    scroll.setPreferredSize(new Dimension(500, 100));
	    scroll.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL,0,10,0,90));
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    contenedor.add( scroll );

		aceptar = new JButton("Aceptar");
	    aceptar.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		@SuppressWarnings("unused")
				int i = listaPresets.getSelectedRow();
	    		//TODO
	    		setVisible(false);
	    	}
	    });
	    contenedor.add( aceptar );
	    
	    setSize( 700, 200 );
	    setVisible( true );
	}
	
	private String[][] rellenarTabla(ResultSingle result)
	{
		String[][] str = new String[result.getSize()][4];
		for(int i=0; i<result.getSize(); i++)
		{
			str[i][0] = result.getNombre(i);
			str[i][1] = result.getXPosition(i);
			str[i][2] = result.getYPosition(i);
			str[i][3] = result.getTwPosition(i);
			
		}
		return str;
	}
}
