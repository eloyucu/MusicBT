package Interfaz.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Facade.Fachada;

@SuppressWarnings("serial")
public class BotoneraManual extends JPanel
{
	private final String titulo = "MANUAL";
	private final String tipoLetra= "Algerian";
	private final int disenoLetra = 10;
	private final int tamanoLetra = 20;
	private final String icono ="C:\\Users\\chozas\\workspace\\MusicBT\\iconoManual.jpg";
	private final String[] types={"UP","DW","FW","BK","TL","TR"};
	
	private String type;
	
	private Fachada fachada;
	
	public BotoneraManual()
	{
		super();
		fachada = Fachada.getInstancia();

		setLayout(new BorderLayout());
		setBackground(java.awt.Color.white);
		
		construirBotonera();
	}
	
	public void construirBotonera()
	{
		
		JLabel etiquetaManual = new JLabel(titulo);
		etiquetaManual.setBackground(java.awt.Color.white);
		
		etiquetaManual.setFont(new Font(tipoLetra,disenoLetra,tamanoLetra));
		etiquetaManual.setIcon(new ImageIcon(icono));
		etiquetaManual.setHorizontalAlignment(JLabel.CENTER);
		add(etiquetaManual,BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel(new GridLayout(3,2));
		
		panelBotones.add(botonSet(types[0],"Up"));
		panelBotones.add(botonSet(types[2],"Forward"));
		panelBotones.add(botonSet(types[4],"Twist Left"));
		panelBotones.add(botonSet(types[5],"Twist Rigth"));
		panelBotones.add(botonSet(types[1],"Down"));
		panelBotones.add(botonSet(types[3],"Backward"));
		
		add(panelBotones,BorderLayout.CENTER);
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
					System.out.print("Enviando mensaje...");
					
					if(type.equals(types[0])){fachada.enviar("ARRIBA");}
					if(type.equals(types[1])){fachada.enviar("ABAJO");}
					if(type.equals(types[2])){fachada.enviar("ALANTE");}
					if(type.equals(types[3])){fachada.enviar("ATR�S");}
					if(type.equals(types[4])){fachada.enviar("IZQUIERDA");}
					if(type.equals(types[5])){fachada.enviar("DERECHA");}
					
					System.out.println("Mensaje enviado");
			}
		});
		
		return botonSet;
	}
}
