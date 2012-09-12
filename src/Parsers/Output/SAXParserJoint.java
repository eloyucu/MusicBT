package Parsers.Output;

import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import Parsers.Results.ResultJoint;

public class SAXParserJoint extends DefaultHandler
{
	private boolean machineFlag = false;
	private int type = 0;
	private int contador = 0;
	private ResultJoint result;
	
	public SAXParserJoint(String fichero) 
	{  
		  result = new ResultJoint();
		  
	      try 
	      {  
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         // Añadimos nuestro manejador al reader  
	         reader.setContentHandler(this);           
	         // Procesamos el xml de ejemplo  
	         reader.parse(new InputSource(new FileInputStream(fichero)));  
	      } 
	      catch (SAXException e) 
	      {  
	         e.printStackTrace();  
	      } 
	      catch (IOException e) 
	      {  
	         e.printStackTrace();  
	      }  
	  
	   }  
  
   @Override  
   public void startDocument() throws SAXException 
   {  
      //System.out.println("\nPrincipio del documento...");  
   }  
  
   @Override  
   public void endDocument() throws SAXException 
   {  
      //System.out.println("\nFin del documento...");  
   }  
  
   @Override  
   public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException 
   { 
	   if(localName.equals("Machines"))
	   {
		   machineFlag = true;
	   }
   }  
     
   @Override  
   public void characters(char[] ch, int start, int length) throws SAXException 
   {  
	   String str = String.valueOf(ch, start, length);
	   
	   
	   if(!str.startsWith("\n"))
	   {
		   if(!machineFlag)
		   {
			   result.addNombrePreset(str,contador);
			   
			   result.addNombreMaq(null,contador);	  
			   result.addXPosition(null,contador);
			   result.addYPosition(null,contador);
			   result.addTwPosition(null,contador);
			   contador++;
		   }
		   else
		   {
			   switch(type)
			   {
			   		case 0: result.addNombreMaq(str,contador);	   type=1; break;
			   		case 1: result.addXPosition(str,contador); type=2; break;
			   		case 2: result.addYPosition(str,contador); type=3; break;
			   		case 3: 
			   			result.addTwPosition(str,contador);
			   			result.addNombrePreset(null,contador);
			   			type=0; 
			   			contador++; 
			   			break;
			   		default: break;
			   }
		   }
	   }
      
   }  
  
   @Override  
   public void endElement(String uri, String localName, String name) throws SAXException 
   {  
	   if(localName.equals("Machines"))
	   {
		   machineFlag = false;
	   }
   }  
   
   public ResultJoint getResult()
   {
	   return result;
   }
}
