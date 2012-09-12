package Interfaz.Menus;


import javax.swing.JMenuItem;
import javax.swing.JMenu;

import Facade.Fachada;
import Interfaz.Seleccion.seleccionJoint;
import Interfaz.Seleccion.seleccionMachines;
import Interfaz.Seleccion.seleccionSingle;
import Parsers.Input.JDOMFixJoint;
import Parsers.Input.JDOMFixSingle;
import Parsers.Input.Positions;
import Parsers.Output.SAXParserJoint;
import Parsers.Output.SAXParserMachines;
import Parsers.Output.SAXParserSingleMachine;
import Parsers.Results.ResultJoint;
import Parsers.Results.ResultMachines;
import Parsers.Results.ResultSingle;

import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MenuPresets extends JMenu
{
	@SuppressWarnings("unused")
	private Fachada fachada;
	private final String ficheroSingle = "C:\\Users\\chozas\\workspace\\MusicBT\\src\\Parsers\\Output\\BaseSingle.xml";
	private final String ficheroJoint = "C:\\Users\\chozas\\workspace\\MusicBT\\src\\Parsers\\Output\\BaseJoint.xml";
	
	public MenuPresets()
	{
		super("Presets");
		fachada = Fachada.getInstancia();
		crearTodoMenu();
	}
	
	public void crearTodoMenu()
	{		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("Single Preset Fix");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				
				Positions position = new Positions();
				//TODO
				@SuppressWarnings("unused")
				JDOMFixSingle singleJ = new JDOMFixSingle(ficheroSingle,position);
			}
		});
		add(menuItem);
		
		menuItem = new JMenuItem("Use Single Preset");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				
				SAXParserSingleMachine parser = new SAXParserSingleMachine(ficheroSingle,"guitar");
				ResultSingle result = parser.getResult();
				
				new seleccionSingle(result,"Select a Single Preset");;
			}
		});
		add(menuItem);
		
		menuItem = new JMenuItem("Use Single-Total Preset");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				
				SAXParserMachines parser = new SAXParserMachines(ficheroSingle);
				ResultMachines result = parser.getResult();
				
				new seleccionMachines(result,"Select a Preset");
			}
		});
		add(menuItem);
		
		menuItem = new JMenuItem("Joint Preset Fix");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				ArrayList<Positions> positions = new ArrayList<Positions>();
				//TODO
				@SuppressWarnings("unused")
				JDOMFixJoint JointJ = new JDOMFixJoint(ficheroJoint,positions);
			}
		});
		add(menuItem);
		
		menuItem = new JMenuItem("Use Joint Preset");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				
				SAXParserJoint parser = new SAXParserJoint(ficheroJoint);
				ResultJoint result = parser.getResult();
				
				new seleccionJoint(result,"Select a Preset");
			}
		});
		add(menuItem);
	}
}
