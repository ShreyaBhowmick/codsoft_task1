import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        NumberGuessingGame.playNumberGame();
    }
}

class NumberGuessingGame {
    public static void playNumberGame() {
        int lowerRange = 1;
        int upperRange = 100;
        int attemptsLimit = 10;
        boolean playAgain = true;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            roundsPlayed++;
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;

            System.out.println("\nRound " + roundsPlayed);
            System.out.println("Guess the number between " + lowerRange + " and " + upperRange + ".");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == attemptsLimit) {
                System.out.println("\nRound " + roundsPlayed + ": Sorry, you've reached the maximum number of attempts. The number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        double averageAttempts = (double) totalAttempts / roundsPlayed;
        System.out.println("\nThanks for playing! Your average attempts per round: " + String.format("%.2f", averageAttempts));
        System.out.println("\nYour score: " + String.format("%.2f", averageAttempts));
        scanner.close();
    }
}