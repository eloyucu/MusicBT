package Parsers.Input;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



public class JDOMFixSingle
{
	
	public JDOMFixSingle(String fichero, Positions position)
	{
		// Creamos el builder basado en SAX  
		SAXBuilder builder = new SAXBuilder();  
		// Construimos el arbol DOM a partir del fichero xml  
		Document doc;
		try 
		{
			doc = builder.build(new FileInputStream(fichero));
			// Obtenemos la etiqueta raíz  
		    Element machines = doc.getRootElement();  
		    
		 // Recorremos los hijos de la etiqueta raíz  
		    List<Element> machine = machines.getChildren("Machine");  
		    for(Element m: machine)
		    {  
		       Element name;
		       if((name = m.getChild("nameM"))!=null && name.getText().equals(position.getNameMachine()))
		       {
		    	   Element Presets = guardarPreset(m.getChild("Presets").detach(), position);
		    	   m.addContent(Presets);
		    	   guardarXML(fichero,doc);
		    	   return;
		       }
		    } 
		    crearNuevoElemento(machines, position);
	    	guardarXML(fichero,doc);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (JDOMException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}  
	}
	private void crearNuevoElemento(Element machines,Positions position)
	{
		Element machine = new Element("Machine");
		Element element = new Element("nameM");
		element.setText(position.getNameMachine()); 
		machine.addContent(element);
		
		Element Presets = guardarPreset(new Element("Presets"), position);
		machine.addContent(Presets);
		
		machines.addContent(machine);
	}
	private Element guardarPreset(Element Presets, Positions position)
	{
		Element preset = new Element("Preset");
	    	Element element;
	    
		    element = new Element("nameP");
		    element.setText(position.getNamePreset()); 
		    preset.addContent(element);
		    
		    element = new Element("XPosition");
		    element.setText(position.getXPosition()); 
		    preset.addContent(element);
		    
		    element = new Element("YPosition");
		    element.setText(position.getYPosition()); 
		    preset.addContent(element);
		    
		    element = new Element("TwPosition");
		    element.setText(position.getTWPosition()); 
		    preset.addContent(element);
		    
		    Presets.addContent(preset);
		    
		    return Presets;
	}
	private void guardarXML(String fichero,Document doc)
	{
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
}
