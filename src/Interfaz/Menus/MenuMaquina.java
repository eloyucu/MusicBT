package Interfaz.Menus;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import Facade.Fachada;

import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MenuMaquina extends JMenu
{
	private Fachada fachada;
	
	private String[] nombresMaquinas;
	
	public MenuMaquina()
	{
		super("Machine");
		
		fachada = Fachada.getInstancia();
		
		crearTodoMenu();
	}
	
	public void crearTodoMenu()
	{		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("Search");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				ArrayList<String> list = fachada.listPorts();
				String [] str = (String[]) list.toArray();
				nombresMaquinas = str;
			}
		});
		add(menuItem);
		
		menuItem = new JMenuItem("Select");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				String seleccion = (String) JOptionPane.showInputDialog(
						   new JFrame(),
						   "Seleccione un puerto",
						   "Selector de opciones",
						   JOptionPane.QUESTION_MESSAGE,
						   null,  // null para icono defecto
						   nombresMaquinas,nombresMaquinas[0]);
				
				fachada.configurarPuerto(seleccion);
			}
		});
		add(menuItem);
		
		menuItem = new JMenuItem("Change Name");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				String seleccion = JOptionPane.showInputDialog(
						   new JFrame(),
						   "Escriba el nuevo nombre",
						   JOptionPane.QUESTION_MESSAGE);
				if(!seleccion.equals("")) System.out.println(seleccion);
				//TODO
				//fachada.cambiarNombreMaquina(select);
			}
		});
		add(menuItem);
	}
}
