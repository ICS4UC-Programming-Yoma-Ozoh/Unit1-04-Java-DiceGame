import java.util.Random;
import java.util.Scanner;
/**

 * This program asks the user to guess the correct number

 * between 1 and 6.

 * @author Yoma Ozoh

 * @version 1.0

 * @since 2026-09-27

 */
public final class DiceGame {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private DiceGame() {
        // Prevent instantiation
    }
    /**

     * This is the main method.

     *

     * @param args Unused

     */
public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(6) + 1; // Generates 1 to 6
        int guessCount = 0;
        int userGuess = 0;
        // welcome the user
        System.out.println("Welcome to the Guessing Game!");
        // tell user the game
        System.out.println("You have to guess a number between 1 and 6.");
        try {
            while (userGuess != targetNumber) {
                System.out.print("Enter your guess: ");

                // Check if input is a valid integer
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input,"
                   + "Please enter a whole number.");
                    scanner.next(); // Clear the invalid text from memory
                    continue;
                }

                userGuess = scanner.nextInt();

                // Crash proofing: Check if input is within valid range
                if (userGuess < 1 || userGuess > 6) {
                    System.out.println("Please enter a number between 1 and 6.");
                    continue;
                }

                // Increment count only for valid guesses
                guessCount++;

                if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.close();
            return;
        }

        System.out.println("Correct! You guessed the right number.");
        System.out.println("It took you " + guessCount
        + " guess(es) to get the right answer.");

        scanner.close();
    }
}
