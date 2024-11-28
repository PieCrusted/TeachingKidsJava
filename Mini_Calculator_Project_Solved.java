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
	public static void main(String[] args) {
		// Write code here
		
		// Below is an example of prompting the user to input an int
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter an int: ");
		int n = sc.nextInt();
		sc.nextLine(); // Consume the leftover newline character
		System.out.println("You entered: " + n);

	}

	public static int factorial(int n) {
		// Special returns for edge cases: 1, 0, negative, etc
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n < 0) {
			return -1;
		}

		int factorial = 1;
		for (int i = 1; i < n; ++i) {
			factorial *= 
		}
	}
}