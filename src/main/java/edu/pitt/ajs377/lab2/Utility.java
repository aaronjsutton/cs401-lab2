package edu.pitt.ajs377.lab2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utility {

  /**
   * Java 8 implementation of String.repeat()
   */
  public static String repeatString(String s, int n) {
    return IntStream
      .range(0, n)
      .mapToObj(i -> s)
      .collect(Collectors.joining(""));
  }

  /**
   * Returns the number of digits in a number.
   */
  public static int digits(int number) {
    return String.valueOf(number).length();
  }
}
