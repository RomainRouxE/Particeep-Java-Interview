package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use
 * Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    // If i and n are over 0 multiply res by i the number of time needed
    int res = 1;
    if (i >= 0 && n > 0 && n < 100) {
      while (n > 0) {
        res = res * i;
        n--;
      }
      return Option.of(res);
    } else if (i >= 0 && n == 0)
      return Option.of(1);
    else
      return Option.none();
  }
}
