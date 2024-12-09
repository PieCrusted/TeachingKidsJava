// Project Details
///////////////////////////////////////////////////////
// You are to create a mini calculator app that prompts the user for the numbers
// Things you are required:
// 1. Do at least one or all of the basic built in operations add, sub, multiply, divide
// 2. You will have to implement a factorial or n! (use a for loop)
	// n! = n * (n - 1) * (n - 2) * ... * 1, so 5! = 5 * 4 * 3 * 2 * 1 = 120
	// Note: Since facotrial does not take negative numbers, you can have it result in 0
	// Note: Since the integer datatype int has a limited maximum number, result 0 for 
	// input numbers larger than 12
// 3. Use a while loop to have the user guess what that factorial is
	// You can refer to the guessing game code we passed to you all on Tuesday for reference

// So to summarize the User Experience:
///////////////////////////////////////////////////////
// 1. The user is prompted to provide 2 numbers, and then it should print back the result of a
// preset operation
// 2. The user is prompted to input a number to be used for factorial
// 3. The user is then prompted to guess a number with message prints after each guess if its
// too high or too low, repeatedly until they guess the correct factorial result

// Additional Notes:
///////////////////////////////////////////////////////
// You are not expected to handle errors, for example if the user inputted a word and 
// not a number, it is ok for it to break.

import java.util.Scanner;

public class Mini_Calculator_Project_Solved {
	private static HashMap<Integer, Integer> fiboMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Write code here
		
		// Below is an example of prompting the user to input an int
		Scanner sc = new Scanner(System.in);

		// Ask user to input name (optional)
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();

		// Rough introduction of the interface
		printBar();
		System.out.println("Hi " + name + " this is a mini calculator project");
		printBar();

		

	}

	// Just something to make it fancy
	public static void printBar() {
		System.out.println("===============================================================");
	}

	/**
	 * Operation is based on 0 = add, 1 = sub, 2 = multiply, 3 = divide
	*/
	public static double mathematicalFunction(int a, int b, int operation) {
		// This example is where a switch/case statement shines, but since we didn't
		// introduce it, I'll stick with if statements
		if (operation < 0 || operation > 3) {
			return 0;
		}

		if (operation == 0) {
			return a + b;
		}
		if (operation == 1) {
			return a - b;
		}
		if (operation == 2) {
			return a * b;
		}

		return (double) a / b;
	}

	// Multiplies using a for loop, n * (n - 1) * (n - 2) * ... * 1 = n!
	// If n is negative, or 0 return 0
	// If a value over 12 is given, return -1
	public static int factorial(int n) {
		// Return -1 since 13 and above factorial gives incorrect values with int
		if (n > 12) {
			return -1;
		}

		// Special returns for edge cases: 1, 0, negative, etc
		if (n == 0 || n < 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int factorial = 1;
		for (int i = 1; i <= n; ++i) {
			factorial *= i;
		}

		return factorial;
	}

	// Adjusted guessing game from what we emailed them out in class
	public static void numberGuesser(int n, int factorial, String name) {

		// Start guessing game
		printBar();
		System.out.println("You will be guessing what " + n + "! is.");
		printBar();

		// Calculate the goal from 1 - range
		int guess = 0;
		int guesses = 0;
		ArrayList<Integer> guessList = new ArrayList<>();

		// Use the given factorial as the goal
		int goal = factorial;

		// Game operation
		// We change to a do while loop, so it does the iteration once, so we can account
		// for the goal being 0
		do {
			printBar();
			System.out.print("What is your guess: ");
			printBar();
			guess = sc.nextInt();
			sc.nextLine(); // Consume the leftover newline character
			guessList.add(guess);

			if (guess < goal) {
				System.out.println("Oops you guessed too low");
			} else {
				System.out.println("Oops you guessed too high");
			}

			// Increment guesses
			++guesses;
		} while (guess != goal)

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



