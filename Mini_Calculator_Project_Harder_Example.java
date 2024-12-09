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
// 7. You are not expected to handle illegal operations for example if you are expecting a
// integer, but user inputted a word, its ok if the program breaks.

// You are free to use any data structure or algorithms that you know of or found
// to accomplish this project, and we encourage to search online if needed.


import java.util.Scanner;
import java.util.HashMap;

// Because this example is specifically targeted for students who already know programming
// but not java, I'm aiming for more advanced data structures and what not, but trying to
// limit to the scope of what we might teach. So will not include try catch and exception handling
public class Mini_Calculator_Project {
	private static HashMap<Integer, Integer> fiboMap = new HashMap<>();

	public static void main(String[] args) {
		// Write code here
		
		// Below is an example of prompting the user to input an int
		Scanner sc = new Scanner(System.in);

		// Ask user to input name (optional)
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();

		// Rough introduction of the interface
		System.out.println("Hi " + name " this is a mini calculator project");

		// TO make it easier to organize and later update additional operations, I'll
		// make a map with operations and integers pairs
		HashMap<String, Integer> opMap = new HashMap<>();
		int i = 0;
		String[] operations = {"ADD", "SUB", "MULT", "DIVIDE", "FACTORIAL", "FIBO", "COUNT", "EXIT"};
		for (String s : operations) {
			opMap.put(s, i);
			++i
		}

		while (true) {
			// Give the full list of available prompts
			printPrompt();

			// Grab the chosen operation
			String input = sc.nextLine();

			// If a non operation is chosen, warn and repeat
			if (opMap.get(input) == null) {
				printWrongPrompt();
				continue;
			}

			// Treat operation by its value now
			int chosenOperation = opMap.get(input);

			// NOTE: Technically I can do less hardcoding, by doing opMap.get("EXIT")
			// which can help with scalability, but for now its ok
			// If EXIT, or 7
			if (chosenOperation == 7) {
				printExit(name);
				break;
			}

			// ADD, SUB, MULT, DIVIDE
			if (chosenOperation >= 0 && chosenOperation <= 3) {
				System.out.println("Please enter int number 1: ");
				int n1 = sc.nextInt();
				sc.nextLine(); // Consume the leftover newline character

				System.out.println("Please enter int number 2: ");
				int n2 = sc.nextInt();
				sc.nextLine(); // Consume the leftover newline character

				System.out.println("The result is: " + mathematicalFunction(n1, n2, chosenOperation));
				continue;
			}

			// FACTORIAL or operation 4
			if (chosenOperation == 4) {
				int n = promptForInt();

				int result = factorial(n);

				// Handle 13 and over factorial
				if (result < 0) {
					System.out.println("We cannot handle numbers over 12 factorial");
					continue;
				}

				// Handle 0 or negative factorial
				if (result == 0) {
					System.out.println("We assume negative and 0 factorial is: 0");
					continue;
				}

				// Can now give actual result
				System.out.println("The value of " + n + "! is: " + result);
			}

			// FIBO or operation 5
			if (chosenOperation == 5) {
				int n = promptForInt();

				int result = fibonacci(n);

				// Handle if n is greater or equal to 47
				if (result < 0) {
					System.out.println("We cannot handle value of the 47th and over fibonacci");
					continue;
				}

				System.out.println("The value of the " + n + "th fibonacci sequence is: " + result);
			}

			// COUNT or operation 6
			if (chosenOperation == 6) {
				String str = promptForString();

				HashMap<Integer, Integer> map = charCount(str);

				System.out.println("The occurences of each letter chars are: ");
				System.out.println(map.toString());
			}
		}

	}

	// Fixed helper function to print the full prompt of options
	public static void printPrompt() {
		System.out.println("These are the following operations that can be done: ");
		System.out.println("ADD: Adds 2 numbers");
		System.out.println("SUB: Subtracts one number from the other");
		System.out.println("MULT: Multiplies 2 numbers");
		System.out.println("DIVIDE: Divides 2 numbers and returns in decimal form");
		System.out.println("FACTORIAL: returns n!. NOTE: will only correctly go up to 12!");
		System.out.println("FIBO: returns the nth fibonacci sequence. NOTE: only correctly goes up to the 46th sequence");
		System.out.println("COUNT: Count the number of char occurences in a string");
		System.out.println("EXIT: Exits the program");
		System.out.println("Please only enter: \"ADD\", \"SUB\", \"MULT\", \"DIVIDE\", \"FACTORIAL\", \"FIBO\", \"COUNT\", \"EXIT\"");
	}

	// A message if user did not enter the keyword operations
	public static void printWrongPrompt() {
		System.out.println("Oops, you did not enter a recongnizable keyword.");
	}

	// A message thanking user for using the program
	public static void printExit(String name) {
		System.out.println("The program is now stopping, thank you " + name + " for using the mini calculator.");
	}

	// Resusable code for prompting user for a single int
	public static int promptForInt() {
		System.out.println("Please enter int number: ");
		int n = sc.nextInt();
		sc.nextLine(); // Consume the leftover newline character

		return n;
	}

	// Reusable code for prompting user for a string
	public static String promptForString() {
		System.out.println("Please enter a string: ");
		String str = sc.nextLine();

		return str;
	}

	/**
	 * Operation is based on 0 = add, 1 = sub, 2 = multiply, 3 = divide
	*/
	public static double mathematicalFunction(int a, int b, int operation) {
		// This example is where a switch/case statement shines, but since we didn't
		// introduce it, I'll stick with if statements
		if (operation < 0 || operation >= 3) {
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

		return a / b;
	}

	// Use recursion and the hashmap for caching for faster future computation
	public static int fibonacci(int n) {
		// Return -1 for values over 46, since fibo 47 cannot be represented with ints
		if (n > 46) {
			return -1;
		}

		// Baseline case of 1 and 2
		if (n == 1 || n == 2) {
			return 1;
		}

		// Check map cache if fibo(n) already calculated
		if (fiboMap.get(n) != null) {
			return fiboMap.get(n);
		}

		// Compute fibo recursively and add to map
		int result = fibonacci(n - 1) + fibonacci(n - 2);
		fiboMap.put(n, result);
		return result;
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

		int factorial = 1;
		for (int i = 1; i < n; ++i) {
			factorial *= i;
		}

		return factorial
	}

	// Counts the number of each letter char in a string
	public static HashMap<Integer, Integer> charCount(String str) {
		// Create a map where the Ascii value of the char is key and counter as value
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); ++i) {
			// Grab the value of the char
			int asciiVal = (int)(str.charAt(i));

			// If it is not a letter in the alphabet, then skip it
			if (asciiVal < 65 || asciiVal > 122) {
				continue;
			}

			// If there is no counter yet, create 1 and add 1
			if (map.get(asciiVal) == null) {
				map.put(asciiVal, 1);
				continue;
			}

			// If counter does exist, just place back added 1
			map.put(asciiVal, map.get(asciiVal));
		}

		return map;
	}

}





