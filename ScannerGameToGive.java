import java.util.Scanner;
import java.util.ArrayList;

public class ScannerGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("I can tell you if its a weekday or weekend.");
		dayOfWeek(sc);

		System.out.println("I can tell you what season it is.");
		whichMonth(sc);

		System.out.println("Good job! Now let's play a number guessing game!");
		numberGuesser(sc);
	}

	// This example shows using break statements for each case
	public static void dayOfWeek(Scanner sc) {
		System.out.println("Please input a number 1-7 where 1 is monday and 7 is sunday and I'll tell you if its a weekday or weekend.");
		int inputNum = sc.nextInt();

		// ***************This is an example of a case statement***************
		switch (inputNum) {
			case 1:
				System.out.println("This is a weekday");
				break;
			case 2:
				System.out.println("This is a weekday");
				break;
			case 3:
				System.out.println("This is a weekday");
				break;
			case 4:
				System.out.println("This is a weekday");
				break;
			case 5:
				System.out.println("This is a weekday");
				break;
			case 6:
				System.out.println("This is a weekend");
				break;
			case 7:
				System.out.println("This is a weekend");
				break;
			default:
				System.out.println("Whoops you did not give a valid day of the week.");
				return;
		}
	}

	// This shows one way to use the cascading effect in switch statements
	public static void whichMonth(Scanner sc) {
		System.out.println("Please input a number 1-12 and I'll tell you what season it is.");
		int inputNum = sc.nextInt();

		// ***************This is an example of a case statement***************
		switch (inputNum) {
			case 11:
			case 12:
			case 1:
				System.out.println("This is a month during the winter.");
				break;
			case 2:
			case 3:
			case 4:
				System.out.println("This is a a month during the spring.");
				break;
			case 5:
			case 6:
			case 7:
				System.out.println("This is a a month during the summer.");
				break;
			case 8:
			case 9:
			case 10:
				System.out.println("This is a month during the fall/autumn.");
				break;
			default:
				System.out.println("Whoops you did not give a valid month in a year.");
				return;
		}
	}

	// This has examples of While loops and for loops inside of them, as well of if else
	public static void numberGuesser(Scanner sc) {

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
		System.out.println("Please enter an int for the largest number of the range you want from 1 to n: ");
		int range = sc.nextInt();

		// Calculate the goal from 1 - range
		int guess = 0;
		int guesses = 0;
		ArrayList<Integer> guessList = new ArrayList<>();
		int goal = (int)(Math.random() * range) + 1;

		// Game operation
		// ***************This is an example of a while loop***************
		while (guess != goal) {
			System.out.print("What is your guess: ");
			guess = sc.nextInt();
			guessList.add(guess);

			if (guess < goal) {
				System.out.println("Oops you guessed too low");
			} else {
				System.out.println("Oops you guessed too high");
			}

			// Increment guesses
			++guesses;
		}

		// Final results printing
		System.out.println("Congratulations " + name + "! You correctly guessed the number " + goal);
		System.out.println("You took " + guesses + " guesses to guess the right number!");

		// Print out the list of guesses taken
		// ***************This is an example of a for loop***************
		System.out.println("The guesses you took were: ");
		for (int i = 0; i < guessList.size(); ++i) {
			System.out.print(guessList.get(i) + ", ");
		}
		System.out.println();
	}

}




