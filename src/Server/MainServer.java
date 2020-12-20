package Server;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ecoute = new ServerSocket(1500);
			System.out.println("Serveur lance!");
			
			int id=0;	
			while(true)
			{
				Socket client = ecoute.accept();
				new ThreadChat(id,client).start();
				id++;
			}
		}
		catch(Exception e)
		{
			// Traitement d erreur
		}
	}
}
