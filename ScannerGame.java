import java.util.Scanner;

public class ScannerGame {
	public static void main(String[] args) {

		// Takes user input
		Scanner sc = new Scanner(System.in);

		// Initial Introduction
		System.out.println("Hi, welcome to my text game!");
		System.out.println("What name do you call yourself?");

		// Grab the user's name
		String name = sc.nextLine();

		// Acknowledge user and start game
		System.out.println("Hi " + name + " welcome to the game.");
		System.out.println("Let's play a guessing game");

		// Start guessing game
		System.out.println("*********************************");
		System.out.println("Please enter an int for the largest number of the range you want: ");
		int range = sc.nextInt();

		// Calculate the goal from 1 - range
		int guess = 0;
		int guesses = 0;
		int goal = (int)(Math.random() * range) + 1;

		// Game operation
		while (guess != goal) {
			try {
				System.out.println("What is your guess: ");
				guess = Integer.parseInt(sc.nextLine());

				if (guess < goal) {
					System.out.println("Oops you guessed to low");
				} else {
					System.out.println("Oops you guessed to high");
				}

				++guesses;
			} catch (Exception e) {
				if (guesses == 0) {
					continue;
				}
				
				System.out.println("Looks like you didn't type in a integer, make sure to guess an integer!");
			}
		}

		System.out.println("Congratulations " + name + "! You correctly guessed the number " + goal);
		System.out.println("You took " + guesses + " guesses to guess the right number!");
	}
}




