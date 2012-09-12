package Interfaz.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class Etiquetas extends JPanel
{
	private String[][] relleno = {{"Name of the Machine", "MACHINE"} , {"Name of the Preset", "PRESET"} };;
	private final String[] namesCol = {"","Value"};
	
	private final String titulo = "CHOOSEN";
	private final String tipoLetra= "Algerian";
	private final int diseñoLetra = 10;
	private final int tamañoLetra = 20;
	private final String icono ="C:\\Users\\chozas\\workspace\\MusicBT\\iconoValor.jpg";
	
	public Etiquetas()
	{	
		super ();
		
		setLayout(new BorderLayout());
		setBackground(java.awt.Color.white);
		
		construirEtiquetas();
	}
	
	public void construirEtiquetas()
	{
		JLabel etiquetaValores = new JLabel(titulo);
		etiquetaValores.setFont(new Font(tipoLetra,diseñoLetra,tamañoLetra));
		etiquetaValores.setIcon(new ImageIcon(icono));
		etiquetaValores.setHorizontalAlignment(JLabel.CENTER);
		add(etiquetaValores,BorderLayout.NORTH);
		
		JTable tabla = new JTable(relleno,namesCol);
	    tabla.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
	    JScrollPane scroll = new JScrollPane(tabla);
	    scroll.setPreferredSize(new Dimension(250, 51));
	    add( scroll , BorderLayout.CENTER);
	}
	
	public void setNamePreset(String preset)
	{
		relleno[1][1] = preset;
	}
	
	public void setNameMachine(String machine)
	{
		relleno[2][2] = machine;
	}

}
