package Comunicacion;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DataElement;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;

public class Listener implements DiscoveryListener
{
	private ArrayList<RemoteDevice> remotes;
	private DiscoveryAgent agent;
	
	private Object lockServicios;
	private Object lockDispositivos;
	
	public static final UUID SERVICIO_MUSEO = new UUID(0x1234);
	public static final int ATRIBUTO_LISTADO_OBRAS = 0x4321;
	public static final UUID[] SERVICIOS = new UUID[]{ SERVICIO_MUSEO };
	public static final int[] ATRIBUTOS = new int[]{ ATRIBUTO_LISTADO_OBRAS };
	
	public Listener (Object lockDispositivos,ArrayList<RemoteDevice> remotes, DiscoveryAgent agent)
	{
		this.agent = agent;
		this.remotes = remotes;
		
		this.lockDispositivos = lockDispositivos;
		lockServicios = new Object();
	}
	
	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) 
	{
		try
		{
			System.out.println("Dispositivo: ");
			System.out.println(btDevice.getFriendlyName(true));
		}
		catch(Exception e){e.printStackTrace();}
		//add the device to the vector
		if(!remotes.contains(btDevice))
		{
			remotes.add(btDevice);
		}
		
		try 
		{
			int transId = agent.searchServices(ATRIBUTOS, SERVICIOS, btDevice, this);
			System.out.println("Comenzada busqueda de serivicios en: "+btDevice+"; "+transId);
			
			try 
			{
				synchronized(lockServicios)
				{
					lockServicios.wait();
				}
			}
		       
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			//busquedas.addElement(new Integer(transId));
		} 
		catch(BluetoothStateException e) 
			{
				e.printStackTrace();
			}
	}
	//implement this method since services are not being discovered
	public void servicesDiscovered(int transID, ServiceRecord[] servRecord) 
	{
		System.out.println("Servicios encontrados:");
		for(ServiceRecord service:servRecord)
		{
			DataElement element = service.getAttributeValue(ATRIBUTO_LISTADO_OBRAS);
			Enumeration e = (Enumeration) element.getValue();
			while(e.hasMoreElements()) 
			{
				element = (DataElement) e.nextElement();
				System.out.println(element.getValue().toString());
			}
		}
	}

	//implement this method since services are not being discovered
	public void serviceSearchCompleted(int transID, int respCode) 
	{
		System.out.println("Búsqueda de servicios completa.\n\n");
		synchronized(lockServicios)
		{
			lockServicios.notify();
		}
	}
	public void inquiryCompleted(int discType) 
	{
		System.out.println("Fin de Búsqueda.");
		if(remotes.isEmpty())
		{
			System.out.println("REMOTES VACÍO");
		}
		else
		{
			for(RemoteDevice remote : remotes)
			{
				try
				{
					System.out.println(remote.getFriendlyName(true));
				}
				catch(Exception e){e.printStackTrace();}
			}
		}
		synchronized(lockDispositivos)
		{
			lockDispositivos.notify();
		}
	}//end method
}
