package homeworks;
import stdlib.*;



public class LinkedListTests {

  private static final Counter cntr = new Counter(); 
  
  private static LinkedListHW ll;
 
  public  LinkedListTests(LinkedListHW ll) {
    LinkedListTests.ll = ll;
  }

  public void execute() {
  
    testSize (2, "11 21");  
    testSize (4, "11 -21.2 31 41");
    testSize (1, "11");
    testSize (0, ""); 
    
    testSumPositiveElements (104, "11 -3 -4 21 31 41 -1");
    testSumPositiveElements (104, "11 -3 -4 21 31 -1 41");
    testSumPositiveElements (0, "-11.2");
    testSumPositiveElements (52, "11 -21 -31 41");
    testSumPositiveElements (0, "");
    testSumPositiveElements (11, "11");
    
    testLengthOfCommonPrefix (3, "11 21 31 41 41", "11 21 31 5 41");
    testLengthOfCommonPrefix (3, "11 21 31 41 41 51", "11 21 31 5 41 51");
    testLengthOfCommonPrefix (3, "11 21 31 41 5", "11 21 31 5 41");
    testLengthOfCommonPrefix (3, "11 21 31 5 41", "11 21 31 41 5");
    testLengthOfCommonPrefix (2, "11 21 31 41 5", "11 21 5 31 41");
    testLengthOfCommonPrefix (2, "11 21 5 31 41", "11 21 31 41 5");
    testLengthOfCommonPrefix (1, "11 21 31 41 5", "11 5 21 31 41");
    testLengthOfCommonPrefix (1, "11 5 21 31 41", "11 21 31 41");
    testLengthOfCommonPrefix (0, "11 21 31 41", "5 11 21 31 41");
    testLengthOfCommonPrefix (0, "5 11 21 31 41", "11 21 31 41");
    testLengthOfCommonPrefix (3, "11 21 31 41", "11 21 31 5 41");
    testLengthOfCommonPrefix (3, "11 21 31", "11 21 31");
    testLengthOfCommonPrefix (3, "11 21 31", "11 21 31 41");
    testLengthOfCommonPrefix (2, "11 21 31 41", "11 21");
    testLengthOfCommonPrefix (1, "11", "11 21 31 41");
    testLengthOfCommonPrefix (1, "11", "11");
    testLengthOfCommonPrefix (0, "11", "5");
    testLengthOfCommonPrefix (0, "11 21 31 41", "");
    testLengthOfCommonPrefix (0, "", "11 21 31 41");
    testLengthOfCommonPrefix (0, "", "");
    testLengthOfCommonPrefix (0, "", "11 21 31");

    testIsIncreasing(true,  "11 21 31 41");
    testIsIncreasing(true,  "11 21 31 41 51");
    testIsIncreasing(false, "11 21 21 31 41 51");
    testIsIncreasing(false, "11 21 5 31 41 51");
    testIsIncreasing(false, "11 21 5 31 41 51");
    testIsIncreasing(false, "11 21 31 5 41 51");
    testIsIncreasing(false, "11 21 31 41 5 51");
    testIsIncreasing(false, "11 21 31 41 51 5");
    testIsIncreasing(false, "11 21 5 31 41");
    testIsIncreasing(false, "11 5 21 31 41");
    testIsIncreasing(false, "11 21 31 5 41");
    testIsIncreasing(false, "11 21 31 41 5");
    testIsIncreasing(false, "11 5");
    testIsIncreasing(true,  "11 21");
    testIsIncreasing(true,  "11");
    testIsIncreasing(true,  "");
    
    testEvenIndicesIncreasing(true,  "11 0 21 11 31 0 41 0");
    testEvenIndicesIncreasing(true,  "11 0 21 11 31 0 41");
    testEvenIndicesIncreasing(true,  "-41 0 -31 11 -21 0 -11");
    testEvenIndicesIncreasing(false, "11 0 21 0 5 11 31 0 41");
    testEvenIndicesIncreasing(false, "11 0 21 0 21 11 31 0 41");
    testEvenIndicesIncreasing(false, "-41 0 -31 11 21 0 -11");
    testEvenIndicesIncreasing(true,  "-21 -11 31");
    testEvenIndicesIncreasing(false, "11 -3 -4 21 31 41 -1");   
    testEvenIndicesIncreasing(false, "11 -21 -31 41");    
    testEvenIndicesIncreasing(false, "11 -3 -4 21 31 -1 41");   
    testEvenIndicesIncreasing(true,  "11 1 21 -2 31 -3");
    testEvenIndicesIncreasing(false, "11 1 21 -2 31 -3 5");
    testEvenIndicesIncreasing(true,  "11 1 21 -2 31");
    testEvenIndicesIncreasing(false, "11 1 21 -2 5 -3");
    testEvenIndicesIncreasing(true,  "11 1 21 -2");
    testEvenIndicesIncreasing(true,  "11 1 21");
    testEvenIndicesIncreasing(true,  "11 1");
    testEvenIndicesIncreasing(true,  "11");
    testEvenIndicesIncreasing(true,  "-11");
    testEvenIndicesIncreasing(true,  "");

    testDeleteFirst ("21 31", "11 21 31");  
    testDeleteFirst ("21 11", "31 21 11");
    testDeleteFirst ("21", "11 21");  
    testDeleteFirst ("", "11");
    testDeleteFirst ("", "");
    
    StdOut.println(cntr);

  }


  // lots of copy and paste in these test!
  // checks if the list changes first then checks the method results
  private static void testSize (int expected, String sList) {
    var list = ll.from (sList);
    String sStart = list.toString ();
    int actual = list.size();
    String sEnd = list.toString ();
    if (! sStart.equals (sEnd)) {
      StdOut.print(String.format("(X) Failed %s.size():\n  List changed to %s\n", sStart, sEnd));
      cntr.failed();
    }
    else if (expected != actual) {
      StdOut.print(String.format("(X) Failed %s.size():\n  Expecting (%d) Actual (%d)\n", sStart, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.print(String.format("Passed size(%s)\n", sStart));
      cntr.passed();
    }
  } 
  private static void testSumPositiveElements (double expected, String sList) {
    var list = ll.from (sList);
    String sStart = list.toString ();
    double actual = list.sumPositiveElements ();
    String sEnd = list.toString ();
    if (!sStart.equals (sEnd)) {
      StdOut.print(String.format("(X )Failed %s.sumPositiveElements():\n  List changed to %s\n", sStart, sEnd));
      cntr.failed();
    }
    else if (expected != actual) {
      StdOut.print(String.format("(X) Failed %s.sumPositiveElements():\n  Expecting (%f) Actual (%f)\n", sStart, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.print(String.format("Passed sumPositiveElements(%s)\n", sStart));
      cntr.passed();      
    }
  }
  
  // does not check if the list was modified, since it is supposed to
  private static void testDeleteFirst (String expected, String sList) {
    String sExpected = ll.from (expected).toString ();
    var list = ll.from (sList);
    list.deleteFirst ();
    String sEnd = list.toString ();
    if (! sExpected.equals (sEnd)) {
      StdOut.print(String.format("(X) Failed [%s].deleteFirst():\n  Expecting %s Actual %s\n", sList, sExpected, sEnd));
      cntr.failed();
    }
    else {
      StdOut.print(String.format("Passed deleteFirst([%s])\n", sList));
      cntr.passed();        
    }
  }
  
  private static void testIsIncreasing(boolean expected, String sList) {
    var list = ll.from (sList);
    String sStart = list.toString ();
    boolean actual = list.isIncreasing ();
    String sEnd = list.toString ();
    if (!sStart.equals (sEnd)) {
      StdOut.print(String.format("(X) Failed %s.isIncreasing():\n  List changed to %s\n", sStart, sEnd));
      cntr.failed();
    }
    else if (expected != actual) {
      StdOut.print(String.format("(X) Failed %s.isIncreasing():\n  Expecting (%b) Actual (%b)\n", sStart, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.print(String.format("Passed isIncreasing([%s])\n", sList));
      cntr.passed();
    }
  }
  private static void testEvenIndicesIncreasing(boolean expected, String sList) {
    var list = ll.from (sList);
    String sStart = list.toString ();
    boolean actual = list.evenIndicesIncreasing();
    String sEnd = list.toString();
    if (!sStart.equals (sEnd)) {
      StdOut.print(String.format("(X) Failed %s.evenIndicesIncreasing():\n  List changed to %s\n", sStart, sEnd));
      cntr.failed();
    }
    else if (expected != actual) {
      StdOut.print(String.format("(X) Failed %s.evenIndicesIncreasing():\n  Expecting (%b) Actual (%b)\n", sStart, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.print(String.format("Passed evenIndicesIncreasing([%s])\n", sList));
      cntr.passed();    
    }
  }
  private static void testLengthOfCommonPrefix(int expected, String sList1, String sList2) {
    LinkedListHW list1 = ll.from (sList1);
    LinkedListHW list2 = ll.from (sList2);
    String sStart1 = list1.toString ();
    String sStart2 = list2.toString ();
    int actual = list1.lengthOfCommonPrefix(list2);
    String sEnd1 = list1.toString ();
    String sEnd2 = list2.toString ();
    if (!sStart1.equals (sEnd1)) {
      StdOut.print(String.format("(X) Failed %s.lengthOfCommonPrefix(%s):\n  List changed to %s\n", sStart1, sStart2, sEnd1));
      cntr.failed();
    }
    else if (!sStart2.equals (sEnd2)) {
      StdOut.print(String.format("(X) Failed %s.lengthOfCommonPrefix(%s):\n  List changed to %s\n", sStart1, sStart2, sEnd2));
      cntr.failed();
    }
    else if (expected != actual) {
      StdOut.print(String.format("(X) Failed %s.lengthOfCommonPrefix(%s):\n  Expecting (%d) Actual (%d)\n", sStart1, sStart2, expected, actual));
      cntr.failed();
    }
    else {
      StdOut.print(String.format("Passed lengthOfCommonPrefix(\n  [%s], [%s])\n", sList1, sList2));
      cntr.passed();  
    }
  }
  
}
