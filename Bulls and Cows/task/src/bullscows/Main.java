package bullscows;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int secretCode = 0;
        System.out.println("Please, enter the secret code's length:");
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        if (capacity <= 10) {
            System.out.println("Okay, let's start a game!");
            secretCode = Main.generateSecretCode(capacity);
            //System.out.println(secretCode);
            bullsCows(secretCode);
        } else {
            System.out.println("Error: can't generate a secret number with a length of " + capacity + " because there aren't enough unique digits.");
        }
    }

    public static int generateSecretCode(int capacity) {
        int secretCode = 0;
        List<Integer> randomList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(randomList);

        while (randomList.get(0) == 0) {
            Collections.shuffle(randomList);
        }
        StringBuilder secretCodeString = new StringBuilder(capacity);
        for (int i = 0; i < capacity; i++) {
            secretCodeString.append(randomList.get(i));
        }
        secretCode = Integer.parseInt(String.valueOf(secretCodeString));
        //System.out.println("The random secret number is " + secretCode + ".");
        return secretCode;
    }

    public static void bullsCows(int secretCode) {
        Scanner scanner = new Scanner(System.in);
        int bulls = 0;
        int cows = 0;
        String secretString = String.valueOf(secretCode);
        int turn = 0;
        while (bulls != secretString.length()) {
            bulls = 0;
            cows = 0;
            turn++;
            System.out.println("Turn " + turn + ":");
            String userCode = scanner.next();

            for (int i = 0; i < userCode.length(); i++) {
                if (userCode.charAt(i) == secretString.charAt(i)) {
                    bulls += 1;
                }
            }

            for (int i = 0; i < secretString.length(); i++) {
                for (int j = 0; j < userCode.length(); j++) {
                    if (userCode.charAt(j) == secretString.charAt(i)) {
                        cows += 1;
                    }
                }
            }
            cows -= bulls;

            if (bulls > 1 && cows > 1) {
                System.out.println("Grade: " + bulls + " bulls and " + cows + " cows");
            }
            if (bulls == 1 && cows > 1) {
                System.out.println("Grade: " + bulls + " bull and " + cows + " cows");
            }
            if (bulls > 1 && cows == 1) {
                System.out.println("Grade: " + bulls + " bulls and " + cows + " cow");
            }
            if (bulls == 1 && cows == 1) {
                System.out.println("Grade: " + bulls + " bull and " + cows + " cow");
            }
            if (bulls == secretString.length() && cows == 0) {
                System.out.println("Grade: " + bulls + " bulls" );
                System.out.println("Congratulations! You guessed the secret code.");
            }
            if (bulls > 1 && bulls != secretString.length() && cows == 0) {
                System.out.println("Grade: " + bulls + " bulls" );
            }
            if (bulls == 0 && cows > 1) {
                System.out.println("Grade: " + cows + " cows");
            }
            if (bulls == 0 && cows == 0) {
                System.out.println("Grade: " + "none");
            }

        }
    }
}


