package homeworks;
import stdlib.*;

public class MutateLinkedListTests {

  private static final Counter cntr = new Counter(); 
  private static MutateLinkedList mll;
  

  public MutateLinkedListTests(MutateLinkedList mll) {
    MutateLinkedListTests.mll = mll;
  }

  public void execute() {
    mainRunTests();
  }

	private static void mainRunTests () {
	
		testDelete (1, "11 21 31 41", "[ 11 31 41 ]");
    testDelete (2, "11 21 31 41", "[ 11 21 41 ]");
    testDelete (3, "11 21 31 41", "[ 11 21 31 ]");
    testDelete (1, "11 21 31 41 51", "[ 11 31 41 51 ]");
    testDelete (2, "11 21 31 41 51", "[ 11 21 41 51 ]");
    testDelete (3, "11 21 31 41 51", "[ 11 21 31 51 ]");
    testDelete (4, "11 21 31 41 51", "[ 11 21 31 41 ]");
    testDelete (0, "11 21 31 41 51", "[ 21 31 41 51 ]");
    testDelete (0, "11", "[ ]");
    testDelete (0, "11 21 31 41", "[ 21 31 41 ]");
    testDelete (0, "", "java.lang.IllegalArgumentException");
    testDelete(-1, "11 21 31", "java.lang.IllegalArgumentException");
    testDelete (3, "11 21 31", "java.lang.IllegalArgumentException");

    testReverse ("11 21 31 41", "[ 41 31 21 11 ]");
    testReverse ("11 21 31 41 51", "[ 51 41 31 21 11 ]");
    testReverse ("11 21", "[ 21 11 ]");
    testReverse ("11 21 31", "[ 31 21 11 ]");
    testReverse ("11", "[ 11 ]");
    testReverse ("", "[ ]");

    testRemove (5, "8 11 5 5 21 31 5 5 5 41", "[ 8 11 21 31 41 ]");
    testRemove (5, "11 5 5 21 5 31 5 5 41 8", "[ 11 21 31 41 8 ]");
    testRemove (5, "11 21 5 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 5 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 5 21 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 5 5 21 31 5 5 5 41 5 5 5", "[ 11 21 31 41 ]");
    testRemove (5, "11 5 5 21 5 31 5 5 5 41 5 5 5", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 41 5", "[ 11 21 31 41 ]");
    testRemove (5, "11 5 21 5 31 5 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 5 5 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 5 5 5 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 5 5 21 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 5 5 5 21 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 5 5 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 5 5 5 41", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 41 5", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 41 5 5", "[ 11 21 31 41 ]");
    testRemove (5, "11 21 31 41 5 5 5", "[ 11 21 31 41 ]");
    testRemove (5, "5 5 11 5 5 21 5 31 5 5 5 41 5 5 5", "[ 11 21 31 41 ]");
    testRemove (5, "5 5 5 11 5 5 5 21 31 5 5 41 5 5", "[ 11 21 31 41 ]");
    testRemove (5, "5 11 21 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "5 5 11 21 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "5 5 5 11 21 31 41", "[ 11 21 31 41 ]");
    testRemove (5, "11", "[ 11 ]");
    testRemove (5, "11 21", "[ 11 21 ]");
    testRemove (5, "11 21 31", "[ 11 21 31 ]");
    testRemove (5, "5 5 5", "[ ]");
    testRemove (5, "5 5", "[ ]");
    testRemove (5, "5", "[ ]");
    testRemove (5, "", "[ ]");
    testRemove (5.1, "5.1 5.1 5.1 5 11 5.1 5.1 21 5.1 31 5.1 5.1 41 5.1 5.1 5.1", "[ 5 11 21 31 41 ]");
    StdOut.println(cntr);
	}

	static void showError (String message) {
		StdOut.println (message);
		//throw new Error (); // stops execution
	}
	
	// returns false if a test fails
	private static boolean checkInvariants (String message, MutateLinkedList list) {
		int num = 0;
		MutateLinkedList.Node firstInCycle = null;
		{
			java.util.HashSet<MutateLinkedList.Node> visited = new java.util.HashSet<>();				
			for (MutateLinkedList.Node x = list.first; x!=null; x=x.next) {
				if (visited.contains(x)) {
					firstInCycle = x;
					break;
				}
				visited.add(x);
				num++;			
			}
		}
		if (firstInCycle != null) {
			showError (String.format ("(X) Failed -\n  For %s: Node list has cycle.\n  "
				+ "Cycle starts at Node with item=%f.\n  ",
			 	  message, firstInCycle.item));
			return false;
		}
		if (num != list.N) {
			showError (String.format ("(X) Failed %s: N=%d, but there are %d Nodes.", message, list.N, num));
		  return false;
		}
		return true;
	}
	
	private static void check (String message, MutateLinkedList actual, 
	    String expected, String testname, String testargs, String origlist) {
		if (!checkInvariants (message, actual)) {
		   cntr.failed();
		   return;  // to avoid a cycle on future test
		}
		if (!expected.equals (actual.toString ())) {
			showError (String.format ("(X) Failed %s:\n  expected=%s, actual=%s", message, expected, actual.toString ()));
		  cntr.failed();
		}
		else {
		  StdOut.print(String.format("Passed %s(%s) on [%s]\n", testname, testargs, origlist));
		  cntr.passed();
		}
	}
	
	private static void testDelete (int k, String list, String expected) {
		MutateLinkedList actual = mll.from (list);
		String message = String.format ("[ %s ].delete( %d )", list, k);
		try {
			actual.delete (k);
		} 
		catch (Throwable e) {
			String exception = e.getClass().getName();
			if (! exception.equals (expected)) {
				e.printStackTrace (); // for debugging
				showError (String.format ("%s: expected=%s, actual=%s", message, expected, exception));
				cntr.failed();  // fails on unexpected exception
			}
			StdOut.print(String.format("Passed delete(%d) on [%s]\n", k, list));
			cntr.passed();  // passes on expected exception
			return;
		}
		check (message, actual, expected, "delete", Integer.toString(k), list);
	}
	
	private static void testReverse (String list, String expected) {
		MutateLinkedList actual = mll.from (list);
		actual.reverse ();
		String message = String.format ("[ %s ].reverse( )", list);
		check (message, actual, expected, "reverse", "", list);
	}
	
	private static void testRemove (double item, String list, String expected) {
		MutateLinkedList actual = mll.from (list);
		actual.remove (item);
		String message = String.format ("[ %s ].remove( %.2f )", list, item);
		check (message, actual, expected, "remove", Double.toString(item), list);
	}
	
}
