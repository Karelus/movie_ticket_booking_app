package movieTicketApp;

import java.util.Scanner;
import java.io.*;

public class TiedostoonKirjoitus {
	
	private static final Scanner lukija = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		String mj = " "; // tyhj� merkkijono
		// luodaan kirjoittaja olio, joka yhdistet��n tiedostoon "tiedosto.txt"
		PrintWriter kirjoittaja = new PrintWriter("tiedosto.txt");
		System.out.println("Anna merkkijono: ");
		mj = lukija.nextLine();
		// kirjoittaja kirjoittaa/tulostaa merkkijonon mj sis�ll�n tiedostoon
		kirjoittaja.println(mj);
		// suljetaan tiedosto
		kirjoittaja.close();
		
	}

}
