package Facade;

import java.util.ArrayList;

public class Fachada 
{
	//private Conexion conexion;
	private static Fachada INSTANCE = null;
 
	/**
     * Private constructor suppresses 
     */
    private Fachada() 
    {
    }
 
    /**
     *  Creador sincronizado para protegerse de posibles problemas  multi-hilo
     *  otra prueba para evitar instanciación múltiple
     */ 
    private synchronized static void createInstance() 
    {
        if (INSTANCE == null) 
        { 
            INSTANCE = new Fachada();
        }
    }
 
    public static Fachada getInstancia() 
    {
        createInstance();
        return INSTANCE;
    }
	
	public ArrayList<String> listPorts()
	{
		//TODO
		return null;
	}
	
	public void configurarPuerto(String select)
	{
	}
	
	public void enviar (String select)
	{
	}
	
}
