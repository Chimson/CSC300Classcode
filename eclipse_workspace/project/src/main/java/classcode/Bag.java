package classcode;

import java.util.Iterator;
import stdlib.*;

public class Bag<Item> implements Iterable<Item> {
 
  private class Node {
    Item item;
    Node next;
  }
  
  private Node first; 
 
  // same as push() in Stack
  public void add(Item item) { 
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }
  
  private class ListIterator implements Iterator<Item> {
    private Node current = first;
    
    public boolean hasNext() { 
      return current != null; 
    }
    
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
  
  public Iterator<Item> iterator() { 
    return new ListIterator(); 
  }
  
  public static void main(String[] args) {
    
    Bag<String> bag = new Bag<String>();
    bag.add("A");
    bag.add("B");
    bag.add("C");
    bag.add("D");
    bag.add("E");
    
    // LIFO order
    // try the iterator
    for (String b : bag) {
      StdOut.println(b);
    }
    
    Assert.that(bag.first.item.equals("E"));
    Assert.that(bag.first.next.item.equals("D"));
    Assert.that(bag.first.next.next.item.equals("C"));
    Assert.that(bag.first.next.next.next.item.equals("B"));
    Assert.that(bag.first.next.next.next.next.item.equals("A"));
  
    StdOut.println("Bag demo finished!");
  }
  
}
