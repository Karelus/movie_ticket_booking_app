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

		// Variable declaration
		boolean isLogged = false;
		
		String moviesFile = "movies.txt";
		String userName = "";
		
		int userAge = 0;
		int[] ageRatings = {13, 13, 16, 13, 8};
		
		// Welcomes the user
		System.out.println("Welcome to Verkatehdas movieticket booking service!");
		
		// Ask user to input username, password and age
		if (isLogged == false) {
			System.out.println("Enter username: ");
			userName = reader.nextLine();		
			String passWord = "";
			do {
				System.out.println("Enter password: ");
				passWord = reader.nextLine();
			} while (!isValid(passWord));
					
			System.out.println("Please enter your age: ");
			userAge = reader.nextInt();
			isLogged = true;
		}		
		
		// Check if user has logged in before going any further
		if (isLogged) {
			
			// Get movielisting from a file and save it to a variable
			System.out.printf("Hello %s, here are the movies currently playing: ", userName);
			System.out.println();
			ArrayList<String> movies = new ArrayList<String>();
			try {
				movies = getMovies(moviesFile);
			} catch (IOException e) {
				System.out.println("error");
			}
		
			// Print movielist for the user
			showMovies(movies);
					
			// Ask user to pick a movie
			boolean chosen = false;
			int selectedMovie = 0;
			while (chosen == false) {
				System.out.println("Pick a movie from above(1, 2, 3, 4, 5): ");
				if (reader.hasNextInt()) {
					selectedMovie = (reader.nextInt() -1);
					reader.nextLine();
					chosen = true;
				} else {
					System.out.println("You didn't enter a valid pick!");
					System.out.println("Please restart the program");
					break;
				}
			}
			
			// Ask if user wants to book the tickets
			if (chosen) {
				System.out.println("Would you like to book tickets for " + movies.get(selectedMovie) + "?(y/n): ");
				String askConfirmation = reader.nextLine();
				System.out.println(askConfirmation);
				if (askConfirmation.equals("y")) {
					if (isOldEnough(ageRatings, selectedMovie, userAge)) {
						System.out.println("tickets booked");
					} else System.out.printf("You are not old enough,"
							+ " age rating for this movie is %d", ageRatings[selectedMovie]);
				} 
				else if (askConfirmation.equals("n")) {
					System.out.println("tickets not booked");
				}
				else {
					System.out.println("wrong input, restart the program!");
				}				
			}						
		}		
	}

	/**
	 * checks user age and compares it to movies age rating
	 * @param ageRatings
	 * @param selectedMovie
	 * @param userAge
	 * @return true if old enough, false if not
	 */
	private static boolean isOldEnough(int[] ageRatings, int selectedMovie, int userAge) {
		int[] ratings = ageRatings;
		if (userAge >= ratings[selectedMovie]) {
			return true;
		} else return false;		
	}

	
	// METHODS
	
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
			System.out.println("Password accepted!");
			return true;
		} else return false;
	}

	/**
	 * Checks if the given password is atleast 8 characters long
	 * @param mj
	 * @return true if it is, otherwise false
	 */
	public static boolean isOverEight(String mj) {
		if (mj.length() < 8) {
			System.out.println("Password must be over 8 characters!");
			return false;
		} else return true;
	}
	
	/**
	 * Checks if the given password contains whitespaces which are not allowed
	 * @param password
	 * @return true if no whitespaces, otherwise false
	 */
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


