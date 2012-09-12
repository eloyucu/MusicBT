package Interfaz;

import Facade.Fachada;
import Interfaz.GUI.BotoneraAutomatica;
import Interfaz.GUI.BotoneraManual;
import Interfaz.GUI.Etiquetas;
import Interfaz.Menus.MenuMaquina;
import Interfaz.Menus.MenuPresets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import java.awt.*; 
import java.awt.event.*;

public class VentanaTotal 
{
	private JFrame ventana;
	private Container contenedor;
	private GridBagLayout esquema;
	private GridBagConstraints restricciones;
	
	@SuppressWarnings("unused")
	private Fachada fachada;
	private BotoneraAutomatica botoneraAutomatica;
	private BotoneraManual botoneraManual;
	private Etiquetas etiquetas;
	
	
	@SuppressWarnings("deprecation")
	public VentanaTotal()
	{
		fachada = Fachada.getInstancia();
		
		crearVentana();
		crearMenu();
		crearEtiquetas();
		crearBotoneraAutomatica();
		crearBotoneraManual();

		ventana.show();
		//ventana.setVisible(true);
		//ventana.pack();
	}
	
	
	public void crearVentana()
	{
		ventana = new JFrame("COOL FOOT BT");
		ventana.setBackground(java.awt.Color.blue);
		ventana.addWindowListener(new WindowAdapter() {	public void windowClosing(WindowEvent e) {System.exit(0);} });
		
		esquema = new GridBagLayout();
		restricciones = new GridBagConstraints();
		contenedor = ventana.getContentPane();
		contenedor.setBackground(java.awt.Color.white);
		contenedor.setLayout (esquema);	
		
		ventana.setSize(700,500);
	}

	private void crearMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		
		MenuMaquina menuMaquina = new MenuMaquina();
		menuBar.add(menuMaquina);
		
		MenuPresets menuPresets = new MenuPresets();
		menuBar.add(menuPresets);
		
		ventana.setJMenuBar(menuBar);
	}
	
	private void crearEtiquetas()
	{
		etiquetas = new Etiquetas();
		restricciones.weightx = 1; // Puede hacerse más ancho
		restricciones.weighty = 1; // Puede hacerse más largo
		restricciones.anchor = GridBagConstraints.EAST;
		agregarComponente(etiquetas,0,2,1,1);		
	}
	
	private void crearBotoneraAutomatica()
	{
		botoneraAutomatica = new BotoneraAutomatica();
		restricciones.fill = GridBagConstraints.HORIZONTAL;
		restricciones.weightx = 1; // puede hacerse más ancho
		restricciones.weighty = 1; // puede hacerse más largo
		restricciones.anchor = GridBagConstraints.CENTER;
		agregarComponente(botoneraAutomatica,1,0,3,1);
		
	}
	
	private void crearBotoneraManual()
	{
		botoneraManual = new BotoneraManual();
		
		restricciones.fill = GridBagConstraints.NONE;
		restricciones.weightx = 1; // puede hacerse más ancho
		restricciones.weighty = 1; // puede hacerse más largo
		restricciones.anchor = GridBagConstraints.CENTER;
		agregarComponente(botoneraManual,2,2,1,1);
	}
	
	private void agregarComponente( Component componente,
			int fila, int columna, int anchura, int altura )
			{
				// establecer gridx y gridy
				restricciones.gridx = columna;
				restricciones.gridy = fila;
				// establecer gridwidth y gridheight
				restricciones.gridwidth = anchura;
				restricciones.gridheight = altura;
				//establecer restricciones y agregar componente
				esquema.setConstraints( componente, restricciones );
				contenedor.add( componente );
			}
}
