package movieTicketApp;

import java.util.Scanner;
import java.io.*;

public class LueTiedosto {

	public static void main(String[] args) throws FileNotFoundException {
		
		// luodaan lukija-olio, jonka toimet kohdistetaan tiedostoon "tiedosto.txt"
		final Scanner lukija = new Scanner(new File("tiedosto.txt"));
		// luodaan tyhjä merkkijono
		String rivi = "";
		//Niin kauan kuin tiedostossa on käsittelemätöntä dataa
		while ( lukija.hasNext() ) {
			// luetaan talteen yksi tiedoston rivi
			rivi = lukija.nextLine();
			// tulostetaan näytölle tiedostosta luettu rivi
			System.out.println(rivi);
		}
		
		// suljetaan tiedosto
		lukija.close();

	}

}
