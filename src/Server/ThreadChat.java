package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadChat extends Thread{
int id;
BufferedReader in;
PrintWriter out;
static PrintWriter[] outs=new PrintWriter[100]; 
static int nbid=0;

public ThreadChat(int id,Socket client) {
	try {
	this.id=id;
	nbid++;
	in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	out = new PrintWriter(client.getOutputStream(), true);
	out.println("Id="+id+"\n");
	outs[id]=out;
	}catch (Exception e) {}
}

public void run() {
	try {
	while (true) {
		PlaceBoats();
		Play();
		/*String message=in.readLine();
		message=id+":"+message;
		System.out.println(message);
		for (int i=0;i<nbid;i++) {
			if (i!=id)outs[i].println(message);
		}*/
	}
	}catch (Exception e) {}
}



public void PlaceBoats() 
{
	boolean gamephase = false;
	try 
	{
		while(!gamephase) 
		{
			out.println("Place un bateau en suivant le format colonne, ligne"); // jsp pourquoi ce out s'affiche pas
			String message=in.readLine();
			out.println("René");
			String positionInText[] = message.split(",");
			int x = Integer.parseInt(positionInText[0]);
			int y = Integer.parseInt(positionInText[1]);
			out.println("Tu as tiré a la position " + x + " " + y);
			gamephase = true;
		}
	}catch (Exception e) {}
}

public void Play() 
{
	
}
}
