package Parsers.Output;

import java.io.FileInputStream;  
import java.io.IOException;  

import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler;  
import org.xml.sax.InputSource;   
import org.xml.sax.XMLReader;  
import org.xml.sax.helpers.XMLReaderFactory;

import Parsers.Results.ResultSingle;
  
/** 
 * Manejador de eventos SAX de ejemplo. 
 *  
 * @author Xela 
 * 
 */  
public class SAXParserSingleMachine extends DefaultHandler
{  
	private String nombreMaq;
	private boolean nameMachineFlag = false;
	private int type = 0;
	private ResultSingle result;
	
	public SAXParserSingleMachine(String fichero, String nombreMaq) 
	{  
		  this.nombreMaq = nombreMaq;
		  result = new ResultSingle();
		  
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
	   
   }  
     
   @Override  
   public void characters(char[] ch, int start, int length) throws SAXException 
   {  
	   
	   String str = String.valueOf(ch, start, length);
	   if(nameMachineFlag && !str.startsWith("\n"))
	   {
		   switch(type)
		   {
		   		case 0: result.addNombre(str);	  type=1; break;
		   		case 1: result.addXPosition(str); type=2; break;
		   		case 2: result.addYPosition(str); type=3; break;
		   		case 3: result.addTwPosition(str);type=0; break;
		   		default: break;
		   } 
	   }
	   if(nombreMaq.equals(str))
	   {
		   nameMachineFlag = true;
	   }
      
   }  
  
   @Override  
   public void endElement(String uri, String localName, String name) throws SAXException 
   {  
	   if(localName.equals("Machine"))
	   {
		   nameMachineFlag = false;
	   }
   }  
   
   public ResultSingle getResult()
   {
	   return result;
   }
}  