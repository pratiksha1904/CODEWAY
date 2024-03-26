import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int targetNumber = random.nextInt(MAX_RANGE) + 1;
            int attempts = 0;
            int guess;

            System.out.println("\nI have selected a number between " + MIN_RANGE + " and " + MAX_RANGE + ". Can you guess it?");
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                guess = scanner.nextInt();

                if (guess < MIN_RANGE || guess > MAX_RANGE) {
                    System.out.println("Your guess is out of range. Please enter a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
