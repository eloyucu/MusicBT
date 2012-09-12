package Parsers.Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMFixJoint 
{

	public JDOMFixJoint( String fichero,ArrayList<Positions> positions)
	{
		// Creamos el builder basado en SAX  
		SAXBuilder builder = new SAXBuilder();  
		// Construimos el arbol DOM a partir del fichero xml  
		Document doc;
		try 
		{
			doc = builder.build(new FileInputStream(fichero));
			// Obtenemos la etiqueta raíz  
		    Element presets = doc.getRootElement();  
		    
		    Element preset =new Element("Preset");
		    Element elemento = new Element("nameP");
		    elemento.addContent(positions.get(0).getNamePreset());
		    preset.addContent(elemento);
		    
		    Element machines = new Element("Machines");
		    
		    for(Positions p:positions)
		    {
		    	Element machine = new Element("Machine");
		    	
		    	elemento = new Element("nameM");
		    	elemento.addContent(p.getNameMachine());
		    	machine.addContent(elemento);
		    	
		    	elemento = new Element("XPosition");
		    	elemento.addContent(p.getXPosition());
		    	machine.addContent(elemento);
		    	
		    	elemento = new Element("YPosition");
		    	elemento.addContent(p.getYPosition());
		    	machine.addContent(elemento);

		    	elemento = new Element("TwPosition");
		    	elemento.addContent(p.getTWPosition());
		    	machine.addContent(elemento);
		    	
		    	machines.addContent(machine);
		    }
		    preset.addContent(machines);
		    presets.addContent(preset);
		    
		    XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			File nuevoXML = new File(fichero);
			try
			{
				FileOutputStream file = new FileOutputStream(nuevoXML);
				out.output(doc, file);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}   
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (JDOMException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	     
	}
}
