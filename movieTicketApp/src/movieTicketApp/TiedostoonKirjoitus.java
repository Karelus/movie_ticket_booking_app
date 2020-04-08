package movieTicketApp;

import java.util.Scanner;
import java.io.*;

public class TiedostoonKirjoitus {
	
	private static final Scanner lukija = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		String mj = " "; // tyhjä merkkijono
		// luodaan kirjoittaja olio, joka yhdistetään tiedostoon "tiedosto.txt"
		PrintWriter kirjoittaja = new PrintWriter("tiedosto.txt");
		System.out.println("Anna merkkijono: ");
		mj = lukija.nextLine();
		// kirjoittaja kirjoittaa/tulostaa merkkijonon mj sisällön tiedostoon
		kirjoittaja.println(mj);
		// suljetaan tiedosto
		kirjoittaja.close();
		
	}

}
