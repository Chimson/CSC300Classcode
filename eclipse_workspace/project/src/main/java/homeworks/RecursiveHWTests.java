package homeworks;

import java.util.Arrays;
import stdlib.*;

public class RecursiveHWTests {
  private static RecursiveHW rhwInstance;
  private static Counter cntr;

  public RecursiveHWTests(RecursiveHW rhw) {
    RecursiveHWTests.rhwInstance = rhw;
    cntr = new Counter();
  }

  public void execute() {

    testSum("11 21 81 -41 51 61");
    testSum("11 21 81 -41 51");
    testSum("11 21 81 -41");
    testSum("11 21 81");
    testSum("11 21");
    testSum("11");
    testSum("");

    testReverse("11 21 81 -41 51 61");
    testReverse("11 21 81 -41 51");
    testReverse("11 21 81 -41");
    testReverse("11 21 81");
    testReverse("11 21");
    testReverse("11");
    testReverse("");

    testInsertToDblArray(-1, 1.0, "0 0 0 0 0 0", "0 0 0 0 0 0");
    testInsertToDblArray(0, 1.0, "0 0 0 0 0 0", "1 0 0 0 0 0");
    testInsertToDblArray(1, 1.0, "1 0 0 0 0 0", "1 1 0 0 0 0");
    testInsertToDblArray(2, 1.0, "1 1 0 0 0 0", "1 1 1 0 0 0");
    testInsertToDblArray(3, 1.0, "1 1 1 0 0 0", "1 1 1 1 0 0");
    testInsertToDblArray(4, 1.0, "1 1 1 1 0 0", "1 1 1 1 1 0");
    testInsertToDblArray(5, 1.0, "1 1 1 1 1 0", "1 1 1 1 1 1");
    testInsertToDblArray(6, 1.0, "1 1 1 1 1 1", "1 1 1 1 1 1");

    testRank(5.0, "5.0 4.0 3.0 2.0 1.0 0.0", 0);
    testRank(4.0, "5.0 4.0 3.0 2.0 1.0 0.0", 1);
    testRank(3.0, "5.0 4.0 3.0 2.0 1.0 0.0", 2);
    testRank(2.0, "5.0 4.0 3.0 2.0 1.0 0.0", 3);
    testRank(1.0, "5.0 4.0 3.0 2.0 1.0 0.0", 4);
    testRank(0.0, "5.0 4.0 3.0 2.0 1.0 0.0", 5);
    testRank(6.0, "5.0 4.0 3.0 2.0 1.0 0.0", -1);

    StdOut.println(cntr);
  }

  private static void testSum(String list) {
    double[] aList = doublesFromString(list);
    double expected = RecursiveHW.sumI(aList);
    double actual = rhwInstance.sum(aList);
    if (expected != actual) {
      StdOut.print(String.format("(X) Failed sum([%s]):\n  Expecting (%.1f)\n  Actual (%.1f)\n",
        list, expected, actual));
      cntr.failed();
    } else {
      StdOut.println(String.format("Passed sum([%s])", list));
      cntr.passed();
    }
  }

  private static void testReverse(String list) {
    double[] expected = doublesFromString(list);
    RecursiveHW.reverseI(expected);
    double[] actual = doublesFromString(list);
    rhwInstance.reverse(actual);
    if (!Arrays.equals(expected, actual)) {
      StdOut.print(String.format("(X) Failed reverse([%s]): Expecting (%s) Actual (%s)\n",
        list, Arrays.toString(expected), Arrays.toString(actual)));
      cntr.failed();
    } else {
      StdOut.println(String.format("Passed reverse([%s])", list));
      cntr.passed();
    }
  }

  private static void testInsertToDblArray(int key, double val, String list, String exlist) {
    double[] expected = doublesFromString(exlist);
    double[] actual = doublesFromString(list);
    actual = rhwInstance.insertToDblArray(key, val, actual);
    if (!Arrays.equals(expected, actual)) {
      StdOut.print(String.format("(X) Failed insertToDblArray(%d, %.2f, \n  [%s]):\n  Expecting (%s)\n  Actual (%s)\n",
        key, val, list, Arrays.toString(expected), Arrays.toString(actual)));
      cntr.failed();
    } else {
      StdOut.println(String.format("Passed insertToDblArray(%d, %.2f, \n  [%s])",
        key, val, list));
      cntr.passed();
    }
  }

  private static void testRank(double val, String list, int expected) {
    double[] dlist = doublesFromString(list);
    int actual = rhwInstance.rank(val, dlist);
    if (actual != expected) {
      StdOut.print(String.format("(X) Failed rank(%.2f, [%s]):\n  Expecting (%d)\n  Actual (%d)\n",
        val, list, expected, actual));
      cntr.failed();
    } else {
      StdOut.println(String.format("Passed rank(%.2f, [%s])",
        val, list));
      cntr.passed();
    }
  }

  private static double[] doublesFromString(String s) {
    if ("".equals(s)) return new double[0];
    String[] nums = s.split(" ");
    double[] result = new double[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      try {
        result[i] = Double.parseDouble(nums[i]);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException(String.format("Bad argument \"%s\": could not parse \"%s\" as a double",
          s, nums[i]));
      }
    }
    return result;
  }

}
