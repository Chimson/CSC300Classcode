// DO NOT CHANGE THIS FILE IN ANY WAY

package homeworks;

import stdlib.*;
import java.util.Arrays;

public class FirstHomeworkTests {

  private static final Counter cntr = new Counter();

  private static FirstHomework fh;

  public FirstHomeworkTests(FirstHomework fh) {
    FirstHomeworkTests.fh = fh;
  }

  public void execute() {

    // for minValue: array must be nonempty with unique elements
    testMinValue(-7, "1 -4 -7 7 8 11 9 -5");
    testMinValue(-0.5, "0.2 -0.5 -0.1");
    testMinValue(9, "11 9 21 31 41");
    testMinValue(9, "11 21 9 31 41");
    testMinValue(9, "11 21 31 9 41");
    testMinValue(9, "11 21 31 41 9");
    testMinValue(9, "9 11 21 31 41");
    testMinValue(-99, "-11 -99 -21 -31 -41");
    testMinValue(-99, "-11 -21 -99 -31 -41");
    testMinValue(-99, "-11 -21 -31 -99 -41");
    testMinValue(-99, "-11 -21 -31 -41 -99");
    testMinValue(-99, "-99 -11 -21 -31 -41");
    testMinValue(11, "11");
    testMinValue(-11, "-11");

    // for minPosition: array must be nonempty with unique elements
    testMinPosition(2, "1 -4 -7 7 8 11 9 -5");
    testMinPosition(1, "0.2 -0.5 -0.1");
    testMinPosition(1, "11 9 21 31 41");
    testMinPosition(2, "11 21 9 31 41");
    testMinPosition(3, "11 21 31 9 41");
    testMinPosition(4, "11 21 31 41 9");
    testMinPosition(0, "9 11 21 31 41");
    testMinPosition(1, "-11 -99 -21 -31 -41");
    testMinPosition(2, "-11 -21 -99 -31 -41");
    testMinPosition(3, "-11 -21 -31 -99 -41");
    testMinPosition(4, "-11 -21 -31 -41 -99");
    testMinPosition(0, "-99 -11 -21 -31 -41");
    testMinPosition(0, "11");
    testMinPosition(0, "-11");

    // for distanceBetweenMinAndMax: array must be nonempty with unique elements
    testDistanceBetweenMinAndMax(3, "1 -4 -7 7 8 11 9 -5");
    testDistanceBetweenMinAndMax(3, "0.1 -0.4 -0.7 0.7 0.8 1.1 0.9 -0.5");
    testDistanceBetweenMinAndMax(4, "9 11 21 31 41");
    testDistanceBetweenMinAndMax(3, "11 9 21 31 41");
    testDistanceBetweenMinAndMax(2, "11 21 9 31 41");
    testDistanceBetweenMinAndMax(1, "11 21 31 9 41");
    testDistanceBetweenMinAndMax(1, "11 21 31 41 9");
    testDistanceBetweenMinAndMax(4, "9 -11 -21 -31 -41");
    testDistanceBetweenMinAndMax(3, "-11 9 -21 -31 -41");
    testDistanceBetweenMinAndMax(2, "-11 -21 9 -31 -41");
    testDistanceBetweenMinAndMax(1, "-11 -21 -31 9 -41");
    testDistanceBetweenMinAndMax(1, "-11 -21 -31 -41 9");
    testDistanceBetweenMinAndMax(0, "11");
    testDistanceBetweenMinAndMax(0, "-11");

    testAllSame(true, "11 11 11 11");
    testAllSame(true, "5 5 5");
    testAllSame(false, "11 5 11 11");
    testAllSame(false, "11 11 5 11");
    testAllSame(false, "11 11 11 5");
    testAllSame(false, "5 11 11 11");
    testAllSame(false, "11 5 5 11 11");
    testAllSame(false, "11 11 5 5 11");
    testAllSame(false, "11 11 5 11 5");
    testAllSame(false, "5 5 11 11 11");
    testAllSame(false, "11 11 11 5 5");
    testAllSame(true, "11");
    testAllSame(true, "2");
    testAllSame(true, "");

    // for numUnique: array must be sorted
    testNumUnique(4, "11 21 21 21 31 41 41 41 41");
    testNumUnique(1, "11 11 11 11");
    testNumUnique(4, "11 21 31 41");
    testNumUnique(4, "11 11 11 21 31 31 31 31 41");
    testNumUnique(4, "11 11 21 21 21 31 31 41 41 41 41");
    testNumUnique(8, "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71 81 81");
    testNumUnique(8, "11 21 31 41 41 41 41 41 51 51 61 71 81");
    testNumUnique(7, "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71");
    testNumUnique(7, "11 21 31 41 41 41 41 41 51 51 61 71");
    testNumUnique(8, "-81 -81 -81 -81 -71 -61 -51 -51 -51 -51 -41 -41 -31 -21 -11 -11 -11");
    testNumUnique(3, "-11 -11 -11 0 0 11 11 11");
    testNumUnique(2, "0 11 11 11");
    testNumUnique(2, "-Infinity 11 11 11");
    testNumUnique(2, "11 11 11 Infinity");
    testNumUnique(1, "11 11");
    testNumUnique(1, "11");
    testNumUnique(0, "");

    // for removeDuplicates: array must be sorted
    testRemoveDuplicates("11", "11 11 11 11");
    testRemoveDuplicates("11 21", "11 11 21");
    testRemoveDuplicates("11 21 31 41", "11 21 31 41");
    testRemoveDuplicates("11 21 31 41", "11 11 11 21 31 31 31 31 41");
    testRemoveDuplicates("11 21 31 41", "11 21 21 21 31 41 41 41 41");
    testRemoveDuplicates("11 21 31 41", "11 11 21 21 21 31 31 41 41 41 41");
    testRemoveDuplicates("11 21 31 41 51 61 71 81", "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71 81 81");
    testRemoveDuplicates("11 21 31 41 51 61 71 81", "11 21 31 41 41 41 41 41 51 51 61 71 81");
    testRemoveDuplicates("11 21 31 41 51 61 71", "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71");
    testRemoveDuplicates("11 21 31 41 51 61 71", "11 21 31 41 41 41 41 41 51 51 61 71");
    testRemoveDuplicates("-81 -71 -61 -51 -41 -31 -21 -11", "-81 -81 -81 -81 -71 -61 -51 -51 -51 -51 -41 -41 -31 -21 -11 -11 -11");
    testRemoveDuplicates("-11 0 11", "-11 -11 -11 0 0 11 11 11");
    testRemoveDuplicates("0 11", "0 11 11 11");
    testRemoveDuplicates("-Infinity 11", "-Infinity 11 11 11");
    testRemoveDuplicates("Infinity 11", "Infinity 11 11 11");
    testRemoveDuplicates("11", "11 11");
    testRemoveDuplicates("11", "11");
    testRemoveDuplicates("", "");

    StdOut.println(cntr);
  
  
  }

  /* Test functions --- lot's of similar code! */
  
  /* A utility function to create an array of doubles from a string. */
  // The string should include a list of numbers, separated by single spaces.
  private static double[] doublesFromString(String s) {
    if ("".equals(s))
      return new double[0]; // empty array is a special case
    String[] nums = s.split(" ");
    double[] result = new double[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      try {
        result[i] = Double.parseDouble(nums[i]);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException(
            String.format("Bad argument \"%s\": could not parse \"%s\" as a double", s, nums[i]));
      }
    }
    return result;
  }
  
  private static void testMinValue(double expected, String list) {
    double[] aList = doublesFromString(list);
    double actual = fh.minValue(aList);
    if (expected != actual) {
      StdOut.print(String.format("(X) Failed minValue([%s]):\n  Expecting (%.1f)\n  Actual (%.1f)\n", list, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.println(String.format("Passed minValue([%s])", list));  
      cntr.passed();
    }
  }

  private static void testMinPosition(int expected, String list) {
    double[] aList = doublesFromString(list);
    int actual = fh.minPosition(aList);
    if (expected != actual) {
      StdOut.print(String.format("(X) Failed minPosition([%s]):\n  Expecting (%d)\n  Actual (%d)\n", list, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.println(String.format("Passed minPosition([%s])", list));  
      cntr.passed();
    }
        
  }

  private static void testDistanceBetweenMinAndMax(int expected, String list) {
    double[] aList = doublesFromString(list);
    int actual = fh.distanceBetweenMinAndMax(aList);
    if (expected != actual) {
      StdOut.print(String.format("(X) Failed distanceBetweenMinAndMax([%s]):\n  Expecting (%d)\n  Actual (%d)\n", list, expected,
        actual));
      cntr.failed();      
    }
    else {
      StdOut.println(String.format("Passed distanceBetweenMinAndMax([%s])", list));  
      cntr.passed();
    }     
  }

  private static void testAllSame(boolean expected, String list) {
    double[] aList = doublesFromString(list);
    boolean actual = fh.allSame(aList);
    if (expected != actual) {
      StdOut.print(String.format("(X) Failed allSame([%s]):\n  Expecting (%b)\n  Actual (%b)\n", list, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.println(String.format("Passed allSame([%s])", list));  
      cntr.passed();
    }         
  }

  private static void testNumUnique(int expected, String list) {
    double[] aList = doublesFromString(list);
    int actual = fh.numUnique(aList);
    if (expected != actual) {
      StdOut.print(String.format("(X) Failed numUnique([%s]):\n  Expecting (%d)\n  Actual (%d)\n", list, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.println(String.format("Passed numUnique([%s])", list));  
      cntr.passed();
    }             
  }

  private static void testRemoveDuplicates(String expected, String list) {
    double[] aList = doublesFromString(list);
    double[] actual = fh.removeDuplicates(aList);
    double[] aExpected = doublesFromString(expected);
    if (!Arrays.equals(aExpected, actual)) {
      StdOut.print(String.format("(X) Failed removeDuplicates([%s]):\n  Expecting (%s)\n  Actual (%s)\n", list,
        Arrays.toString(aExpected), Arrays.toString(actual)));
      cntr.failed();
    }
    else {
      StdOut.println(String.format("Passed removeDuplicates([%s])", list));  
      cntr.passed();
    }      
  }


}
