/* Aaron Sutton
 * ajs377@pitt.edu
 * Lab 2: Variables and Control Structures
 *
 * Creates a simple story using user-supplied nound and verbs.
 */

package edu.pitt.ajs377.lab2;

import static edu.pitt.ajs377.lab2.TerminalColors.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MadLib {
  private static final String[] questions = {
    "What is your name",
    "Name a city",
    "A number",
    "Another number",
    "Name a profession",
    "Name an animal",
    "Name a famous person",
  };

  private static List<String> responses = new ArrayList<String>();

  private static final Scanner inputScanner = new Scanner(System.in);

  /**
   * Create a story using values supplied by the user.
   */
  public static void main(String[] args) {
    System.out.printf("%s == Mad Lib Generator ==%s\n", ANSI_CYAN, ANSI_RESET);
    /* Retry each time in case of type mismatch, rather than throw an error. */
    while (true) {
      promptAll();
      String name = responses.get(0);
      String city = responses.get(1);
      String profession = responses.get(4);
      String animal = responses.get(5);
      String famousPerson = responses.get(6);

      try {
        int number1 = Integer.parseInt(responses.get(2));
        int number2 = Integer.parseInt(responses.get(3));

        System.out.printf(
          "\n%sThere once was a person named %s who lived in %s. At the age\n" +
          "of %d went to the University of Pittsburgh and decided to study\n" +
          "Computer and Information Science. %s went on to work as a %s making %d per year\n" +
          "Then, %s adopted a(n) %s named %s and lived happily ever after.%s\n",
          ANSI_GREEN,
          name,
          city,
          number1,
          name,
          profession,
          number2,
          name,
          animal,
          famousPerson,
          ANSI_RESET
        );
        return;
      } catch (
        NumberFormatException e
      ) {/* Zero out responses, reset the scanner, and try again. */
        responses.clear();
        inputScanner.nextLine();
        System.out.printf(
          "%sCan't make numbers out of words! Try again please.%s\n",
          ANSI_RED,
          ANSI_RESET
        );
      }
    }
  }

  /**
   * Prompt the user with every question to generate a List of responses.
   */
  private static void promptAll() {
    for (String question : questions) {
      String response = prompt(question);
      responses.add(response);
    }
  }

  /**
   * Ask a question to the user and return the response as a String.
   */
  public static String prompt(String question) {
    System.out.printf("%s : ", question);
    String response = inputScanner.nextLine();
    return response;
  }
}
