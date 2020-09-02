/* Aaron Sutton
 * ajs377@pitt.edu
 * Lab 2: Variables and Control Structures
 *
 * Simulates an ATM for denominations of Monopoly Money.
 */

package edu.pitt.ajs377.lab2;

import static edu.pitt.ajs377.lab2.TerminalColors.*;

import java.util.Collections;
import edu.pitt.ajs377.lab2.Utility;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class MonopolyMoney {

  /**
   * Small class that holds the value of a bill
   * and its color for terminal printing.
   */
  private static class Bill implements Comparable<Bill> {
    public Integer value;
    private String ansiCode;

    @Override
    public int compareTo(Bill bill) {
      return this.value.compareTo(bill.value);
    }

    public Bill(int value, String color) {
      this.value = value;
      this.ansiCode = color;
    }

    /**
     * Pretty-print the value of this bill with its color.
     *
     * Ex. [= 20 =]
     */
    public String displayString() {
      int padLeft = 1;
      int padRight = 1; 
      return String.format("%s[= %d =]%s", ansiCode, value, ANSI_RESET);
    }
  }

  /* Denomination constants and their respective display colors */
  public static final Bill DENOM_500 = new Bill(500, "\u001b[38;5;3m");
  public static final Bill DENOM_100 = new Bill(100, "\u001b[38;5;11m");
  public static final Bill DENOM_50 = new Bill(50, ANSI_CYAN);
  public static final Bill DENOM_20 = new Bill(20, ANSI_GREEN);
  public static final Bill DENOM_10 = new Bill(10, ANSI_YELLOW);
  public static final Bill DENOM_5 = new Bill(5, ANSI_MAGENTA);
  public static final Bill DENOM_1 = new Bill(1, ANSI_RESET);

  /* Use an Array to loop through all denominations */
  public static final Bill[] denominations = {
    DENOM_500,
    DENOM_100,
    DENOM_50,
    DENOM_20,
    DENOM_10,
    DENOM_5,
    DENOM_1,
  };

  public static void main(String[] args) {
    while (true) {
      String input = JOptionPane.showInputDialog("Enter an amount to withdraw");
      try {
        int amount = Integer.parseInt(input);
        System.out.printf(
          "Your request: %s%d%s\n\n",
          ANSI_GREEN,
          amount,
          ANSI_RESET
        );

        Map<Bill, Integer> result = calculateDenominations(amount);
        for (Map.Entry<Bill, Integer> entry : result.entrySet()) {
          Bill bill = entry.getKey();
          int number = entry.getValue();
          /* Use this length to add the correct amount of padding to the output */
          int length = Utility.digits(bill.value);

          System.out.printf(
            "%s%s: %d\n",
            bill.displayString(),
            Utility.repeatString(" ", 4 - length), /* Add space characters to keep the columns in line */
            number
          );
        }
        return;
      } catch (NumberFormatException e) {
        System.out.printf("%sPlease enter a number.%s\n", ANSI_RED, ANSI_RESET);
      }
    }
  }

  /**
   * Calculate the required amount of each denomination.
   */
  private static Map<Bill, Integer> calculateDenominations(int amount) {
    int remaining = amount;
    Map<Bill, Integer> table = new TreeMap<Bill, Integer>(
      Collections.reverseOrder()
    );

    for (Bill denomination : denominations) {
      int bills = remaining / denomination.value;
      table.put(denomination, bills);
      remaining = remaining % denomination.value;
    }
    return table;
  }
}
