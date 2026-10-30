package homeworks;

import classcode.Assert;
import stdlib.StdOut;

public class MyPrtHeapTests {
  private static MyPrtHeap<Integer> hp;
  private static Counter cntr;

  public MyPrtHeapTests(MyPrtHeap<Integer> hp) {
    MyPrtHeapTests.hp = hp;
    cntr = new Counter();
  }

  public void execute() {

    InsertNoSwimTests();
    StdOut.println();

    InsertSwimTests();
    StdOut.println();

    delMaxTests();
    StdOut.println();

    StdOut.println(cntr);
  }

  public static void delMaxTests() {
    Integer delval;
    MyPrtHeap.Node<Integer> rootl;
    MyPrtHeap.Node<Integer> rootr;
    MyPrtHeap.Node<Integer> rootll;
    MyPrtHeap<Integer> heap = hp.create();

    try {
      heap.insert(20);
      delval = heap.delMax();

      Assert.that(delval == 20);
      Assert.that(heap.root == null);
      Assert.that(heap.size == 0);

      cntr.passed();
      StdOut.println("Tests Passed: delMax() on size 1");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 1");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 1");
      e.printStackTrace();
    }

    try {
      heap.insert(20);
      heap.insert(30);
      delval = heap.delMax();

      Assert.that(delval == 30);
      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 20);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left == null);
      Assert.that(heap.root.right == null);
      Assert.that(heap.root.isLeft == false);
      Assert.that(heap.size == 1);

      cntr.passed();
      StdOut.println("Tests Passed: delMax() on size 2");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 2");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 2");
      e.printStackTrace();
    }

    try {
      heap.insert(10);
      heap.insert(30);
      delval = heap.delMax();

      Assert.that(delval == 30);
      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 20);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right == null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 10);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left == null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      Assert.that(heap.size == 2);

      cntr.passed();
      StdOut.println("Tests Passed: delMax() on size 3");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 3");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 3");
      e.printStackTrace();
    }

    try {
      heap.insert(30);
      heap.insert(40);
      delval = heap.delMax();

      Assert.that(delval == 40);
      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 30);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 10);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left == null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 20);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left == null);
      Assert.that(rootr.right == null);
      Assert.that(rootr.isLeft == false);

      Assert.that(heap.size == 3);

      cntr.passed();
      StdOut.println("Tests Passed: delMax() on size 4");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 4");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 4");
      e.printStackTrace();
    }

    try {
      heap.insert(5);
      heap.insert(40);
      delval = heap.delMax();

      Assert.that(delval == 40);
      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 30);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 10);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left != null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 20);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left == null);
      Assert.that(rootr.right == null);
      Assert.that(rootr.isLeft == false);

      rootll = heap.root.left.left;
      Assert.that(rootll.key == 5);
      Assert.that(rootll.parent == rootl);
      Assert.that(rootll.left == null);
      Assert.that(rootll.right == null);
      Assert.that(rootll.isLeft == true);

      Assert.that(heap.size == 4);

      cntr.passed();
      StdOut.println("Tests Passed: delMax() on size 5");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 5");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: delMax() on size 5");
      e.printStackTrace();
    }

    StdOut.println(heap);
  }

  public static void InsertNoSwimTests() {
    MyPrtHeap.Node<Integer> rootl;
    MyPrtHeap.Node<Integer> rootr;
    MyPrtHeap.Node<Integer> rootll;
    MyPrtHeap.Node<Integer> rootlr;
    MyPrtHeap.Node<Integer> rootrr;
    MyPrtHeap.Node<Integer> rootrl;
    MyPrtHeap<Integer> heap = null;

    try {
      heap = hp.create();
      Assert.that(heap.root == null);
      Assert.that(heap.size == 0);

      cntr.passed();
      StdOut.println("Tests Passed: empty heap");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: empty heap");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: empty heap");
      e.printStackTrace();
    }

    try {
      heap.insert(100);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 100);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left == null);
      Assert.that(heap.root.right == null);
      Assert.that(heap.size == 1);
      Assert.that(heap.root.isLeft == false);

      cntr.passed();
      StdOut.println("Tests Passed: insert one");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert one");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert one");
      e.printStackTrace();
    }

    try {
      heap.insert(90);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 100);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right == null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 90);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left == null);
      Assert.that(rootl.right == null);
      Assert.that(heap.size == 2);
      Assert.that(rootl.isLeft == true);

      cntr.passed();
      StdOut.println("Tests Passed: insert second");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert second");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert second");
      e.printStackTrace();
    }

    try {
      heap.insert(80);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 100);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 90);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left == null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 80);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left == null);
      Assert.that(rootr.right == null);
      Assert.that(rootr.isLeft == false);

      Assert.that(heap.size == 3);

      cntr.passed();
      StdOut.println("Tests Passed: insert third");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert third");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert third");
      e.printStackTrace();
    }

    try {
      heap.insert(60);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 100);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 90);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left != null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 80);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left == null);
      Assert.that(rootr.right == null);
      Assert.that(rootr.isLeft == false);

      rootll = heap.root.left.left;
      Assert.that(rootll.key == 60);
      Assert.that(rootll.parent == rootl);
      Assert.that(rootll.left == null);
      Assert.that(rootll.right == null);
      Assert.that(rootll.isLeft == true);

      Assert.that(heap.size == 4);

      cntr.passed();
      StdOut.println("Tests Passed: insert fourth");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fourth");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fourth");
      e.printStackTrace();
    }

    try {
      heap.insert(50);
      heap.insert(40);
      heap.insert(30);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 100);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 90);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left != null);
      Assert.that(rootl.right != null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 80);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left != null);
      Assert.that(rootr.right != null);
      Assert.that(rootr.isLeft == false);

      rootll = heap.root.left.left;
      Assert.that(rootll.key == 60);
      Assert.that(rootll.parent == rootl);
      Assert.that(rootll.left == null);
      Assert.that(rootll.right == null);
      Assert.that(rootll.isLeft == true);

      rootlr = heap.root.left.right;
      Assert.that(rootlr.key == 50);
      Assert.that(rootlr.parent == rootl);
      Assert.that(rootlr.left == null);
      Assert.that(rootlr.right == null);
      Assert.that(rootlr.isLeft == false);

      rootrl = heap.root.right.left;
      Assert.that(rootrl.key == 40);
      Assert.that(rootrl.parent == rootr);
      Assert.that(rootrl.left == null);
      Assert.that(rootrl.right == null);
      Assert.that(rootrl.isLeft == true);

      rootrr = heap.root.right.right;
      Assert.that(rootrr.key == 30);
      Assert.that(rootrr.parent == rootr);
      Assert.that(rootrr.left == null);
      Assert.that(rootrr.right == null);
      Assert.that(rootrr.isLeft == false);

      Assert.that(heap.size == 7);

      cntr.passed();
      StdOut.println("Tests Passed: insert fifth, sixth, seventh");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fifth, sixth, seventh");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fifth, sixth, seventh");
      e.printStackTrace();
    }

    StdOut.println(heap);
  }

  public static void InsertSwimTests() {
    MyPrtHeap.Node<Integer> rootl;
    MyPrtHeap.Node<Integer> rootr;
    MyPrtHeap.Node<Integer> rootll;
    MyPrtHeap.Node<Integer> rootlr;
    MyPrtHeap.Node<Integer> rootlll;
    MyPrtHeap.Node<Integer> rootllr;
    MyPrtHeap.Node<Integer> rootrr;
    MyPrtHeap.Node<Integer> rootrl;
    MyPrtHeap<Integer> heap = null;

    try {
      heap = hp.create();
      Assert.that(heap.root == null);
      Assert.that(heap.size == 0);

      cntr.passed();
      StdOut.println("Tests Passed: empty heap");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: empty heap");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: empty heap");
      e.printStackTrace();
    }

    try {
      heap.insert(20);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 20);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left == null);
      Assert.that(heap.root.right == null);
      Assert.that(heap.root.isLeft == false);
      Assert.that(heap.size == 1);

      cntr.passed();
      StdOut.println("Tests Passed: insert one");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert one");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert one");
      e.printStackTrace();
    }

    try {
      heap.insert(30);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 30);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right == null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 20);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left == null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      Assert.that(heap.size == 2);

      cntr.passed();
      StdOut.println("Tests Passed: insert second");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert second");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert second");
      e.printStackTrace();
    }

    try {
      heap.insert(40);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 40);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 20);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left == null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 30);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left == null);
      Assert.that(rootr.right == null);
      Assert.that(rootr.isLeft == false);

      Assert.that(heap.size == 3);

      cntr.passed();
      StdOut.println("Tests Passed: insert third");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert third");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert third");
      e.printStackTrace();
    }

    try {
      heap.insert(60);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 60);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 40);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left != null);
      Assert.that(rootl.right == null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 30);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left == null);
      Assert.that(rootr.right == null);
      Assert.that(rootr.isLeft == false);

      rootll = heap.root.left.left;
      Assert.that(rootll.key == 20);
      Assert.that(rootll.parent == rootl);
      Assert.that(rootll.left == null);
      Assert.that(rootll.right == null);
      Assert.that(rootll.isLeft == true);

      Assert.that(heap.size == 4);

      cntr.passed();
      StdOut.println("Tests Passed: insert fourth");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fourth");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fourth");
      e.printStackTrace();
    }

    try {
      heap.insert(70);
      heap.insert(80);
      heap.insert(90);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 90);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 60);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left != null);
      Assert.that(rootl.right != null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 80);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left != null);
      Assert.that(rootr.right != null);
      Assert.that(rootr.isLeft == false);

      rootll = heap.root.left.left;
      Assert.that(rootll.key == 20);
      Assert.that(rootll.parent == rootl);
      Assert.that(rootll.left == null);
      Assert.that(rootll.right == null);
      Assert.that(rootll.isLeft == true);

      rootlr = heap.root.left.right;
      Assert.that(rootlr.key == 40);
      Assert.that(rootlr.parent == rootl);
      Assert.that(rootlr.left == null);
      Assert.that(rootlr.right == null);
      Assert.that(rootlr.isLeft == false);

      rootrl = heap.root.right.left;
      Assert.that(rootrl.key == 30);
      Assert.that(rootrl.parent == rootr);
      Assert.that(rootrl.left == null);
      Assert.that(rootrl.right == null);
      Assert.that(rootrl.isLeft == true);

      rootrr = heap.root.right.right;
      Assert.that(rootrr.key == 70);
      Assert.that(rootrr.parent == rootr);
      Assert.that(rootrr.left == null);
      Assert.that(rootrr.right == null);
      Assert.that(rootrr.isLeft == false);

      Assert.that(heap.size == 7);

      cntr.passed();
      StdOut.println("Tests Passed: insert fifth, sixth, seventh");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fifth, sixth, seventh");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert fifth, sixth, seventh");
      e.printStackTrace();
    }

    try {
      heap.insert(100);
      heap.insert(110);

      Assert.that(heap.root != null);
      Assert.that(heap.root.key == 110);
      Assert.that(heap.root.parent == null);
      Assert.that(heap.root.left != null);
      Assert.that(heap.root.right != null);
      Assert.that(heap.root.isLeft == false);

      rootl = heap.root.left;
      Assert.that(rootl.key == 100);
      Assert.that(rootl.parent == heap.root);
      Assert.that(rootl.left != null);
      Assert.that(rootl.right != null);
      Assert.that(rootl.isLeft == true);

      rootr = heap.root.right;
      Assert.that(rootr.key == 80);
      Assert.that(rootr.parent == heap.root);
      Assert.that(rootr.left != null);
      Assert.that(rootr.right != null);
      Assert.that(rootr.isLeft == false);

      rootll = heap.root.left.left;
      Assert.that(rootll.key == 90);
      Assert.that(rootll.parent == rootl);
      Assert.that(rootll.left != null);
      Assert.that(rootll.right != null);
      Assert.that(rootll.isLeft == true);

      rootlll = heap.root.left.left.left;
      Assert.that(rootlll.key == 20);
      Assert.that(rootlll.parent == rootll);
      Assert.that(rootlll.left == null);
      Assert.that(rootlll.right == null);
      Assert.that(rootlll.isLeft == true);

      rootllr = heap.root.left.left.right;
      Assert.that(rootllr.key == 60);
      Assert.that(rootllr.parent == rootll);
      Assert.that(rootllr.left == null);
      Assert.that(rootllr.right == null);
      Assert.that(rootllr.isLeft == false);

      rootlr = heap.root.left.right;
      Assert.that(rootlr.key == 40);
      Assert.that(rootlr.parent == rootl);
      Assert.that(rootlr.left == null);
      Assert.that(rootlr.right == null);
      Assert.that(rootlr.isLeft == false);

      rootrl = heap.root.right.left;
      Assert.that(rootrl.key == 30);
      Assert.that(rootrl.parent == rootr);
      Assert.that(rootrl.left == null);
      Assert.that(rootrl.right == null);
      Assert.that(rootrl.isLeft == true);

      rootrr = heap.root.right.right;
      Assert.that(rootrr.key == 70);
      Assert.that(rootrr.parent == rootr);
      Assert.that(rootrr.left == null);
      Assert.that(rootrr.right == null);
      Assert.that(rootrr.isLeft == false);

      Assert.that(heap.size == 9);

      cntr.passed();
      StdOut.println("Tests Passed: insert eighth, ninth");
    } catch (AssertionError e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert eighth, ninth");
      e.printStackTrace();
    } catch (Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed: insert eighth, ninth");
      e.printStackTrace();
    }

    StdOut.println(heap);
  }

  private static class Counter {
    private int passes;
    private int fails;

    private Counter() {
      passes = 0;
      fails = 0;
    }

    private void passed() {
      passes += 1;
    }

    private void failed() {
      fails += 1;
    }

    public String toString() {
      int total = passes + fails;
      return "\nTests Complete:\n  " + passes + "/" + total + " Tests Passed";
    }
  }
}
