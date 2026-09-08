package classcode;
import stdlib.StdOut;

// Can add to bags but not remove
// usually add to the top like a stack, but we will add at index
// just using doubles this time, no generic T like SearchableStack
public class IndexBagDbls {
  
  private class Node {
    public Node() {};
    public double item;
    public Node next;
  }
  
  // fields   
  private Node first;
  private Node last;
  private int N;

  public IndexBagDbls() {
    // by default sets first, last = null, size = 0, works for empty case
  }
  
  // push to last in the list
  // same as enqueue to a queue
  public void addLast(double item) {
 
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    
    // when empty
    if (oldlast == null) {
      first = last;
    }
    else {  
      // when non-empty
      oldlast.next = last;
    }
    ++N;
  }
  
 /*
    TODO: Complete in class
     Add item to a new node at index i
    
      Write using a recursive helper
        need to add prev, cur, and current index i parameters
      Cases:
        If the list is empty at given index 0: add first node
          any other index do nothing
        If you find an existing node at search index (size > 1)
          If its at index 0, add to the front like stack
          anywhere else then connect it between prev and cur
        Check the next node when cur node exists and index is not found
        Add to the null end of the list when the index is found there
          can use addLast
        Searched past the list and invalid index then do nothing
        Don't forget to increment N when adding a node    
    FIX: second to last test should say "add past existing nodes size > 1"
  */
  public void addItemAtIndex(double item, int index) {
  }

  // test here
  public static void main(String[] args) {    
    
    // declare a reusable variable
    Node first;
    Node second;
    Node third;
    Node fourth;
   
    // ==== test addLast() ====
    IndexBagDbls bag = new IndexBagDbls();
    Assert.that(bag.first == null);
    Assert.that(bag.last == null);
    Assert.that(bag.N == 0);
    
    // add one item
    bag.addLast(3.0);  
    Assert.that(bag.first != null);
    Assert.that(bag.first.item == 3.0);
    Assert.that(bag.first.next == null);
    Assert.that(bag.last == bag.first);
    Assert.that(bag.N == 1);
    
     // add second item (other adds are this case)
    bag.addLast(5.5);
    Assert.that(bag.first != null);
    Assert.that(bag.first.item == 3.0);
    Assert.that(bag.first.next != null);
    second = bag.first.next;
    Assert.that(second.item == 5.5);
    Assert.that(second.next == null);
    Assert.that(bag.last == second);
    Assert.that(bag.N == 2);
    
    // add a few more, check in debugger
    // didn't add tests since theres only empty or nonempty case
    bag.addLast(10.12);
    bag.addLast(-3.14);
    bag.addLast(15.444);
    // [3.0, 5.5, 10.12, -3.14, 15.44]
    
    // ==== test addItemAt() ====
    
    // empty so add at only index 0
    bag = new IndexBagDbls();
    bag.addItemAtIndex(3.0, 0);
    Assert.that(bag.first != null);
    Assert.that(bag.first.item == 3.0);   
    Assert.that(bag.last != null);
    Assert.that(bag.first == bag.last);
    Assert.that(bag.N == 1);
    StdOut.println("Passed: addItemAtIndex - index 0 on empty list");
    // []
    
    // add at invalid index does nothing
    bag.addItemAtIndex(6.7, 2);
    Assert.that(bag.first != null);
    Assert.that(bag.first.item == 3.0);
    Assert.that(bag.first.next == null);
    Assert.that(bag.last == bag.first);
    Assert.that(bag.N == 1);
    StdOut.println("Passed: addItemAtIndex - invalid index on list size 1");
    // [3.0]
    
    // add to the 0th index from size 1
    bag.addItemAtIndex(6.7, 0);
    Assert.that(bag.first != null);
    first = bag.first;
    Assert.that(first.item == 6.7);
    Assert.that(first.next != null);
    second = bag.first.next;
    Assert.that(second.item == 3.0);
    Assert.that(second.next == null);
    Assert.that(bag.last == second);
    Assert.that(bag.N == 2);
    StdOut.println("Passed: addItemAtIndex - add to the front size 1");
    // [6.7, 3.0]
    
    // add to 0th index from size 2
    bag.addItemAtIndex(4.4, 0);
    Assert.that(bag.first != null);
    first = bag.first;
    Assert.that(first.item == 4.4);
    Assert.that(first.next != null);
    second = first.next;
    Assert.that(second.item == 6.7);
    Assert.that(second.next != null);
    third = second.next;
    Assert.that(third.item == 3.0);
    Assert.that(third.next == null);
    Assert.that(bag.last == third);
    Assert.that(bag.N == 3);
    StdOut.println("Passed: addItemAtIndex - add to the front size > 1");
    // [4.4, 6.7, 3.0]

    // add to index 1 from size 2
    // [6.7, 3.0]    
    bag = new IndexBagDbls();
    bag.addLast(6.7);
    bag.addLast(3.0);
    bag.addItemAtIndex(4.4, 1);
    Assert.that(bag.first != null);
    first = bag.first;
    Assert.that(first.item == 6.7);
    Assert.that(first.next != null);
    second = first.next;
    Assert.that(second.item == 4.4);
    Assert.that(second.next != null);
    third = second.next;
    Assert.that(third.item == 3.0);
    Assert.that(third.next == null);
    Assert.that(bag.last == third);
    Assert.that(bag.N == 3);
    StdOut.println("Passed: addItemAtIndex - add to the end of list size > 1");
    // [6.7, 4.4, 3.0]

    // add to index 2 (past last existing node) from size 2
    // [6.7, 3.0]    
    bag = new IndexBagDbls();
    bag.addLast(6.7);
    bag.addLast(3.0);
    bag.addItemAtIndex(4.4, 2);
    Assert.that(bag.first != null);
    first = bag.first;
    Assert.that(first.item == 6.7);
    Assert.that(first.next != null);
    second = first.next;
    Assert.that(second.item == 3.0);
    Assert.that(second.next != null);
    third = second.next;
    Assert.that(third.item == 4.4);
    Assert.that(third.next == null);
    Assert.that(bag.last == third);
    Assert.that(bag.N == 3);
    StdOut.println("Passed: addItemAtIndex - add past existing nodes size > 1");
    // [6.7, 3.0, 4.4]
    
    // add to index 1 from size 3
    bag.addItemAtIndex(2.2, 1);
    Assert.that(bag.first != null);
    first = bag.first;
    Assert.that(first.item == 6.7);
    Assert.that(first.next != null);
    second = first.next;
    Assert.that(second.item == 2.2);
    Assert.that(second.next != null);
    third = second.next;
    Assert.that(third.item == 3.0);
    Assert.that(third.next != null);
    fourth = third.next;
    Assert.that(fourth.item == 4.4);
    Assert.that(fourth.next == null);
    Assert.that(bag.last == fourth);
    Assert.that(bag.N == 4);
    StdOut.println("Passed: addItemAtIndex - add to the middle size > 1");
    // [6.7, 2.2, 4.4, 3.0]
    
    StdOut.println("Tests complete");   
    
      
  }
}
