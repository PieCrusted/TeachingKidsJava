// Project Details
///////////////////////////////////////////////////////
// You are to create a mini calculator app that prompts the user for the numbers
// Things you are required:
// 1. The calculator will be in the format of an infinite loop that asks the user
// to choose various operations by their symbols, before taking the inputs.
// 2. The program should list the full operations keywords before asking for operation input
// 3. The operations and their symbols required are below:
	// ADD: Adding 2 whole numbers
	// SUB: Subtracting 2 whole numbers
	// MULT: Multiplying 2 whole numbers
	// DIVIDE: Dividing 2 whole numbers (should print with decimal)
	// FACTORIAL: Factorial of a whole number using the long datatype
	// FIBO: Fibonacci sequence of the input whole number n and print the first nth numbers
		// Assume the first 1th and 2nd fibonacci is 1 and 1 respectively
		// For example FIBO(5) -> 1, 1, 2, 3, 5
	// COUNT: Char counting take a string and count the number of each letter char in the string
		// Assume 'A' and 'a' are 2 differet instance
		// If a non letter char is found, ignore them and don't count them
		// The letter and number of instance pairs can be print in any order
		// For example COUNT("Hello World") -> "H:1, e:1, l:3, o:2, W:1, r:1, d:1"
	// EXIT: Exit when the keyword is inputted to stop the whole program program.
// 4. After each operation is finished, it should re-prompt the user to choose operations
// 5. If the EXIT keyword was chosen, the program should end
// 6. If a unrecognizable operation keyword is inputted (including lowercase version) print
// a statement saying it could not recognize the operation and reprompt with the same list

// You are free to use any data structure or algorithms that you know of or found
// to accomplish this project, and we encourage to search online if needed.


import java.util.Scanner;

public class Mini_Calculator_Project {
	public static void main(String[] args) {
		// Write code here
		
		// Below is an example of prompting the user to input an int
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter an int: ");
		int n = sc.nextInt();
		sc.nextLine(); // Consume the leftover newline character
		System.out.println("You entered: " + n);

	}
}