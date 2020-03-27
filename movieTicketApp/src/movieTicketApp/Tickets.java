// Author: Karel Haapasalo 27.3.2020

package movieTicketApp;

import java.util.Scanner;

public class Tickets {

	public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Please enter your name: ");
		String userName = reader.nextLine();
		System.out.println("Please also enter your age: ");
		int userAge = reader.nextInt();
		
		String[] movies = {"1: The Martian", "2: Interstellar", "3: Deadpool 2", "4: Sonic the Hedgehog", "5: Avatar"};
		
		System.out.println("Here are the movies currently playing: ");
		for (String movie : movies) {
			System.out.println(movie);
		}
		
		System.out.println("What movie would you like to book tickets for?(1, 2, 3, 4, 5): ");
		int selectedMovie = reader.nextInt();
		
		
		System.out.println("Hi "+userName+", you chose the movie number 3, which is "+movies[2]+" and it has an age rating of 18. Luckily you are "+userAge+" years old!");
	}

}
