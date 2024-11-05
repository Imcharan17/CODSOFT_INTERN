import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            rounds++;
            int targetNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.printf("\nRound %d: Guess the number between %d and %d.\n", rounds, rangeStart, rangeEnd);

            while (attempts < maxAttempts) {
                System.out.printf("Attempt %d/%d - Enter your guess: ", attempts + 1, maxAttempts);
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                    score += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.printf("Sorry, you've used all your attempts. The correct number was %d.\n", targetNumber);
            }

            System.out.printf("Your current score: %d\n", score);

            // Prompt to play again
            System.out.print("Would you like to play another round? (y/n): ");
            playAgain = scanner.next().trim().equalsIgnoreCase("y");
        }

        System.out.printf("\nGame over! You played %d rounds with a total score of %d.\n", rounds, score);
        scanner.close();
    }
}
