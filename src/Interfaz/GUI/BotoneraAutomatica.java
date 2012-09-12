package Interfaz.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Facade.Fachada;

@SuppressWarnings("serial")
public class BotoneraAutomatica extends JPanel
{
	private final String titulo = "AUTOMATIC";
	private final String tipoLetra= "Algerian";
	private final int diseñoLetra = 10;
	private final int tamañoLetra = 20;
	private final String icono ="C:\\Users\\chozas\\workspace\\MusicBT\\iconoAuto.jpg";
	private final String[] types ={"FB","UD","TW"};
	
	private String type;
	
	private JLabel etiquetaValorFB;
	private JLabel etiquetaValorUD;
	private JLabel etiquetaValorTw;
	
	private Fachada fachada;
	

	public BotoneraAutomatica()
	{
		super();
		fachada = Fachada.getInstancia();
		
		setLayout(new BorderLayout());
		setBackground(java.awt.Color.white);
		
		construirBotonera();
		
	}
	
	private void construirBotonera()
	{
		
		JLabel etiquetaAuto = new JLabel(titulo);
		etiquetaAuto.setFont(new Font(tipoLetra,diseñoLetra,tamañoLetra));
		etiquetaAuto.setIcon(new ImageIcon(icono));
		etiquetaAuto.setHorizontalAlignment(JLabel.CENTER);
		add(etiquetaAuto,BorderLayout.NORTH);
		
		JPanel panelInfo = new JPanel(new GridLayout(3,3));
		panelInfo.setBackground(java.awt.Color.white);
		
		JLabel etiquetaNombre;
		etiquetaNombre= new JLabel("Forward/Backward");
		etiquetaValorFB = new JLabel("Valor F/B");
		panelInfo.add(etiquetaNombre);
		panelInfo.add(etiquetaValorFB);
		panelInfo.add(botonSet(types[0],"Set Position"));
		
		etiquetaNombre = new JLabel("Up/Down");
		etiquetaValorUD = new JLabel("Valor U/D");
		panelInfo.add(etiquetaNombre);
		panelInfo.add(etiquetaValorUD);
		panelInfo.add(botonSet(types[1],"Set Height"));
		
		etiquetaNombre = new JLabel("Twirl");
		etiquetaValorTw = new JLabel("Valor Tw");
		panelInfo.add(etiquetaNombre);
		panelInfo.add(etiquetaValorTw);
		panelInfo.add(botonSet(types[2],"Set Twirl"));
		
		add(panelInfo,BorderLayout.CENTER);
	}
	
	private JButton botonSet(String typeAuto, String name)
	{
		JButton botonSet = new JButton(name);
		type = typeAuto;
		botonSet.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String seleccion = JOptionPane.showInputDialog(
						   new JFrame(),
						   "",
						   JOptionPane.QUESTION_MESSAGE);
				if(seleccion!=null)
				{
					System.out.print("Enviando mensaje...");
					
					if(type.equals(types[0])){fachada.enviar(seleccion);}
					if(type.equals(types[1])){fachada.enviar(seleccion);}
					if(type.equals(types[2])){fachada.enviar(seleccion);}
					
					System.out.println("Mensaje enviado");
				}
			}
		});
		
		return botonSet;
	}
	
	public void setEtiquetaFB(String texto)
	{
		etiquetaValorFB.setText(texto);
	}
	
	public void setEtiquetaUD(String texto)
	{
		etiquetaValorUD.setText(texto);
	}
	
	public void setEtiquetaTw(String texto)
	{
		etiquetaValorTw.setText(texto);
	}
}
