/* Aaron Sutton
 * ajs377@pitt.edu
 * Lab 2: Variables and Control Structures
 * 
 * Terminal color utilities.
 */

package edu.pitt.ajs377.lab2;

/** 
 * Utility class that contains ANSI escape codes for colorizing terminal output.
 * Import statically to avoid qualifying eac terminal color.
 *
 * Note: These May not display quite right in Eclipse.
 */
public class TerminalColors {
  public static final String ANSI_RESET = "\u001b[0m";
  public static final String ANSI_RED = "\u001b[31m";
  public static final String ANSI_BLUE = "\u001b[34m";
  public static final String ANSI_CYAN = "\u001b[36m";
  public static final String ANSI_YELLOW = "\u001b[33m";
  public static final String ANSI_MAGENTA = "\u001b[35m";
  public static final String ANSI_GREEN = "\u001b[32m";
}
