package movieTicketApp;

import java.util.ArrayList;
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
		String moviesFile = "movies.txt";
		
		System.out.println("Tervetuloa Verkatehtaan elokuvalippujen varauspalveluun!");
		
		// Py�ritet��n silmukkaa kunnes k�ytt�j� valitsee kummalla kirjautuu
		System.out.println("Haluatko kirjautua sis��n yll�pit�j�n� vai normaalik�ytt�j�n�? (Sy�t� 1 tai 2): ");
		while (isLogged == false) {
				if (reader.hasNextInt()) {
					int whichUser = reader.nextInt();		
					if (whichUser == 1) {
						isAdmin = true;
						isLogged = true;
					}	
					else if (whichUser == 2) {
						isUser = true;
						isLogged = true;
					}
					else {
						System.out.println("Et sy�tt�nyt 1 tai 2!");
					}
				} else {
					break;
				}
		}			
		
		// Tarkistetaan onko kirjautunut ennen kuin muuta n�ytet��n
		if (isLogged && isUser) {
			// Haetaan elokuvien listaus tiedostosta ja tallennetaan muuttujaan
			System.out.println("T�ss� on ohjelmistossa olevat elokuvat");
			ArrayList<String> movies = new ArrayList<String>();
			try {
				movies = getMovies(moviesFile);
			} catch (IOException e) {
				System.out.println("error");
			}
		
			// Tulostetaan elokuvalistaus n�kyville
			showMovies(movies);
					
			// Kysyt��n k�ytt�j�� valitsemaan elokuvan
			boolean chosen = false;
			int selectedMovie = 0;
			while (chosen == false) {
				System.out.println("Valitse elokuva yll� olevista(1, 2, 3): ");
				if (reader.hasNextInt()) {
					selectedMovie = (reader.nextInt() -1);
					chosen = true;
				} else {
					System.out.println("Et sy�tt�nyt oikeata valintaa!");
					break;
				}
			}
			
			// Kysyt��n haluaako k�ytt�j� varata liput
			if (chosen) {
				System.out.println("Haluatko varata liput elokuvaan " + movies.get(selectedMovie) + "?(y/n): ");
				String askConfirmation = reader.nextLine();
				if (askConfirmation == "y") {
					System.out.println("liput varattu");
				} 
				else if (askConfirmation == "n") {
					System.out.println("lippuja ei varattu");
				}
				else {
					System.out.println("something went wrong");
				}
				
			}
		}
		
		if (isLogged && isAdmin) {
			System.out.println("Olet admin, t�h�n tulee my�hemmin lis��");
		}
		
	}
	

	/**
	 * Takes movies arraylist and prints it's content to the user
	 * @param movies
	 */
	private static void showMovies(ArrayList<String> movies) {
		for (String movie : movies) {
			System.out.println(movie);
		}		
	}


	/**
	 * Reads lines from textfiles"
	 * @return ArrayList
	 * @throws IOException 
	 */
	private static ArrayList<String> getMovies(String filename) throws IOException {
		BufferedReader filereader = new BufferedReader(new FileReader(filename));
		ArrayList<String> lines = new ArrayList<String>();
		String line;
		while ((line = filereader.readLine()) != null) {
			lines.add(line);
		}
		
		filereader.close();
		return lines;
	}

	/**
	 * Asks the user which user is to be selected for logging
	 * @return int
	 */



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
