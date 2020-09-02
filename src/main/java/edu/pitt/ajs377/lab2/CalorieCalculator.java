/* Aaron Sutton
 * ajs377@pitt.edu
 * Lab 2: Variables and Control Structures
 *
 * Calculate calories consume given a number of cupcakes.
 */

package edu.pitt.ajs377.lab2;

import static edu.pitt.ajs377.lab2.TerminalColors.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalorieCalculator {
  private static int cupcakes;

  /* Constant for calculation */
  private static final int KCALS_PER_CUPCAKE = 130;

  /* Extra constant for adding an emoji to the prompt. */
  private static final String CUPCAKE_CODEPOINT = "\uD83E\uDDC1";

  /**
   * Takes user input, calculates and reports the number of calories consumed.
   */
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    int calories;

    /*
     * Rather than burn and throw an exception, a while loop shows a message a retries
     * in case the user inputs something other than a number. The program will retry an
     * infinite number of times until a number is entered.
     */
    while (true) {
      try {
        System.out.println("How many cupcakes? " + CUPCAKE_CODEPOINT);

        cupcakes = inputScanner.nextInt();
        calories = cupcakes * KCALS_PER_CUPCAKE;

        System.out.printf(
            "You ate %s%d cupcakes%s which totals %s%dkcals%s.",
            ANSI_BLUE,
            cupcakes,
            ANSI_RESET,
            ANSI_RED,
            calories,
            ANSI_RESET
          );
        return;
      } catch (InputMismatchException e) {
        System.out.println("Please enter a number.");
        /*
         * nextLine() prevents the Scanner from reading the prompt message instead of keyboard
         * input and entering an infinite loop.
         */
        inputScanner.nextLine();
      }
    }
  }
}
