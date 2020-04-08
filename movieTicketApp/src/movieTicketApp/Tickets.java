package movieTicketApp;

import java.util.Scanner;
import java.io.*;

/**
 * This is a container class for ticket booking app
 * @author Karel Haapasalo
 * @version 1.0
 */
public class Tickets {

	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {

		// Muttujien alustus
		boolean isLogged = false;
		boolean isAdmin = false;
		boolean isUser = false;
		String userName = "";
		int userAge = 0;
		
		System.out.println("Tervetuloa Verkatehtaan elokuvalippujen varauspalveluun!");
		
		// Py�ritet��n silmukkaa kunnes k�ytt�j� on kirjautunut sis��n
		while (isLogged == false) {
			int whichUser = askUser();			
			if (whichUser == 1) {
				isAdmin = true;
				isUser = false;
				isLogged = true;
				System.out.println("olet nyt admin");
			} else if (whichUser == 2) {
				isUser = true;
				isAdmin = false;
				isLogged = true;
				System.out.println("olet nyt normaalik�ytt�j�");
			}		
		}
		
		// Pyydet��n k�ytt�j�� sy�tt�m��n omia tietoja ja talletetaan ne muuttujiin
		if (isUser) {
			System.out.println("Please enter your name: ");
			userName = reader.nextLine();
			System.out.println("Sy�t� my�s ik�si: ");
			userAge = reader.nextInt();
		}
		
		// Tulostetaan k�ytt�j�lle elokuvat
		System.out.println("T�ss� on ohjelmistossa olevat elokuvat");		
		try {
			showMovies();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Shows all movies from file "movies.txt"
	 * @throws FileNotFoundException
	 */
	private static void showMovies() throws FileNotFoundException {
		final Scanner fileReader = new Scanner(new File("movies.txt"));
		String rivi = "";
		while ( fileReader.hasNext() ) {
			// luetaan talteen yksi tiedoston rivi
			rivi = fileReader.nextLine();
			// tulostetaan n�yt�lle tiedostosta luettu rivi
			System.out.println(rivi);
		}	
		// suljetaan tiedosto
		fileReader.close();
	}

	/**
	 * Asks the user which user is to be selected for logging
	 * @return int
	 */
	public static int askUser() {
		System.out.println("Haluatko kirjautua sis��n yll�pit�j�n� vai normaalik�ytt�j�n�? (Sy�t� 1 tai 2): ");
		if (reader.hasNextInt()) {
			int whichUser = reader.nextInt();		
			if (whichUser == 1) {
				return 1;
			}		
			else if (whichUser == 2) {
				return 2;
			}
			else {
				System.out.println("Et sy�tt�nyt 1 tai 2!");
			}
		} else {
			System.out.println("Et sy�tt�nyt oikeanlaista arvoa!");
		}
		return 0;
	}

	/*private static boolean askAdmin() {
		String username = "admin";
		String password = "admin";
		System.out.println("Sy�t� k�ytt�j�tunnus: ");
		String inputtedUsername = reader.nextLine();
		System.out.println("Sy�t� salasana: ");
		String inputtedPassword = reader.nextLine();
		
		if (username.equals(inputtedUsername) && password.equals(inputtedPassword)) {
			return true;
		} else {
			System.out.println("V��r�t tunnukset!");
			return false;
		}
	}*/

}
