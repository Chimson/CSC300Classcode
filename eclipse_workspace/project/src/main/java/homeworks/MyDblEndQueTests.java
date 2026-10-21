package homeworks;
import stdlib.*;
import java.util.NoSuchElementException;

public class MyDblEndQueTests {

  private static MyDblEndQue mdeq;

  private static final Counter cntr = new Counter(); 
  
  private static Counter fail_cntr = new Counter();

  public MyDblEndQueTests(MyDblEndQue mdeq) {
    MyDblEndQueTests.mdeq = mdeq;
  }

  public void execute() {
	  MyDblEndQue d0, d1, d2, d3;
	  double k;
	  
	  // =====
	  // push/pop tests
	  // =====
	  d0 = mdeq.newQue();
	  checkQ(d0, "[ ]", "empty queue");
	  try {
	    d0.popRight();
	    cntr.failed();
	    StdOut.println("(X) Failed popRight() throws NoSuchElementException when empty");
	  } 
	  catch(NoSuchElementException e) {
	    cntr.passed();
	    StdOut.println("Passed popRight() throws NoSuchElementException when empty");
	  }
	  catch(Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed popRight() throws an Exception when empty");
      e.printStackTrace();
	  }
	  
	  d0 = mdeq.newQue();
    checkQ(d0, "[ ]", "empty queue");
    try {
      d0.popLeft();
      cntr.failed();
      StdOut.println("(X) Failed popLeft() throws NoSuchElementException when empty");
    } 
    catch(NoSuchElementException e) {
      cntr.passed();
      StdOut.println("Passed popLeft() throws a NoSuchElementException when empty");
    }
    catch(Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed popRight() throws an Exception when empty");
      e.printStackTrace();
    }
	  
	  d1 = mdeq.newQue(); 
	  checkQ(d1, "[ ]", "empty queue");
	  d1.pushLeft(11);
    checkQ(d1, "[ 11 ]", "pushLeft(11)");
	  d1.pushLeft(12);
	  
	  checkQ(d1, "[ 12 11 ]", "pushLeft(12)");
	  d1.pushLeft(13);
    checkQ(d1, "[ 13 12 11 ]", "pushLeft(13)");
	  
	  k = popLeftNoExc(d1);
	  myAssert(k == 13, "popLeft() returns 13");
	  checkQ(d1, "[ 12 11 ]", "popLeft()");
	  k = popLeftNoExc(d1);
	  myAssert(k == 12, "popLeft() returns 12");
	  checkQ(d1, "[ 11 ]", "popLeft()");
	  k = popLeftNoExc(d1);
    myAssert(k == 11, " popLeft() returns 1");	  
	  checkQ(d1, "[ ]", "popLeft()");
	  
	  d1 = mdeq.newQue();
	  d1.pushRight(11);
	  checkQ(d1, "[ 11 ]", "pushRight(11)");
    d1.pushRight(12);
    checkQ(d1, "[ 11 12 ]", "pushRight(12)");
    d1.pushRight(13);
    checkQ(d1, "[ 11 12 13 ]", "pushRight(13)");
    
    k = popRightNoExc(d1);
    myAssert(k == 13, " popRight() returns 13");
    checkQ(d1, "[ 11 12 ]", "popRight()");
    k = popRightNoExc(d1);
    myAssert(k == 12, " popRight() returns 12");
    checkQ(d1, "[ 11 ]", "popRight()");
    k = popRightNoExc(d1);
    myAssert(k == 11, " popRight() returns 11");
    checkQ(d1, "[ ]", "popRight()");
	  
	  d1 = mdeq.newQue();
    d1.pushLeft(11);
    checkQ(d1, "[ 11 ]", "pushLeft(11)");
    d1.pushRight(21);
    checkQ(d1, "[ 11 21 ]", "pushRight(21)");
    d1.pushLeft(12);
    checkQ(d1, "[ 12 11 21 ]", "pushLeft(12)");
    d1.pushRight(22);
    checkQ(d1, "[ 12 11 21 22 ]", "pushRight(22)");
	  
	  k = popLeftNoExc(d1);
    myAssert(k == 12, " popRight() returns 12");
    checkQ(d1, "[ 11 21 22]", "popRight()");
    k = popLeftNoExc(d1);
    myAssert(k == 11, " popRight() returns 11");
    checkQ(d1, "[ 21 22 ]", "popRight()");
    k = popLeftNoExc(d1);
    myAssert(k == 21, " popRight() returns 21");
    checkQ(d1, "[ 22 ]", "popRight()");
    k = popLeftNoExc(d1);
    myAssert(k == 22, " popRight() returns 22");
    checkQ(d1, "[ ]", "popRight()");
    
    d1 = mdeq.newQue();
    d1.pushLeft(11);
    checkQ(d1, "[ 11 ]", "pushLeft(11)");
    d1.pushRight(21);
    checkQ(d1, "[ 11 21 ]", "pushRight(21)");
    d1.pushLeft(12);
    checkQ(d1, "[ 12 11 21 ]", "pushLeft(12)");
    d1.pushRight(22);
    checkQ(d1, "[ 12 11 21 22 ]", "pushRight(22)");
    
    
    k = popRightNoExc(d1);
    myAssert(k == 22, " popRight() returns 22");
    checkQ(d1, "[ 12 11 21 ]", "popRight()");
    k = popRightNoExc(d1);
    myAssert(k == 21, " popRight() returns 21");
    checkQ(d1, "[ 12 11 ]", "popRight()");
    k = popRightNoExc(d1);
    myAssert(k == 11, " popRight() returns 11");
    checkQ(d1, "[ 12 ]", "popRight()");
    k = popRightNoExc(d1);
    myAssert(k == 12, " popRight() returns 12");
    checkQ(d1, "[ ]", "popRight()");
    
    d1 = mdeq.newQue();
    d1.pushRight(21);
    checkQ(d1, "[ 21 ]", "pushRight()");
    d1.pushLeft(11);
    checkQ(d1, "[ 11 21 ]", "pushLeft()");
    k = popLeftNoExc(d1);
    myAssert(k == 11, " popLeft() returns 11");
    checkQ(d1, "[ 21 ]", "popLeft()");
    d1.pushRight(22);
    checkQ(d1, "[ 21 22 ]", "pushRight()");

    d1 = mdeq.newQue();
    d1.pushRight(21);
    checkQ(d1, "[ 21 ]", "pushRight()");
    d1.pushRight(22);
    checkQ(d1, "[ 21 22 ]", "pushRight()");
    d1.pushLeft(11);
    checkQ(d1, "[ 11 21 22 ]", "pushLeft()");
    k = popLeftNoExc(d1);
    myAssert(k == 11, " popLeft() returns 11");
    checkQ(d1, "[ 21 22 ]", "popLeft()");
    k = popLeftNoExc(d1);
    myAssert(k == 21, " popLeft() returns 21");
    checkQ(d1, "[ 22 ]", "popLeft()");
    d1.pushLeft(12);
    checkQ(d1, "[ 12 22 ]", "pushLeft()");
 
    
    
    // ===== 
    // concat tests
    // =====
    

    
    d1 = mdeq.newQue();
    d1.concat(mdeq.newQue());
    checkQ(d1, "[ ]", "[ ].concat([ ])");
    d1.pushLeft(11);
    d1.concat(mdeq.newQue());
    checkQ(d1, "[ 11 ]", "[ 11 ].concat([ ])");
    
    d1 = mdeq.newQue();
    d2 = mdeq.newQue();
    d2.pushLeft(11);
    d1.concat(d2);
    checkQ(d1, "[ 11 ]", "[ ].concat([ 11 ])");
    checkQ(d2, "[ ]", "d2 is [ ]");
   
	  d1 = mdeq.newQue ();
    d2 = mdeq.newQue ();
    d1.pushLeft(11);
    d1.pushLeft(12);
    d2.pushLeft(21);
    d2.pushLeft(22);
    d1.concat(d2);
    checkQ(d1, "[ 12 11 22 21 ]", "[12 11].concat([22 11])");
    checkQ(d2, "[ ]", "d2 is [ ]");
    d2.concat(d1);
    checkQ(d2, "[ 12 11 22 21 ]", "[ ].concat([ 12 11 22 21])");
    checkQ(d1, "[ ]", "d1 is [ ]");
    
    d1 = mdeq.newQue();
    for (int i = 10; i < 13; i++) { 
      d1.pushLeft(i);
    }
    for (int i = 20; i < 23; i++) { 
      d1.pushRight(i); 
    }
    checkQ(d1, "[ 12 11 10 20 21 22 ]", "d1 is [12 11 10 20 21 22]");
    d2 = mdeq.newQue();
    d1.concat(d2);
    checkQ(d1, "[ 12 11 10 20 21 22 ]", "[12 11 10 20 21 22].concat([ ])");
    checkQ(d2, "[ ]", "d2 is [ ]");    
	  
    for (int i = 30; i < 33; i++) { 
      d2.pushLeft (i);  
    }
    for (int i = 40; i < 43; i++) { 
      d2.pushRight (i);  
    }
    checkQ(d2, "[ 32 31 30 40 41 42 ]", "d2 is [32 31 30 40 41 42]");

    d3 = mdeq.newQue();
    d2.concat(d3);
    checkQ(d2, "[ 32 31 30 40 41 42 ]", "[32 31 30 40 41 42],concat([ ])");
    checkQ(d3, "[ ]", "d3 is [ ]");

    d1.concat(d2);
    checkQ(d1, "[ 12 11 10 20 21 22 32 31 30 40 41 42 ]", 
    	"[ 12 11 10 20 21 22 ].concat([ 32 31 30 40 41 42 ])");
    checkQ(d2, "[ ]", "d2 is [ ]");
    for (int i = 0; i < 12; i++) { 
      popLeftNoExc(d1);
    }
    checkQ(d1, "[ ]", "d1 is [ ]");
   
	  
    // ===== 
    // delete tests
    // =====
    
    d0 = mdeq.newQue();
    for (double i = 10.0; i < 15.0; i += 1.0) {
      d0.pushLeft(i);
    }
  
    checkDeleteExc(-1);
    checkDeleteExc(5);

    d1 = mdeq.newQue ();
    d1.pushLeft(11);
    k = deleteNoExc(d1,0, 1);
    myAssert(k == 11, " delete(0) returns 11");
    checkQ(d1, "[ ]", "delete(0)");
    for (int i = 10; i < 20; i++) { 
      d1.pushRight(i);
    }
    k = deleteNoExc(d1, 0, 10);
    myAssert(k == 10, " delete(0) returns 10");
    checkQ(d1, "[ 11 12 13 14 15 16 17 18 19 ]", "delete(0)");
    k = deleteNoExc(d1, 8, 9);    
    myAssert(k == 19, " delete(8) returns 19");    
    checkQ(d1, "[ 11 12 13 14 15 16 17 18 ]", "delete(8)");
    k = deleteNoExc(d1, 4, 8);
    myAssert(k == 15, " delete(4) returns 15");    
    checkQ(d1, "[ 11 12 13 14 16 17 18 ]", "delete(4)");
    k = deleteNoExc(d1, 3, 7);
    myAssert(k == 14, " delete(3) returns 14");   
    checkQ(d1, "[ 11 12 13 16 17 18 ]", "delete(3)");
    k = deleteNoExc(d1, 0, 6);
    myAssert(k == 11, " delete(0) returns 11");   
    checkQ(d1, "[ 12 13 16 17 18 ]", "delete(0)");
    k = deleteNoExc(d1, 4, 5);
    myAssert(k == 18, " delete(4) returns 18");    
    checkQ(d1, "[ 12 13 16 17 ]", "delete(4)");
    k = deleteNoExc(d1, 3, 4);
    myAssert(k == 17, " delete(3) returns 17");    
    checkQ(d1, "[ 12 13 16 ]", "delete(3)");
    k = deleteNoExc(d1, 1, 3);
    myAssert(k == 13, " delete(1) returns 13");    
    checkQ(d1, "[ 12 16 ]", "delete(1)");
    k = deleteNoExc(d1, 1, 2);
    myAssert(k == 16, " delete(1) returns 16");    
    checkQ(d1, "[ 12 ]", "delete(1)");
    k = deleteNoExc(d1, 0, 1);
    myAssert(k == 12, " delete(0) returns 12");    
    checkQ(d1, "[ ]", "delete(0)");
    
	  StdOut.println(cntr);

  }

	private static void checkDeleteExc(int k) {
    try {
      MyDblEndQue d0 = mdeq.newQue();
      for (double val = 10.0; val < 15.0; val += 1.0) {
        d0.pushRight(val);
      }
      d0.delete(k);
      cntr.failed();
      StdOut.println("(X) Failed delete(" + k +") throws IllegalArgumentException when empty");
    } 
    catch(IllegalArgumentException e) {
      cntr.passed();
      StdOut.println("Passed delete(" + k +") throws an IllegalArgumentException when empty");
    }
    catch(Exception e) {
      cntr.failed();
      StdOut.println("(X) Failed delete(" + k +")  throws an Exception when empty");
      e.printStackTrace();
    }
	}
	
	private static double popRightNoExc(MyDblEndQue q) {
    
    int oldN = q.N;
    try {
      return q.popRight();
    }
    catch (NoSuchElementException e) {
      q.N = 1;
      double k = q.popRight();
      q.N = oldN;
      return k;
    }
	}
	
	 private static double popLeftNoExc(MyDblEndQue q) {
    
    int oldN = q.N;
    try {
      return q.popLeft();
    }
    catch (NoSuchElementException e) {
      q.N = 1;
      double k = q.popLeft();
      q.N = oldN;
      return k;
    }
  }
  
  private static double deleteNoExc(MyDblEndQue q, int k, int correctN) {
    
    try {
      return q.delete(k);
    }
    catch (IllegalArgumentException e) {
      int oldN = q.N;
      q.N = correctN;
      double ret = q.delete(k);
      q.N = oldN;
      return ret;
    }
  }
	
	private static void checkQ(MyDblEndQue q, String items, String passmsg) {
	  
	  fail_cntr = new Counter();
	  
	  if (items.equals("[ ]")) {
	    myAssert(q.first == null, " " + items + ", first == null");
	    myAssert(q.last == null, " " + items + ", last == null");
	    myAssert(q.N == 0, " " + items + ", N == 0");
	    if (fail_cntr.getFails() == 0) {
	      StdOut.println("Passed " + passmsg);
	    }
	    return;
	  }
	  
	  String[] items_arr = items
	    .substring(2, items.length() - 1)
	    .split(" ");
	  
    if (items_arr.length == 1) {
      if (q.first == null) {
        myAssert(q.first != null, " " + items + ", first != null");
        myAssert(false, " " + items + ", first == last");
        myAssert(false, " " + items + ", first.next == null");
        myAssert(false, " " + items + ", first.prev == null");
        myAssert(q.N == 1, " " + items + ", N == 1");
        if (fail_cntr.getFails() == 0) {
          StdOut.println("Passed " + passmsg);
        }
        return;
      }
      else {
        myAssert(q.first != null, " " + items + ", first != null");
        myAssert(q.first == q.last, " " + items + ", first == last");
        myAssert(q.first.next == null, " " + items + ", first.next == null");
        myAssert(q.first.prev == null, " " + items + ", first.prev == null");
        myAssert(q.N == 1, " " + items + ", N == 1");
        if (fail_cntr.getFails() == 0) {
          StdOut.println("Passed " + passmsg);
        }        
        return;
      }
    } 
    
    
    // items_arr.length >= 2
    // check next's and first and last pointers
    MyDblEndQue.Node cur = q.first;
    for (int i = 0; i < items_arr.length; ++i) { 
      
      if (i == 0) {
        myAssert(cur == q.first, " " + items + ", cur == first");
      }
      if (i == items_arr.length - 1) {
        myAssert(cur == q.last, " " + items + ", cur == last");
      }
          
      if (cur == null) {
        myAssert(cur != null, " " + items + ", cur != null");
        myAssert(false, " " + items + ", cur.item == " + items_arr[i]);
      } 
      else {
        myAssert(cur != null, " " + items + ", cur != null");
        myAssert(cur.item == Double.parseDouble(items_arr[i]), 
          " " + items + ", cur.item == " + items_arr[i]); 
        cur = cur.next;  
      }     
    }
    
    // check prev's and first and last pointers
    cur = q.last;
    for (int i = items_arr.length - 1; i > -1; --i) { 
      if (i == 0) {
        myAssert(cur == q.first, " " + items + ", cur == first");
      }
      if (i == items_arr.length - 1) {
        myAssert(cur == q.last, " " + items + ", cur == last");
      }          
      if (cur == null) {
        myAssert(cur != null, " " + items + ", cur != null");
        myAssert(false, " " + items + ", cur.item == " + items_arr[i]);
      } 
      else {
        myAssert(cur != null, " " + items + ", cur != null");
        myAssert(cur.item == Double.parseDouble(items_arr[i]), 
          " " + items + "cur.item == " + items_arr[i]); 
        cur = cur.prev;  
      }     
    }
    
    // check N
    myAssert(q.N == items_arr.length, " " + items + ", N == " + items_arr.length);
    if (fail_cntr.getFails() == 0) {
      StdOut.println("Passed " + passmsg);
    }

	}
	
	private static void myAssert(boolean expr, String msg) {
	  if (expr) {
	    cntr.passed();
	  }
	  else {
	    StdOut.println("(X) Failed" + msg);
	    cntr.failed();
	    fail_cntr.failed();
	    try {
	      throw new AssertionError();
	    }
	    catch (AssertionError e) {
	      e.printStackTrace(System.out);
	    }
	  }
	}


}
