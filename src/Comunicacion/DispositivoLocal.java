package Comunicacion;

import java.util.ArrayList;
import java.util.Enumeration;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.microedition.io.*;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DataElement;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.bluetooth.DiscoveryListener;

public class DispositivoLocal 
{
	private LocalDevice local;
	private DiscoveryAgent agent;
	private ArrayList<RemoteDevice> remotes;
	private Listener listen;
	
	private Object lockDispositivos;
	
	public DispositivoLocal()
	{		
		remotes = new ArrayList<RemoteDevice>();
		lockDispositivos = new Object();
		
		try 
		{
			local = LocalDevice.getLocalDevice();
		} 
		catch(BluetoothStateException e) 
		{
			System.out.println("Error al iniciar el sistema Bluetooth");
			return;
		}
		
		
		agent = local.getDiscoveryAgent();

		listen = new Listener(lockDispositivos, remotes, agent);
		
		try
		{
			System.out.println("\nPrincipio de búsqueda.");
	        agent.startInquiry(DiscoveryAgent.GIAC, listen);
	        try 
			{
				synchronized(lockDispositivos)
				{
					lockDispositivos.wait();
				}
			}
	        
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		catch(BluetoothStateException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<RemoteDevice> getRemotes()
	{
		return remotes;
	}
}
