package Comunicacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.bluetooth.RemoteDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

public class ejemploMainDispositivoLocal 
{
	public static void main (String [] args)
	{
		DispositivoLocal dis = new DispositivoLocal();
		
		ArrayList <RemoteDevice> remotes = dis.getRemotes();
		for(RemoteDevice remote : remotes)
		{
			try
			{
				System.out.println("Dispositivo: " + remote.getFriendlyName(true));
				/*if(remote.getFriendlyName(true).equals("linvor"));
				{
					StreamConnection connection;
					
		            UUID uuid = new UUID("1101", true);
		            
					String connectionString = "btspp://localhost:"+uuid+";name=Sample SPP Server;authenticate=false;authorize=false;encrypt=false;";
					StreamConnectionNotifier streamConnNotifier = (StreamConnectionNotifier)Connector.open( connectionString );
					
				}*/
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
