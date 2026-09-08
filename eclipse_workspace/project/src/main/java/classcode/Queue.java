package classcode;
import java.util.Iterator;
import stdlib.*;

public class Queue<Item> implements Iterable<Item> {
  
  private class Node { // nested class to define nodes
    Item item;
    Node next;
  }
  
  // fields
  private Node first; // link to least recently added node
  private Node last; // link to most recently added node
  private int N; // number of items on the queue
  
  // methods
  public Queue() {
    ;
  }
  
  public boolean isEmpty() { 
    return first == null; 
  } 
  // Or: N == 0.
  
  public int size() { 
    return N;
  }
  
  public void enqueue(Item item) { // Add item to the end of the list.
    /*
      TODO: complete in class
        alias the old last node
        add to the last end of the list
        cases:
          if list began as empty, point first to the new last (now size 1)
          if list began as size >= 1, link old last to new last 
            first is unchanged here
        increase N by 1 
    */
    
  }
   
  
  public Item dequeue() { // Remove item from the beginning of the list.
    Item item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    N--;
    return item;
  }

  public Iterator<Item> iterator() { 
    return new ListIterator(); 
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;
    
    public boolean hasNext() { 
      return current != null; 
    }
    
    public void remove() {}
  
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }   
  
  public static void main(String[] args) {
  
    // test enqueue()
    Queue<Integer> qu = new Queue<>();
    Assert.that(qu.first == null);
    Assert.that(qu.last == null);
    Assert.that(qu.N == 0);
    StdOut.println("Passed: enqueue - start with empty queue");
    
    qu.enqueue(1);
    Assert.that(qu.first != null);
    Assert.that(qu.last != null);
    Assert.that(qu.first == qu.last);
    Assert.that(qu.first.item.equals(1));
    Assert.that(qu.N == 1);
    StdOut.println("Passed: enqueue - add 1");
    
    qu.enqueue(2);
    Assert.that(qu.first != null);
    Assert.that(qu.last != null);
    Assert.that(qu.first != qu.last);
    Assert.that(qu.first.item.equals(1));
    Assert.that(qu.first.next == qu.last);
    Assert.that(qu.last.next == null);
    Assert.that(qu.last.item.equals(2));
    Assert.that(qu.N == 2);
    StdOut.println("Passed: enqueue - add 2");    
    
    qu.enqueue(3);
    Assert.that(qu.first != null);
    Assert.that(qu.last != null);
    Assert.that(qu.first != qu.last);
    Assert.that(qu.first.item.equals(1));
    Assert.that(qu.first.next.item == 2);
    Assert.that(qu.first.next.next == qu.last);
    Assert.that(qu.last.item.equals(3));
    Assert.that(qu.last.next == null);
    Assert.that(qu.N == 3);
    StdOut.println("Passed: enqueue - add 3\n");   
    
    // TODO: write test to test dequeue()
    
    // quick demo
    qu = new Queue<>();
    for (int i = 0; i < 10; ++i) {
      qu.enqueue((Integer) i);
    }
    
    Assert.that(qu.size() == 10);
    
    for (Integer val: qu) {
      StdOut.println(val);
    }
    
    StdOut.println();
    
    for (int i = 0; i < 10; ++i) {
      StdOut.println(qu.dequeue());
    }
    
    Assert.that(qu.isEmpty() == true);
    
  }
  
}
