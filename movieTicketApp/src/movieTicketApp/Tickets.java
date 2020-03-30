// Author: Karel Haapasalo 27.3.2020

package movieTicketApp;

import java.util.Scanner;

public class Tickets {

	public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		
		String[] movies = {"The Martian", "Interstellar", "Deadpool 2", "Sonic the Hedgehog", "Avatar"};
		int[] seatsAvailable = {200, 123, 44, 83, 159};
		// int[] ageRating = {12, 12, 16, 7, 13};
		
		//Asks for user input
		String userName = enterName();
		int userAge = enterAge();
		
		// Prints all movies 
		System.out.println("Here are the movies currently playing: ");
		for (int i = 0, j = 1; i < movies.length; i++, j++) {
			System.out.print(j + ": ");
			System.out.print(movies[i]);
			System.out.println();
		}
		
		System.out.println("What movie would you like to book tickets for?(1, 2, 3, 4, 5): ");
		int selectedMovie = reader.nextInt();		
		System.out.println("How many seats would you like to book?");
	}
	
	//Methods
	
	public static String enterName() {
		System.out.println("Please enter your name: ");
		String userName = reader.nextLine();
		return userName;
	}
	
	public static int enterAge() {
		System.out.println("Please also enter your age: ");
		int userAge = reader.nextInt();
		return userAge;
	}

}
