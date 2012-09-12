package Comunicacion;


import javax.bluetooth.*;
import javax.microedition.io.*;
import java.io.*;

public class Ejemplo7 implements Runnable 
{
	public static final UUID SERVICIO_CHAT = new UUID(0x2345);
	private Thread thread;
	
	public void startApp() 
	{
		thread = new Thread(this);
	}
	public void pauseApp() 
	{
	}
	public void destroyApp(boolean unconditional) 
	{
	}
	public void run() 
	{
		try 
		{
			LocalDevice localDevice = LocalDevice.getLocalDevice();
			if(!localDevice.setDiscoverable(DiscoveryAgent.GIAC)) 
			{
				System.out.println("Imposible ofrecer un servicio");
			}
			
			String url = "btspp://localhost:" + SERVICIO_CHAT.toString()+";name=Servicio chat;authorize=true";
			StreamConnectionNotifier notifier = (StreamConnectionNotifier) Connector.open(url.toString());
			System.out.println("Servidor en marcha...");
			
			StreamConnection connection = null;
			DataInputStream in = null;
			DataOutputStream out = null;
			while(true) 
			{
				try 
				{
					connection = notifier.acceptAndOpen();
					in = connection.openDataInputStream();
					out = connection.openDataOutputStream();
					out.writeUTF("El servidor dice HOLA!");
					out.flush();
					String s = in.readUTF();
					System.out.println("Un cliente dice...");
					System.out.println(s);
				} 
				catch(IOException e) 
				{
					e.printStackTrace();
				} 
				finally 
				{
					try 
					{
						if(in != null) in.close();
						if(out != null) out.close();
						if(connection != null) connection.close();
					} 
					catch(IOException e) {}
				}
			}
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
