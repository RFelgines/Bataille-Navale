package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import map.Grid;

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
		String message=in.readLine(); // Récupère le message envoyé par le client
		System.out.println("message" +" test");
		out.println("pong");
		message=id+":"+message;
		System.out.println(message);
		for (int i=0;i<nbid;i++) {
			if (i!=id)outs[i].println(message);
		}
	}
	}catch (Exception e) {}
}


public void PlaceBoats() 
{
	boolean gamephase = false;
	while(!gamephase) 
	{
		try {
			out.println("Veuillez entrer le bateau " + "bateau " + "Au format longitude , latitude");
			String message=in.readLine();
			String positionInText[] = message.split(",");
			int x = Integer.parseInt(positionInText[0]);
			int y = Integer.parseInt(positionInText[1]);
			// Grid.Placement(x,y, );
			
			out.println("Vous avez placé un bateau à la position" + x + " "+ y);
			
		}catch (Exception e) {}
		
	}
}
public void Play()
{
	boolean endgame = false;
	while(!endgame) 
	{
	endgame = true;
	}
}
}


