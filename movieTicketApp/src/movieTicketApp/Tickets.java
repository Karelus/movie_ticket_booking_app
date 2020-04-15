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
		String moviesFile = "movies.txt";
		
		System.out.println("Tervetuloa Verkatehtaan elokuvalippujen varauspalveluun!");
		
		// Kysytään syöttämään käyttäjätunnus ja salasana, sekä ikä
		if (isLogged == false) {
			System.out.println("Anna käyttäjätunnus: ");
			String userName = reader.nextLine();
			
			/*boolean acceptedPassword = false;	
			while (acceptedPassword = false); {
				System.out.println("Syötä salasana: ");
				String passWord = reader.nextLine();
				boolean validPassword = isValid(passWord);
				if (validPassword) {
					acceptedPassword = true;
					isLogged = true;
				}
			}*/	
			
			String passWord = "";
			do {
				System.out.println("Syötä salasana: ");
				passWord = reader.nextLine();
			} while (!isValid(passWord));
			
			
			
			System.out.println("Syötä vielä ikäsi: ");
			int userAge = reader.nextInt();
			System.out.println(userName);
			System.out.println(userAge);
			isLogged = true;
		}
		
		
		// Tarkistetaan onko kirjautunut ja millä käyttäjällä ennen kuin muuta näytetään
		if (isLogged) {
			
			// Haetaan elokuvien listaus tiedostosta ja tallennetaan muuttujaan
			System.out.println("Tässä on ohjelmistossa olevat elokuvat");
			ArrayList<String> movies = new ArrayList<String>();
			try {
				movies = getMovies(moviesFile);
			} catch (IOException e) {
				System.out.println("error");
			}
		
			// Tulostetaan elokuvalistaus näkyville
			showMovies(movies);
					
			// Kysytään käyttäjää valitsemaan elokuvan
			boolean chosen = false;
			int selectedMovie = 0;
			while (chosen == false) {
				System.out.println("Pick a movie from above(1, 2, 3): ");
				if (reader.hasNextInt()) {
					selectedMovie = (reader.nextInt() -1);
					chosen = true;
				} else {
					System.out.println("Et syöttänyt oikeata valintaa!");
					break;
				}
			}
			
			// Kysytään haluaako käyttäjä varata liput
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
		
	}
	
	/**
	 * Check wheter or not the given password is valid
	 * @param passWord
	 * @return true, if it passes all criterias
	 */
	private static boolean isValid(String passWord) {
		String password = passWord;
		boolean noWhite = noWhiteSpace(password);
		boolean isOver = isOverEight(password);
		if (noWhite && isOver) {
			System.out.println("Salasana hyväksytty!");
			return true;
		} else return false;
	}

	public static boolean isOverEight(String mj) {
		if (mj.length() < 8) {
			System.out.println("Password must be over 8 characters!");
			return false;
		} else return true;
	}
	
	private static boolean noWhiteSpace(String password) {
		int whitespaces = 0;
		for (int i = 0; i < password.length(); i++) {
		      char c = password.charAt(i);
		      if ( Character.isWhitespace(c) ) {
		    	  whitespaces++;
		      }
		}
		if (whitespaces >= 1) {
			System.out.println("no whitespaces!");
			return false;
		} else return true;
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
	 * Reads lines from textfiles
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


}














/*private static boolean askAdmin() {
String username = "admin";
String password = "admin";
System.out.println("Syötä käyttäjätunnus: ");
String inputtedUsername = reader.nextLine();
System.out.println("Syötä salasana: ");
String inputtedPassword = reader.nextLine();

if (username.equals(inputtedUsername) && password.equals(inputtedPassword)) {
	return true;
} else {
	System.out.println("Väärät tunnukset!");
	return false;
}
}*/
