package com.example.numberguesser;

import java.util.Scanner;

public class NumberGuess {
    private static int numberToGuess = (int) (Math.random() * 100) + 1;
    private static int chances;
    private static int attempts;
    private static boolean hasWon;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to the Number Guessing Game!
                I'm thinking of a number between 1 and 100. Type 'exit' to quit.
                Please select the difficulty level:
                1. Easy (10 chances)
                2. Medium (5 chances)
                3. Hard (3 chances)
                Enter your choice:""");

        boolean isDifficultySet = false;

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Shell.");
                break;
            }

            if (!isDifficultySet) {
                switch (command) {
                    case "1" -> {
                        chances = 10;
                        isDifficultySet = true;
                        System.out.println("Great! Easy mode selected. You have 10 chances. Start guessing!");
                    }
                    case "2" -> {
                        chances = 5;
                        isDifficultySet = true;
                        System.out.println("Great! Medium mode selected. You have 5 chances. Start guessing!");
                    }
                    case "3" -> {
                        chances = 3;
                        isDifficultySet = true;
                        System.out.println("Great! Hard mode selected. You have 3 chances. Start guessing!");
                    }
                    default -> System.out.println("Please enter a valid difficulty: 1, 2, or 3.");
                }
                continue;
            }

            // Guessing phase
            try {
                int guess = Integer.parseInt(command);
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    hasWon = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Incorrect! The number is greater than " + guess);
                } else {
                    System.out.println("Incorrect! The number is lower than " + guess);
                }

                if (attempts >= chances) {
                    System.out.println("Sorry, you've used all your chances. The number was: " + numberToGuess);
                    break;
                } else {
                    System.out.println("Chances left: " + (chances - attempts));
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
