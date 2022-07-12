package collection;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    // Create new list to store result.
    List<Double> newList = new ArrayList<Double>();

    // Iterate through List, store operation into Double temp var and add to newList
    for (int i = 0; i < input.size(); i++) {
      double tmp = Math.pow((input.get(i) * 2) + 3, 5);
      // System.out.println(tmp);
      newList.add(tmp);
    }

    return newList;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    // Create new list to store result.
    List<String> newList = new ArrayList<String>();

    // Iterate through List, capitalise first leter of string and duplicate it.
    // Add tmp to the newList
    // If string is empty ignore and add "" to new list
    for (int i = 0; i < input.size(); i++) {
      if (input.get(i).isEmpty())
        newList.add("");
      else {
        String tmp = input.get(i).substring(0, 1).toUpperCase() + input.get(i).substring(1);
        tmp = tmp.repeat(2);
        // System.out.println(tmp);
        newList.add(tmp);
      }
    }

    return newList;
  }

}
