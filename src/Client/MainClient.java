package Client;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MainClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 1500);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			new ThreadClient(s).start();
			System.out.println("Client!");
			System.out.println("Connexion reussie!");
			Scanner sc=new Scanner(System.in);
			String message="";
			while (!message.equals("quit")) {
			message=sc.nextLine();
			out.println(message);
			}
			System.out.println("Bernard");
			Thread.sleep(1000);
			sc.close();
			s.close();
			} catch(Exception e) {
			// Traitement d erreur
			}

	}
}